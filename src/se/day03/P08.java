package se.day03;

public class P08 {
	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			if(i%10 != 7  && i/10 != 7 ) {
				System.out.print(i + " ");
			}
		}
	}
}
