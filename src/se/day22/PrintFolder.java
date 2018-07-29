package se.day22;

import java.io.File;
import java.util.Scanner;

public class PrintFolder {
	private final static String DIVIDER = "__";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File folder;
		System.out.println("Input the folder's name:");
		folder = new File(sc.nextLine());
		while (!folder.exists() || !folder.isDirectory()) {
			if (!folder.exists()) {
				System.out.println("The folder you input doesn't exist, input again:");
			} else {
				System.out.println("What you input is a file, not a folder, input again please:");
			}
			folder = new File(sc.nextLine());
		}
		
		printFolder(folder);
	}

	public static void printFolder(File folder) {
		printFolder(folder, 0);
	}
	public static void printFolder(File folder, int depth) {
		StringBuffer prefix = new StringBuffer();
		for(int i = 0; i < depth; i++) {
			prefix.append(DIVIDER);
		}
		System.out.println(prefix+folder.getName());
		
		if(folder.isDirectory()) {
			for(File innerFile : folder.listFiles()) {
				printFolder(innerFile, depth + 1);
			}
		}
	}

}
