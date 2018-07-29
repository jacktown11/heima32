package se.day32;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException {
		inetTest();
	}
	
	public static void inetTest() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local.getHostName());
		System.out.println(local.getHostAddress());
		
		InetAddress baidu = InetAddress.getByName("www.baidu.com");
		System.out.println(baidu.getHostAddress());
		System.out.println(baidu.getHostName());
	}
	
}
