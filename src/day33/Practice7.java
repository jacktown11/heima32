package day33;

import java.io.InputStream;
import java.util.Properties;

public class Practice7 {
	public static void main(String[] args) throws Exception{
		InputStream is = Practice7.class.getClassLoader().getResourceAsStream("reflectTest.properties");
		Properties p = new Properties();
		p.load(is);
		is.close();
		String clsName = p.getProperty("classname");
		String methodName = p.getProperty("method");
		
		Class cls = Class.forName(clsName);
		cls.getMethod(methodName).invoke(cls.newInstance());
	}
}
