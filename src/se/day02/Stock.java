package se.day02;

public class Stock {
	public static void main(String[] args) {
		Good gd1 = new Good("MacBookAir", 13.3, 6988.88, 5);
		Good gd2 = new Good("ThinkpadT450", 14.0, 5999.99, 10);
		Good gd3 = new Good("ASUS-FL5800", 15.6, 4999.9, 18);

		int totalLeft = gd1.left + gd2.left + gd3.left;
		double totalMoney = gd1.getTotalMoney() + gd2.getTotalMoney()
				+ gd3.getTotalMoney();

		// ��ӡ�嵥����
		System.out.printf(
				"-----------------------------%s-----------------------------\n",
				"�̳ǿ���嵥");

		// ��ӡ��ͷ
		System.out.printf("%-16s%-4s%-6s%-2s\n", "Ʒ���ͺ�", "�ߴ�", "�۸�", "�����");

		// ��ӡ������
		System.out.println(gd1);
		System.out.println(gd2);
		System.out.println(gd3);

		// ��ӡ��ײ�
		System.out.printf(
				"-----------------------------%s-----------------------------\n",
				"------------");

		// ��ӡͳ�ƽ��
		System.out.println("�ܿ������" + totalLeft);
		System.out.println("�����Ʒ�ܽ�" + totalMoney);
	}
}
