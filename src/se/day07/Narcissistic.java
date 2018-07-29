package se.day07;

public class Narcissistic {
	public static void main(String[] args) {
		int a, b, c; // �١�ʮ������λ����
		for (int i = 100; i < 1000; i++) {
			a = i / 100;
			b = i % 100 / 10;
			c = i % 10;
			if (cube(a) + cube(b) + cube(c) == i) {
				System.out.println(i);
			}
		}
	}
	public static int cube(int a) {
		return a * a * a;
	}
}
