package se.day10;

public class JavaEE extends Developer {
	public JavaEE(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void work() {
		System.out.println("����Ϊ" + id + "��Ա��" + name + "���ڿ�����վ");
	}

}
