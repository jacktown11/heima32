package day23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test {
	private final static String root = "d:\\temp\\test\\";
	public static void main(String[] args) throws IOException{
		go1();
	}
	public static void go1() {
		File file = new File(root + "a.txt");
		OutputStream is = null;
		try {
			is = new FileOutputStream(file, true);
			is.write("111".getBytes());			
			is.write("\r222".getBytes());
			is.write("\n333".getBytes());
			is.write("\r\n444".getBytes());
			is.write(65 + 0x0f00);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(is != null) {
				try {
					is.close();
				}catch(IOException ioEx) {
					throw new RuntimeException();
				}
			}
		}
	}
}
