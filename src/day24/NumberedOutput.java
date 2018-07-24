package day24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberedOutput {
	public static void main(String[] args) throws IOException{
		new NumberedOutput().go();
	}

	public void go() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("d:\\temp\\test\\a.txt"));
		String line = "";
		int count = 0;
		while((line = br.readLine()) != null) {
			System.out.println(count + " " +line);
			count++;
		}
		br.close();
	}
}
