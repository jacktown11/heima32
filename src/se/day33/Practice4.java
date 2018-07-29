package se.day33;

import java.lang.reflect.Field;

public class Practice4 {
	public static void main(String[] args) throws Exception {
		Object o = Class.forName("day33.Person").newInstance();
		new Practice4().setProperty(o, "name", "rose");
		System.out.println(o);
	}
	public void setProperty(Object obj, String propertyName, Object value) throws Exception{   
		Class objCls = obj.getClass();
		Field property = objCls.getField(propertyName);
		property.set(obj, value);
	}
}
