package accountmanager.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource src = new BasicDataSource();
	
	// 读取jdbc配置文件，准备好 DataSource
	static {
		InputStream is = ClassLoader.getSystemResourceAsStream("jdbc_config.properties");
		Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取jdbc配置文件失败。");
		}
		src.setDriverClassName(p.getProperty("drivername"));
		src.setUrl(p.getProperty("url"));
		src.setUsername(p.getProperty("dbUsername"));
		src.setPassword(p.getProperty("dbPassword"));
		
		src.setMaxActive(10);
		src.setMaxIdle(5);
		src.setMinIdle(2);
		src.setInitialSize(5);
	}
	
	public static DataSource getDataSource() {
		return src;
	}
}
