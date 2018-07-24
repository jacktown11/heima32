package day04;
import java.util.Scanner;
public class Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int tmp;
		
		if(num1 > num2) {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		if(num1 > num3) {
			tmp = num1;
			num1 = num3;
			num3 = tmp;
		}
		if(num2 > num3) {
			tmp = num2;
			num2 = num3;
			num3 = tmp;
		}
		
		System.out.println(num1 + " " + num2 + " " + num3);
	}
	

}
