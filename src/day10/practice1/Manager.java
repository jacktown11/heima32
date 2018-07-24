package day10.practice1;

public class Manager extends Developer{
	private double bonus;
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getBonus() {
		return this.bonus;
	}
	
	public void work() {
		System.out.println("工号为" + getId() + "的项目经理" + getName() + "该月工资" + getSalary() + ",奖金" + getBonus());
	}
}
