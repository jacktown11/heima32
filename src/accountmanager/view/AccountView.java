package accountmanager.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import accountmanager.controller.AccountController;
import accountmanager.domain.AccountItem;
import accountmanager.domain.QueryCondition;

public class AccountView {
	private final static String NAV_STR = "todo";
	private final static String DELETE = "delete";
	private final static String UPDATE = "update";
	private final static String ADD = "add";
	private final static String QUERY = "query";
	
	private static AccountController ctrl = new AccountController();
	
	public static void main(String[] args) {
		
		// http://localhost:8001/api?todo=update&aid=4&aname=x&atype=收入&amount=3.25&paymethod=xxx&createtime=2018-7-29&description=abcd
		
		// http://localhost:8001/api?todo=delete&aid=4
		
		// http://localhost:8001/api?todo=add&aid=7&aname=x&atype=收入&amount=3.25&paymethod=xxx&createtime=2018-7-24&description=abcd
		
		// http://localhost:8001/api?todo=query&atype=收入&startCreateTime=2016-3-1&endCreateTime=2016-6-30
		
	}
	
	/**
	 * 响应前端对数据库的查询，以json字符串返回结果
	 * @param exchange http连接
	 */
	public void respondApi(HttpExchange exchange) {
		// 解析请求参数
		URI uri = exchange.getRequestURI();
		Map<String, String> reqParams = parseParams(uri.getQuery().split("&"));		
		
		// 根据参数中的NAV_STR(todo)字段决定对数据库的操作
		JSONObject response;
		if(reqParams.containsKey(NAV_STR)) {
			// 请求参数正确
			switch(reqParams.get(NAV_STR)) {
				case DELETE:
					response = delete(exchange, reqParams);
					break;
				case UPDATE:
					response = update(exchange, reqParams);
					break;
				case ADD:
					response = add(exchange, reqParams);
					break;
				case QUERY:
					response = query(exchange, reqParams);
					break;
				default:
					// 无效请求操作: 无效 todo字段
					response = respondIllegalParam(exchange, "请求参数todo字段不合法");
					break;
			}
		}else {
			// 无效的请求参数：没有todo字段
			response = respondIllegalParam(exchange, "请求参数缺失todo字段");
		}
		
		// 设置相应头为json格式
		Headers header = exchange.getResponseHeaders();
		header.set("Content-type", "application/json");
		
		// 将结果json写入响应主体
		OutputStream os = exchange.getResponseBody();
		try {
			exchange.sendResponseHeaders(200, 0);
			os.write(response.toString().getBytes());
			os.close();

		}catch(IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("响应ajax请求出错");
		}
		
	}
	
	/**
	 * 响应对主页面的请求，返回主页页面
	 * @param exchange http连接
	 */
	public void respondMain(HttpExchange exchange){
		try {
			exchange.sendResponseHeaders(200, 0);
			OutputStream os = exchange.getResponseBody();
			InputStream is = ClassLoader.getSystemResourceAsStream("index.html");
			byte[] temp = new byte[1024];
			int len;
			while((len = is.read(temp)) != -1) {
				os.write(temp, 0, len);
			}
			is.close();	
			os.close();
		}catch(IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("响应主页面失败");
		}
	}
	
	/**
	 * 根据参数列表中的id删除数据库中的一条账目
	 * @param exchange http连接
	 * @param reqParams 请求参数 
	 * @return 表示删除结果的json对象
	 */
	private JSONObject delete(HttpExchange exchange, Map<String, String> reqParams) {
		// 删除的依据是参数列表中的aid(主键)
		int aid = Integer.parseInt(reqParams.get("aid"));
		int resultCount = ctrl.deleteById(aid);
		JSONObject response = new JSONObject();
		if(resultCount > 0) {
			// 成功删除
			response.put("isUsable", true);
			response.put("description", "删除成功");
			response.put("data", new JSONObject().put("isSucceed", true));
		}else {
			// 删除失败
			response.put("isUsable", true);
			response.put("description", "删除失败");
			response.put("data", new JSONObject().put("isSucceed", false));			
		}

		return response;
	}
	
	/**
	 * 根据请求参数想数据中增添数据
	 * @param exchange http连接
	 * @param reqParams 请求参数
	 * @return 表示添加结果的json对象
	 */
	private JSONObject add(HttpExchange exchange, Map<String, String> reqParams) {
		// aid不会用于账目添加，但是如果为空的话可能在genAccountItem函数运行中产生错误
		reqParams.put("aid", "0");
		
		AccountItem account = genAccountItem(reqParams);
		int resultCount = ctrl.add(account);
		JSONObject response = new JSONObject();
		if(resultCount > 0) {
			response.put("isUsable", true);
			response.put("description", "添加成功");
			response.put("data", new JSONObject().put("isSucceed", true));
		}else {
			response.put("isUsable", true);
			response.put("description", "添加失败");
			response.put("data", new JSONObject().put("isSucceed", false));			
		}
		return response;
	}
	
	/**
	 * 条件查询获得用JSON表示的查询结果
	 * @param exchange http连接对象
	 * @param reqParams 请求参数列表
	 * @return 用JSONObject表示的查询结果
	 */
	private JSONObject query(HttpExchange exchange, Map<String, String> reqParams) {
		// 利用请求参数查询数据库获取结果
		QueryCondition cond = genQueryCondition(reqParams);
		List<AccountItem> result = ctrl.query(cond);
		
		// 准备好表示结果的json对象
		JSONObject response = new JSONObject();
		response.put("isUsable", true);
		response.put("description", "查询完成");
		
		// 将用集合表示的查询结果转换为json数组，并放入最终数据结果中返回
		JSONArray jsonResult = new JSONArray();
		for(AccountItem account : result) {
			JSONObject jsonAccount = new JSONObject();
			jsonAccount.put("aid", account.getAid());
			jsonAccount.put("aname", account.getAname());
			jsonAccount.put("atype", account.getAtype());
			jsonAccount.put("amount", account.getAmount());
			jsonAccount.put("paymethod", account.getPaymethod());
			jsonAccount.put("createtime", account.getCreatetime());
			jsonAccount.put("description", account.getDescription());
			jsonResult.put(jsonAccount);
		}
		response.put("data", jsonResult);
		
		return response;
	}
	
	/**
	 * 返回查询参数不合法时的json结果对象
	 * @param exchange http连接
	 * @param reason 参数不合法原因描述字符串
	 * @return json结果对象
	 */
	private JSONObject respondIllegalParam(HttpExchange exchange, String reason) {		
		JSONObject response = new JSONObject();
		response.put("isUsable", false);
		response.put("description", reason);
		response.put("data", new JSONArray());
		System.out.println("response json: " + response.toString());
		
		return response;
	}
	
	/**
	 * 修改数据库条目，返回结果
	 * @param exchange http连接
	 * @param reqParams 请求参数列表
	 * @return 查询结果json对象
	 */
	private JSONObject update(HttpExchange exchange, Map<String, String> reqParams) {
		AccountItem account = genAccountItem(reqParams);
		int resultCount = ctrl.update(account);
		
		JSONObject response= new JSONObject();
		if(resultCount > 0) {
			response.put("isUsable", true);
			response.put("description", "更新成功");
			response.put("data", new JSONObject().put("isSucceed", true));
		}else {
			response.put("isUsable", true);
			response.put("description", "更新失败");
			response.put("data", new JSONObject().put("isSucceed", false));			
		}
		System.out.println("response json: " + response.toString());
		
		return response;
	}
	
	/**
	 * 根据请求参数生成一个表示账目条目的javabean对象
	 * @param reqParams 请求参数
	 * @return 生成的账目条目对象
	 */
	private AccountItem genAccountItem(Map<String, String> reqParams) {
		return new AccountItem(
					Integer.parseInt(reqParams.get("aid")),
					reqParams.get("aname"),
					reqParams.get("atype"),
					Double.parseDouble(reqParams.get("amount")),
					reqParams.get("paymethod"),
					reqParams.get("createtime"),
					reqParams.get("description")
				);
	}
	
	/**
	 * 根据请求参数生成一个表示查询条件的javabean对象
	 * @param reqParams 请求参数
	 * @return 查询条件对象
	 */
	private QueryCondition genQueryCondition(Map<String, String> reqParams) {
		return new QueryCondition(
					reqParams.get("atype"),
					reqParams.get("startCreateTime"),
					reqParams.get("endCreateTime"),
					reqParams.get("searchKeyword")
				);
	}
	
	/**
	 * 解析参数列表
	 * @param query 参数数组，每一项都是以=分割的键值对
	 * @return 以Map集合存储的参数列表
	 */
	private Map<String, String> parseParams(String[] query){
		HashMap<String, String> reqParams = new HashMap<String, String>();
		reqParams.put("aid", "0");
		for(String queryItem : query) {
			String[] pairs = queryItem.split("=");
			reqParams.put(pairs[0], pairs[1]);
		}
		System.out.println(reqParams);
		
		return reqParams;
	}
}
