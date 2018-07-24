package day10.practice1;

public class Coder extends Developer{
	public void work() {
		System.out.println("工号为" + getId() + "的项目经理" + getName() + "该月工资" + getSalary());
	}
}
