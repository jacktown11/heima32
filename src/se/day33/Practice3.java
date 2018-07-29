package se.day33;

import java.lang.reflect.Method;

public class Practice3 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("day33.X");
		Method print = c.getMethod("print", String.class);
		print.invoke(c.newInstance(), "A sentence.");
	}
}

class X{
	public X() {
		super();
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}
