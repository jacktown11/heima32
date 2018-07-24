package day10;

public abstract class Employee {
	int id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public abstract void work();
}
