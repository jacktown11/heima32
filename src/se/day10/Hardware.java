package se.day10;

public class Hardware extends Maintainer {
	public Hardware(int id, String name) {
		super(id, name);
	}

	@Override
	public void work() {
		System.out.println("����Ϊ" + id + "��Ա��" + name + "�����޸���ӡ��");
	}

}
