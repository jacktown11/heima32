package day22;

import java.io.File;
import java.util.Scanner;

public class AnalysisFolder {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		File folder;
		System.out.println("Input the folder or file's name:");
		while(!((folder = new File(sc.nextLine())).exists())) {			
			System.out.println("The folder you input doesn't exist, input again.\n");
		}		
		long size = analysis(folder);
		System.out.println(size);
	}
	public static long analysis(File file) {
		long size = 0;
		if(file.isDirectory()) {
			for(File innerFile : file.listFiles()) {
				size += analysis(innerFile);
			}
		}else {
			size = file.length();
		}
		return size;
	}
	
	
}
