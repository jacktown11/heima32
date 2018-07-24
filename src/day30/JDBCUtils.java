package day30;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private final static String configFilePath = "jdbc_config.properties";
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	
	private static BasicDataSource dataSrc;
	static {
		try {
			getParamsFromConfigFile();			
		}catch(IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("读取JDBC配置文件失败");
		}
		setDataSource();
	}
	
	private static void setDataSource() {
		dataSrc = new BasicDataSource();
		dataSrc.setDriverClassName(driverClassName);
		dataSrc.setUrl(url);
		dataSrc.setUsername(username);
		dataSrc.setPassword(password);
	}
	
	private static void getParamsFromConfigFile() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(JDBCUtils.class.getClassLoader().getResourceAsStream(configFilePath));
		driverClassName = p.getProperty("driverName");
		url = p.getProperty("url");
		username = p.getProperty("dbUsername");
		password = p.getProperty("dbPassword");
	}
	public static DataSource getDataSource() {
		return dataSrc;
	}
}
