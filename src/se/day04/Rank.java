package se.day04;
import java.util.Scanner;
public class Rank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		System.out.println(getRank(score));
	}

	public static String getRank(int score) {
		if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 60) {
			return "D";
		} else {
			return "E";
		}
	}
}
