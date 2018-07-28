package accountmanager.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应于一条查询条件的javabean，
 * 该条件对象被service层作为查询条件参数传给dao层
 * @author tjk11
 *
 */
public class QueryCondition {
	private String atype;
	private String startCreateTime;
	private String endCreateTime;
	private String searchKeyword;
	
	public QueryCondition() {
		
	}
	
	public QueryCondition(String atype, String startCreateTime,
			String endCreateTime, String searchKeyword) {
		super();
		this.atype = atype;
		this.startCreateTime = startCreateTime;
		this.endCreateTime = endCreateTime;
		this.searchKeyword = searchKeyword;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public String getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "QueryCondition [atype=" + atype + ", startCreateTime="
				+ startCreateTime + ", endCreateTime=" + endCreateTime
				+ ", searchKeyword=" + searchKeyword + "]";
	}
	
	/**
	 * 转为用Map表示的键值对查询条件；
	 * 空的查询条件将被跳过
	 * @return
	 */
	public Map<String, String> toMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(atype!=null && !atype.isEmpty()) {			
			map.put("atype", atype);
		}
		if(startCreateTime!=null && !startCreateTime.isEmpty()) {			
			map.put("startCreateTime", startCreateTime);
		}
		if(endCreateTime!=null && !endCreateTime.isEmpty()) {			
			map.put("endCreateTime", endCreateTime);
		}
		if(searchKeyword!=null && !searchKeyword.isEmpty()) {			
			map.put("searchKeyword", searchKeyword);
		}
		
		return map;
	}
	
}
