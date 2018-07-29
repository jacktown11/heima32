package se.day22;

import java.io.File;
import java.util.Scanner;

public class DeleteFolder {
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
		if (deleteFolder(folder)) {
			System.out.println("The folder has been deleted.");
		} else {
			System.out.println("The folder cann't be deleted for some reason.");
		}
		sc.close();
	}

	public static boolean deleteFolder(File folder) {
		System.out.println("deleting " + folder);
		if (folder.isDirectory()) {
			for (File innerFile : folder.listFiles()) {
				if (!deleteFolder(innerFile)) {
					return false;
				}
			}
		}
		return folder.delete();
	}

}
