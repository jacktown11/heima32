package se.day32.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class UploadTask implements Runnable{
	private final static File folder = new File("D:\\temp\\test\\upload");
	private Socket socket;
	
	public UploadTask(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			if(!folder.exists()) {
				System.out.println("creating new folder.");
				folder.mkdirs();
			}
			String fileName = folder + File.separator + ""+System.currentTimeMillis()+new Random().nextInt(10000)+".png";
			
			FileOutputStream fos = new FileOutputStream(fileName);
			
			InputStream in = socket.getInputStream();
			byte[] data = new byte[1024];
			int len;
			while((len = in.read(data)) != -1) {
				fos.write(data, 0, len);
			}
			fos.close();
			
			System.out.println("上传文件被成功保存为： " + fileName);
			OutputStream out = socket.getOutputStream();
			out.write("上传成功".getBytes());
			socket.shutdownOutput();
			
			socket.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
