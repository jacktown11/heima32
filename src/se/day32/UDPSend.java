package se.day32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		send();
	}
	
	public static void send() throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();

		while(true) {
			byte[] bytes = sc.nextLine().getBytes();
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 8080);
			ds.send(dp);			
		}
	}
}
