package se.day10.practice1;

public class Manager extends Developer{
	private double bonus;
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getBonus() {
		return this.bonus;
	}
	
	public void work() {
		System.out.println("����Ϊ" + getId() + "����Ŀ����" + getName() + "���¹���" + getSalary() + ",����" + getBonus());
	}
}
