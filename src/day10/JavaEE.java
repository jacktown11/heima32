package day10;

public class JavaEE extends Developer {
	public JavaEE(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void work() {
		System.out.println("工号为" + id + "的员工" + name + "正在开发网站");
	}

}
