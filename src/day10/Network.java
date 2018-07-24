package day10;

public class Network extends Maintainer {
	public Network(int id, String name) {
		super(id, name);
	}

	@Override
	public void work() {
		System.out.println("工号为" + id + "的员工" + name + "正在检查网络");
	}

}
