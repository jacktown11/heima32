package se.day29;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private final static String configFilePath = "jdbc_config.properties";
	private static String driverName;
	private static String url;
	private static String dbUsername;
	private static String dbPassword;
	private static Connection con;
	
	static {
		try {
			getParamsFromConfigFile();
			Class.forName(driverName);
			con = DriverManager.getConnection(url, dbUsername, dbPassword);
		}catch(IOException IOEx) {
			throw new RuntimeException(IOEx);
		}catch(ClassNotFoundException CLSEx) {
			throw new RuntimeException(CLSEx);
		}catch(SQLException sqlEx) {
			throw new RuntimeException(sqlEx);
		}
	}
	
	private JDBCUtils() {
		
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con, Statement st, ResultSet rs) {
		if(rs != null) {			
			try {
				rs.close();
			}catch(Exception ex) {}
		}
		if(st != null) {			
			try {
				st.close();
			}catch(Exception ex) {}
		}
		if(con != null) {			
			try {
				con.close();
			}catch(Exception ex) {}
		}
	}
	public static void close(Connection con, Statement st) {
		if(st != null) {			
			try {
				st.close();
			}catch(Exception ex) {}
		}
		if(con != null) {			
			try {
				con.close();
			}catch(Exception ex) {}
		}
	}
	
	private static void getParamsFromConfigFile() throws IOException {
		InputStream config = JDBCUtils.class.getClassLoader().getResourceAsStream(configFilePath);
		Properties p = new Properties();
		p.load(config);
		driverName = p.getProperty("driverName");
		url = p.getProperty("url");
		dbUsername = p.getProperty("dbUsername");
		dbPassword = p.getProperty("dbPassword");
	}
	
	
}
