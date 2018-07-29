package se.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("a", 2);
		a.put("b", 2);
		a.put("ad", 2);
		a.put("ads", 2);
		
		Set<Map.Entry<String, Integer>> entries = a.entrySet();
		for(Map.Entry<String, Integer> item : entries) {
			System.out.println(item.getKey() + " => "+  item.getValue());
		}
	}
}
