package se.day10.practice1;

public class DeveloperExtendTestDrive {
	public static void main(String[] args) {
		Coder c = new Coder();
		c.setId("3705");
		c.setName("jack");
		c.setSalary(3800);
		c.work();
		
		Manager m = new Manager();
		m.setId("4800");
		m.setName("Frank");
		m.setSalary(4500);
		m.setBonus(1000);
		m.work();
	}
}
