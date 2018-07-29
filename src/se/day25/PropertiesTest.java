package se.day25;

import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		new PropertiesTest().go();
	}
	public void go() {
		Properties p = new Properties();
		p.setProperty("time0", "0");
		p.setProperty("time1", "1");
		System.out.println(p);		
	}
	
}
