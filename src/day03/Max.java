package day03;
import java.util.Scanner;
public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int x3 = sc.nextInt();
		int max = x1 > x2 ? x1 : x2;
		max = max > x3 ? max : x3;
		System.out.println("The max number is: " + max);
	}
}
