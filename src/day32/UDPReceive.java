package day32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceive {
	public static void main(String[] args) throws IOException {
		receive();
	}

	private static void receive() throws IOException {
		byte[] result = new byte[100];
		DatagramSocket ds = new DatagramSocket(8080);

		while(true) {
			DatagramPacket dp = new DatagramPacket(result, 100);
			ds.receive(dp);
			
			InetAddress address = dp.getAddress();
			String ip = address.getHostAddress();
			int port = dp.getPort();
			int len = dp.getLength();
			String dataStr = new String(dp.getData(), 0, len);
			System.out.println("从ip "+ip+":"+port+" 收到数据："+dataStr);
		}
	}
}
