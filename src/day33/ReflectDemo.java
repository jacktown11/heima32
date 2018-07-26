package day33;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
//		useConstructor();
//		useField();
		useMethod();
	}
	
	
	public static void useMethod() throws Exception {
		Class c = Class.forName("day33.Person");
		Object o = c.newInstance();
		
		Method[] ms = c.getMethods();
		for(Method m : ms) {
			System.out.println(m);
		}
		System.out.println();
		
		Method m1 = c.getMethod("method1");
		m1.invoke(o);
		System.out.println();
		
		Method m2 = c.getMethod("method2", String.class);
		m2.invoke(o, "jack");
		System.out.println();
		
		Method m4 = c.getMethod("method4", String.class);
		Object result = m4.invoke(o, "good");
		System.out.println("Result of method4:" + result);
		System.out.println();
		
	}
	
	public static void useField() throws Exception {
		Class c = Class.forName("day33.Person");
		
		// 所有public字段
		Field[] flds = c.getFields();
		for(Field fld : flds) {
			System.out.println(fld);
		}
		System.out.println();
		
		// 字段修改
		Field fld = c.getField("name");
		Object o = c.newInstance();
		fld.set(o, "jack");
		System.out.println(o);
		System.out.println();
		
	}
	
	public static void useConstructor() throws Exception{
		Class c = Class.forName("day33.Person");
		
		// 返回所有public构造器
		Constructor[] cons = c.getConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
		
		// 返回所有构造器
		System.out.println();
		cons = c.getDeclaredConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
		
		// 使用Class对象直接实例化给定类
		System.out.println();
		System.out.println(c.newInstance());
		
		// 使用public空参构造器创建对象
		System.out.println();
		System.out.println(c.getConstructor().newInstance());
		
		// 使用public有参构造器创建对象
		System.out.println();
		System.out.println(c.getConstructor(String.class, int.class, String.class).newInstance("jack", 3, "China"));
		
		// 使用私有构造器强制创建对象
		System.out.println();
		Constructor con = c.getDeclaredConstructor(String.class, int.class);
		con.setAccessible(true);
		System.out.println(con.newInstance("tom", 5));
		
		
	}
}
