package day03;
import java.util.Random;
public class RandomInt {
	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0; i < 5; i++) {
			System.out.println(1 + r.nextInt(10));
		}
	}
}
