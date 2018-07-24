package day10;

public class Hardware extends Maintainer {
	public Hardware(int id, String name) {
		super(id, name);
	}

	@Override
	public void work() {
		System.out.println("工号为" + id + "的员工" + name + "正在修复打印机");
	}

}
