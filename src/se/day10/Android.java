package se.day10;

public class Android extends Developer{
	public Android(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void work() {
		System.out.println("����Ϊ" + id + "��Ա��" + name + "���ڿ����ͻ���");
	}
}
