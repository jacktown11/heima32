package accountmanager.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import accountmanager.domain.AccountItem;
import accountmanager.domain.QueryCondition;
import accountmanager.tools.JDBCUtils;

/**
 * 面向service层提供数据库查询功能
 * @author tjk11
 *
 */
public class QueryServer {
	private static QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	
	public static void main(String[] args) {
		QueryServer server = new QueryServer();
		
		// 条件查询测试
		QueryCondition cond = new QueryCondition("", "", "", "");
		List<AccountItem> result = server.query(cond);
		System.out.println("共有"+result.size()+"条结果");
		for(AccountItem item : result) {
			System.out.println(item);
		}
		
		// 条目添加测试
		//System.out.println(server.add(new AccountItem(0, "买书", "支出", 300, "支付宝", "2018-7-27", "买的书一定要看完。")));
		
		// 修改条目测试
		//System.out.println(server.update(new AccountItem(4, "吃饭", "支出", 399, "现金", "2017-06-18", "朋友聚餐" )));
		
		// 条目删除测试
		// System.out.println(server.deleteById(3));
	}

	/**
	 * 根据id删除一条账目
	 * @param id 将要删除的账目的id
	 * @return 成功删除条目数量
	 */
	public int deleteById(int id) {
		String sql = "DELETE FROM account WHERE aid=?";
		int resultCount;
		try {
			resultCount = runner.update(sql, id);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("删除条目失败。");
		}
		return resultCount;
	}
	
	/**
	 * 修改给定账目对象中的id对应的账目内容
	 * @param item 包含修改内容的账目对象
	 * @return 成功修改的账目数量
	 */
	public int update(AccountItem item) {
		System.out.println("updating in dao ...");
		String sql = "UPDATE account SET aname=?, atype=?, amount=?, paymethod=?, createtime=?, description=? WHERE aid=?";
		Object[] params = {
			item.getAname(),
			item.getAtype(),
			item.getAmount(),
			item.getPaymethod(),
			item.getCreatetime(),
			item.getDescription(),
			item.getAid()
		};
		int resultCount;
		try {
			resultCount = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改条目失败");
		}
		System.out.println("udpate finished in dao");
		return resultCount;
	}
	
	/**
	 * 添加新账目
	 * 其id值在数据库中自动增加，不以账目对象参数中的id为依据 
	 * @param item
	 * @return 成功添加的账目数量
	 */
	public int add(AccountItem item) {
		String sql = "INSERT INTO account (aname, atype, amount, paymethod, createtime, description) VALUES (?,?,?,?,?,?)";
		Object[] params = {
			item.getAname(),
			item.getAtype(),
			item.getAmount(),
			item.getPaymethod(),
			item.getCreatetime(),
			item.getDescription()				
		};
		
		int count;
		try {
			count = runner.update(sql, params);
		} catch (SQLException e) {	
			e.printStackTrace();
			throw new RuntimeException("添加条目失败。");
		}
		return count;
	}
	
	/**
	 * 条件查询数据
	 * @param cond 查询条件对象
	 * @return 查询结果集合
	 */
	public List<AccountItem> query(QueryCondition cond){
		// 将查询条件转为SQL与和参数数组列表
		Map<String, String> condMap = cond.toMap();
		StringBuffer buffer = new StringBuffer("SELECT * FROM account WHERE TRUE");
		ArrayList params = new ArrayList();
		for(String key : condMap.keySet()) {
			boolean isValidCondition = true;
			switch(key) {
				case "atype":
					buffer.append(" AND atype=? ");
					break;
				case "startCreateTime":
					buffer.append(" AND createtime>=? ");
					break;
				case "endCreateTime":
					buffer.append(" AND createtime<=? ");
					break;
				case "searchKeyword":
					condMap.put(key, "%"+condMap.get(key)+"%");
					buffer.append(" AND description LIKE ?");
					break;
				default:
					// 非法条件
					isValidCondition = false;
					break;
			}
			if(isValidCondition) {
				params.add(condMap.get(key));
			}
		}
		
		// 执行查询获取结果
		List<AccountItem> result;
		try {
			result = runner.query(buffer.toString(), new BeanListHandler<AccountItem>(AccountItem.class), params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库条件查询失败");
		}
		return result;
	}
}

