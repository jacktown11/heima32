package day06;

public class Student {
	String name;
	int age;
	public Student(String n, int a) {
		name = n;
		age = a;
	}
	public String toString() {
		return name + " " + age;
	}
}
