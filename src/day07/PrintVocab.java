package day07;

public class PrintVocab {
	public static void main(String[] args) {
		char A = 65;
		char a = 97;
		for(int i = 0; i < 26; i++) {
			System.out.println(A++ + " " + a++);
		}
	}
}
