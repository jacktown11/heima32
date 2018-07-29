package se.day29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 该类是利用mysql对java中jdbc的实现mysql-connector-java-5.1.37进行的数据库连接、查询练习
 * 该类还是用了自定义的JDBCUtils工具类方便数据库连接的建立与关闭操作
 * 
 * 程序准备好一些用户-密码模拟数据，然后想数据库表插入这些数据，并处理用户已存在的情况
 * 
 * @author tjk11
 *
 */
public class Userinfo {
	private static HashMap<String, String> userForAdd = new HashMap<String, String>();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = JDBCUtils.getConnection();
		prepareUserData();
		insertUserData(con);
		showWholeTable(con);
		con.close();
	}
	
	/**
	 * 	
	 * 准备好模拟的待添加的用户数据
	 */
	public static void prepareUserData() {
		userForAdd.put("liuyan", "123456");
		userForAdd.put("wangbaoqiang", "123321");
		userForAdd.put("fangbian", "abcd");
		userForAdd.put("miejueshitai", "123abc321");
	}
	
	/**
	 * 向数据库中插入用户数据，显示成功信息
	 * 如果该用户已存在，则放弃插入，显示已注册信息
	 * 插入过程失败，显示插入失败信息
	 * @param con 已准备好的数据库连接
	 * @throws SQLException 数据查询失败
	 */
	public static void insertUserData(Connection con) throws SQLException {
		String sql;
		PreparedStatement pst;
		String name, password;
		ResultSet result;
		for(String aName : userForAdd.keySet()) {
			// 遍历待添加的用户数据，查询数据库中是否存在
			name = aName;
			password = userForAdd.get(name);
			sql = "SELECT * FROM userinfo WHERE uname=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			result = pst.executeQuery();
			if(!result.next()) {
				// 表中还没有该用户名，执行插入操作
				sql = "INSERT INTO userinfo (uname, upassword) VALUES (?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, password);
				if(pst.executeUpdate()>0) {		
					// 成功向表中插入该用户数据
					System.out.println("User " + name + " registered successfully!");
				}else {
					// 插入用户数据失败
					System.out.println("User " + name + " isn't able to be registered for some reason.");
				}
			}else {
				// 表中已存在该用户名，不必插入
				System.out.println("User " + name + " has registered before!");
			}
			result.close();
			pst.close();
		}
	}
	
	/**
	 * 查询显示整个用户表中的所有信息，逐条打印
	 * 若无有效数据行，显示空表信息
	 * @param con 已准备好的数据库连接
	 * @throws SQLException 数据库查询失败
	 * 
	 */
	public static void showWholeTable(Connection con) throws SQLException {
		final String sql = "SELECT * FROM userinfo";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet result = st.executeQuery();
		if(result.next()) {
			// 查询到了数据
			do {
				System.out.println(result.getString("uname") + "..." + 
						result.getString("upassword"));
			}while(result.next());
		}else {
			// 表中没有数据
			System.out.println("Empty table.");
		}
		
		result.close();
		st.close();
	}
}
