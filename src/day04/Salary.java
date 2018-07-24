package day04;
import java.util.Scanner;
public class Salary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int baseSalary = sc.nextInt();
		int boost = boostSalary(year);
		System.out.printf("你目前工作了%d年，基本工资为%d元，应涨工资%d元，最终工资为%d元", year, baseSalary, boost, boost + baseSalary);
	}
	
	public static int boostSalary(int workedYear) {
		if(workedYear >= 10) {
			return 5000;
		}else if(workedYear >= 5) {
			return 2500;
		}else if(workedYear >= 3) {
			return 1000;
		}else if(workedYear >= 1) {
			return 500;
		}else {
			return 200;
		}
	}
}
