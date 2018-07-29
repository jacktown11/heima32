package se.day25;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.FileUtils;

public class FileFilterAndCopy {
	private final static String ext = "txt";
	
	public static void main(String[] args) throws IOException {
		File src = new File("d:\\temp\\test\\src");
		File dest = new File("d:\\temp\\test\\dest");
		Collection<File> files = FileUtils.listFiles(src,
				new String[]{ext},  true);
		for(File file : files) {
			FileUtils.copyFileToDirectory(file, dest);
		}
		System.out.println("copy finished.");
	}
}
