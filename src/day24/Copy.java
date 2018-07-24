package day24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) throws IOException {
		new Copy().go();
	}
	
	public void go() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("d:\\temp\\test\\a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\temp\\test\\aCopy.txt"));
		String str = null;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
		br.close();
		System.out.println("copy finished.");
		
	}
}
