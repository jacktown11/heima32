package day24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConvertEncodeType {
	public static void main(String[] args) throws IOException{
		new ConvertEncodeType().go();
	}
	public void go() throws IOException{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\temp\\test\\aGBK.txt"));
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream("d:\\temp\\test\\aUTF.txt"), "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		char[] temp = new char[8];
		int len = -1;
		while((len = br.read(temp)) != -1) {
			bw.write(temp, 0, len);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
