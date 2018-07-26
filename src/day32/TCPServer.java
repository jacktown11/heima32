package day32;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3000);
		Socket socket = server.accept();
		
		InputStream in= socket.getInputStream();
		byte[] result = new byte[1024];
		int len = in.read(result);
		System.out.println(new String(result, 0, len));
		
		OutputStream out = socket.getOutputStream();
		out.write("hello, I'm server.".getBytes());
		
		socket.close();
		server.close();
	}
}
