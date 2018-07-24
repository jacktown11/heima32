package day22;

import java.io.File;

public class SmallFile {
	private static int maxSize = 200;
	public static void main(String[] args) {
		getSmallFile(new File("d:\\temp\\test"));
	}
	
	public static void getSmallFile(File file) {
		if(file.isDirectory()) {
			for(File innerFile : file.listFiles()) {
				getSmallFile(innerFile);
			}
		}else if(file.length() < maxSize) {
			System.out.println(file);
		}
	}
}
