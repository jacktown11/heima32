package day33;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Practice8 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("day33.Person");
		Constructor con = cls.getConstructor(String.class, int.class, String.class);
		Object o = con.newInstance("jack", 32, "China");
		
		System.out.println(new Practice8().getProperty(o, "age"));
	}
	public Object getProperty(Object obj, String propertyName) throws Exception{ 
		Field fld = obj.getClass().getDeclaredField(propertyName);
		fld.setAccessible(true);
		return fld.get(obj);
	}
}
