package day33;

import java.lang.reflect.Method;

public class Practice2 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("day33.Person2");
		Method setName = c.getMethod("setName", String.class);
		
		Object o1 = c.newInstance();
		setName.invoke(o1, "p1");
		System.out.println(o1);
		
		Object o2 = c.getConstructor(String.class).newInstance("p2");
		System.out.println(o2);
		
	}
}

class Person2 {
	private String name;
	
	public Person2() {
		super();
	}

	public Person2(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + "]";
	}
	
}
