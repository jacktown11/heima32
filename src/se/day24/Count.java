package se.day24;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Count {
	public static void main(String[] args) throws IOException{
		new Count().go();
	}

	public void go() throws IOException{
		final String str = "If you want to change your fate I think you must come to the dark horse to learn java";

		// count words
		String[] words = str.split("\\s");
		Map<String, Integer> count = new HashMap<String, Integer>();
		for (String strItem : words) {
			if (!strItem.isEmpty()) {
				if (count.containsKey(strItem)) {
					count.put(strItem, count.get(strItem) + 1);
				} else {
					count.put(strItem, 1);
				}
			}
		}
		
		// print result in file
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\temp\\test\\count.txt"));
		for(String wordKey : count.keySet()) {
			bw.write(wordKey+"="+count.get(wordKey));
			bw.newLine();
		}
		bw.close();
	}
}
