package day32.upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3000);
		while(true) {
			Socket s = server.accept();
			new Thread(new UploadTask(s)).start();
		}
	}
}
