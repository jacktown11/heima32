package se.day33;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Practice6 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("day33.Person6");
		Object o = cls.newInstance();
		
		Method m = cls.getMethod("setName", String.class);
		m.invoke(o, "jack");
		
		Field fld = cls.getDeclaredField("age");
		fld.setAccessible(true);
		fld.set(o, 13);
		
		System.out.println(o);
	}
}

