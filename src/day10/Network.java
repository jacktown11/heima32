package day10;

public class Network extends Maintainer {
	public Network(int id, String name) {
		super(id, name);
	}

	@Override
	public void work() {
		System.out.println("����Ϊ" + id + "��Ա��" + name + "���ڼ������");
	}

}
