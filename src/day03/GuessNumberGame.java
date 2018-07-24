package day03;
import java.util.Random;
import java.util.Scanner;
public class GuessNumberGame {
	public static void main(String[] args) {
		// 生成随机数
		Random r = new Random();
		int answer = r.nextInt(100) + 1;

		Scanner sc = new Scanner(System.in);
		int userGuess;
		boolean isRight = false;
		int count = 0;
		System.out.println("请猜测1-100之间的一个整数：");
		while (count < 5 && !isRight) {
			// 猜对为止，五次猜测机会
			userGuess = sc.nextInt();
			count++;
			isRight = userGuess == answer;
			if (isRight) {
				System.out.println("Congratulations! You guessed it.");
			} else {
				System.out.println("Sorry, the right answer is " + 
						(userGuess>answer ? "less" : "larger"));
				if (count >= 5) {
					System.out.println("The right answer is " + answer);
					System.out.println(
							"You have run out all chances :(. See you next time");
				}
			}
		}
		sc.close();
	}
}
