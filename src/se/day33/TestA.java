package se.day33;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestA {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String clsName = sc.nextLine();
		
		Class c = Class.forName(clsName);
		Constructor con = c.getConstructor();
		Method print = c.getMethod("showString");
		print.invoke(c.newInstance());
	}
}
