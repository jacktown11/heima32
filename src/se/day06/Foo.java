package se.day06;

public class Foo {
	public static void main(String[] args) {
		final int sum = 370;
		int x; // = ��+10 = ��-20 = ��*2 = ��/2
		for(x = 0; x < 370; x++) {
			if(x-10 + x+20 + x/2 + x*2 == sum) {
				break;
			}
		}
		System.out.println("�ף�" + (x-10) );
	}
}
