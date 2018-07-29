package se.day32.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		uploadFile(new File("d:\\temp\\test\\a.png"));
	}
	
	public static void uploadFile(File file) throws IOException {
		Socket sk = new Socket("127.0.0.1", 3000);
		
		OutputStream out = sk.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len;
		while((len = fis.read(data)) != -1) {
			out.write(data, 0, len);
		}
		sk.shutdownOutput();
		fis.close();
		
		InputStream in = sk.getInputStream();
		len = in.read(data);
		System.out.println(new String(data, 0, len));
		
		sk.close();
	}
}
