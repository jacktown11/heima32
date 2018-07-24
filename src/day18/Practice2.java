package day18;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("b");
		list.add("f");
		list.add("e");
		list.add("c");
		list.add("a");
		list.add("d");
		sort(list);
		System.out.println(list);	// a, b, c, d, e, f
	}
	
	public static void sort(List<String> list) {
		quickSort(list, 0, list.size()-1);
	}
	
	/**
	 * sort list using quickSort
	 * @param list list for sorting
	 * @param start start index for sorting
	 * @param end end index for sorting
	 */
	public static void quickSort(List<String> list, int start, int end) {
		if(start >= end || start < 0 || end >= list.size()) return;
		
		String firstItem = list.get(start);
		int emptyIndex = start;
		for(int i = start + 1; i <= end; i++) {
			if(list.get(i).compareTo(firstItem) < 0) {
				list.set(emptyIndex, list.get(i));
				emptyIndex++;
				list.set(i, list.get(emptyIndex));
			}
		}
		list.set(emptyIndex, firstItem);
		
		quickSort(list, start, emptyIndex - 1);
		quickSort(list, emptyIndex + 1, end);
	}
}
