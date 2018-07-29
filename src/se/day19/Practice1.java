package se.day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Practice1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("f");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("d");
		
		System.out.println(list);
		HashSet<String> tmp = new HashSet<String>(list);
		list.clear();
		list.addAll(tmp);
		System.out.println(list);		
	}
	
	public <T> boolean contains(T ele) {
		ArrayList<T> a = new ArrayList<T>();
		if(ele == null) {			
			for(T item : a) {
				if(item == ele) {
					return true;
				}
			}
		}else {
			for(T item : a) {
				if(ele.equals(item)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
