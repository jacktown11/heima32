package day21;

public class Test {
	public static void main(String[] args) {
		System.out.println(go());
	}
	
	public static int go(int... a) {
		int sum = 0;
		for(int item : a) {
			sum += item;
		}
		return sum;
	}
}
