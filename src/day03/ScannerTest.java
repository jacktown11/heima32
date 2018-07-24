package day03;
import java.util.*;
public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println(str + 1);
		
		int i = sc.nextInt();
		System.out.println(i + 1);
		
		sc.close();
	}
}
