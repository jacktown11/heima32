package day33;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Practice1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		
		Class arrayListClass = list.getClass();
		Method add = arrayListClass.getMethod("add", Object.class);
		add.invoke(list, "A string.");
		
		System.out.println(list);
	}
}
