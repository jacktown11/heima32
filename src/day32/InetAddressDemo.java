package day32;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		go1();
	}
	
	public static void go1() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local.getHostName());
		System.out.println(local.getHostAddress());
		
		InetAddress baidu = InetAddress.getByName("www.baidu.com");
		System.out.println(baidu.getHostName());
		System.out.println(baidu.getHostAddress());
	}
	
	
}
