package day06;

public class Foo {
	public static void main(String[] args) {
		final int sum = 370;
		int x; // = ¼×+10 = ÒÒ-20 = ±û*2 = ¶¡/2
		for(x = 0; x < 370; x++) {
			if(x-10 + x+20 + x/2 + x*2 == sum) {
				break;
			}
		}
		System.out.println("¼×£º" + (x-10) );
	}
}
