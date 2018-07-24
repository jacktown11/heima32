package day22;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws IOException {
		go12();
	}
	public static void go12() {
		File file = new File("d:\\temp\\test");
		File[] files = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				System.out.println(dir);
				System.out.println(name);
				return name.endsWith(".txt");
			}
		});
		System.out.println(Arrays.toString(files));

	}

	public static void go11() {
		File file = new File("d:\\temp\\test\\a\\b.txt");
		String[] files = file.list();
		System.out.println(Arrays.toString(files));
	}
	public static void go10() {
		File file = new File("d:\\temp\\test\\c");
		if (file.exists()) {
			System.out.println(file.isDirectory());
		} else {
			System.out.println("not existing file or directory");
		}
	}
	public static void go9() {
		File file = new File("d:\\temp\\test\\c\\b.txt");
		System.out.println(file.exists());
	}

	public static void go8() {
		File file = new File("d:\\temp\\test\\a\\b.txt");
		System.out.println(file.getParent());
	}

	public static void go7() throws IOException {
		File file = new File("xx");
		System.out.println(file.getAbsoluteFile());
	}
	public static void go6() throws IOException {
		File file = new File("D:\\temp\\test\\a");
		System.out.println(file.length());
	}

	public static void go5() {
		File file = new File("D:\\temp\\test\\a");
		String name = file.getName();
		System.out.println(name);
	}
	public static void go4() {
		File file = new File("D:\\temp\\test\\a\\b");
		boolean isSuccess = file.delete();
		System.out.println(isSuccess);
	}
	public static void go3() {
		File file = new File("D:\\temp\\test\\a\\b");
		boolean isSuccess = file.mkdirs();
		System.out.println(isSuccess);
	}

	public static void go2() throws IOException {
		File file = new File("D:\\temp\\test.txt");
		boolean isSuccess = file.createNewFile();
		System.out.println(isSuccess);
	}

	public static void go1() {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		System.out.println(new File("D:\\my_work"));
		System.out.println(new File("D:\\my_work\\not_exist"));

	}
}
