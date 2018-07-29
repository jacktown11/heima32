package se.day10;

public class ExtendTestDrive {
	public static void main(String[] args) {
		Son s = new Son();
		
		s.showAge();
		System.out.println((Grandpa) (new Son()) instanceof Son);
	}
}
