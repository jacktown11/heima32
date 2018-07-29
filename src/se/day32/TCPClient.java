package se.day32;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket sk = new Socket("127.0.0.1", 3000);

		OutputStream out = sk.getOutputStream();
		out.write("hello, I'm client.".getBytes());
		
		InputStream in = sk.getInputStream();
		byte[] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data, 0, len));
		
		sk.close();
	}
}
