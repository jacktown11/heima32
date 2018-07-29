package se.day30;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserInfo {
	private static Map<String, String> users = new HashMap<String, String>();
	
	public static void main(String[] args) throws SQLException {
		prepareUserInfo();
		saveUserInfo();
	}
	
	public static void prepareUserInfo() {
		users.put("liuyan", "123456");
		users.put("wangbaoqiang", "123321");
		users.put("fangbian", "abcd");
		users.put("miejueshitai", "123abc321");
	}
	
	public static void saveUserInfo() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());		
		String querySQL = "SELECT COUNT(*) FROM userinfo WHERE uname=?";
		String insertSQL;
		Object[] params;
		long count;
		for(String key : users.keySet()) {
			count = qr.query(querySQL, new ScalarHandler<Long>(),key);
			if(count > 0) {
				System.out.println("该用户已注册");
			}else {
				insertSQL = "INSERT INTO userinfo(uname, upassword) VALUES(?,?)";
				params = new Object[] {key, users.get(key)};
				count = qr.update(insertSQL, params);
				if(count > 0) {
					System.out.println("成功注册");
				}else {
					System.out.println("注册未成功");
				}
			}
		}
	}
	
}
