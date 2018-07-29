package se.day08;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
	static ArrayList<Good> goods = new ArrayList<Good>();
	public static void main(String[] args) {
		initGoods();
		int userAction;
		while (true) {
			userAction = acceptUserAction();
			switch (userAction) {
				case 1 :
					showGoods();
					break;
				case 2 :
					addGood();
					break;
				case 3 :
					deleteGood();
					break;
				case 4 :
					modifyGood();
					break;
				case 5 :
					return;
				default :
					System.out.println("û�и����������");
					break;
			}
		}
	}

	public static void initGoods() {
		goods.add(new Good(8001, "book", 9.8));
		goods.add(new Good(8005, "cookie", 3.8));
		goods.add(new Good(8004, "apple", 19.8));
	}

	public static int acceptUserAction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------��Ʒ����ϵͳ--------");
		System.out.println("1.�鿴��Ʒ");
		System.out.println("2.�����Ʒ");
		System.out.println("3.ɾ����Ʒ");
		System.out.println("4.�޸���Ʒ");
		System.out.println("5.�˳�ϵͳ");
		System.out.print("����������Ҫ���еĲ�����Ӧ��ţ�");
		return sc.nextInt();
	}

	public static void showGoods() {
		System.out.println("\n------------------��Ʒ�嵥------------------");
		System.out.printf("%-6s%-11s%8s\n", "��Ʒ���", "��Ʒ����", "�۸�");
		for (Good good : goods) {
			System.out.println(good);
		}
		System.out.println("--------------------------------------------");
	}
	public static void addGood() {
		// ���һ����Ʒ
		Scanner sc = new Scanner(System.in);

		System.out.println("\n��Ʒ��ӣ�");
		System.out.print("��������ӵ���Ʒ�ı�ţ�");
		int id = sc.nextInt();
		System.out.print("��������ӵ���Ʒ���ƣ�");
		String name = sc.next();
		System.out.print("��������ӵ���Ʒ�ļ۸�");
		double price = sc.nextDouble();

		goods.add(new Good(id, name, price));

		System.out.println("�����Ʒ�ɹ���");
	}

	public static void deleteGood() {
		// ɾ��һ����Ʒ��Ϣ
		Scanner sc = new Scanner(System.in);
		System.out.println("\n��Ʒɾ����");
		System.out.print("��������Ҫɾ������Ʒ�ı�ţ�");
		int id = sc.nextInt();

		boolean isExist = false;
		for (Good good : goods) {
			if (good.id == id) {
				goods.remove(good);
				isExist = true;
				break;
			}
		}

		if (isExist) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("��Ǹ�������ڸñ�ŵ���Ʒ��");
		}
	}

	public static void modifyGood() {
		// ��Ʒ��Ϣ�޸�
		Scanner sc = new Scanner(System.in);
		System.out.println("\n��Ʒ�޸�:");
		System.out.print("��������Ҫ�޸ĵ���Ʒ�ı�ţ�");
		int id = sc.nextInt();

		Good target = null;
		for (Good g : goods) {
			if (g.id == id) {
				target = g;
			}
		}
		if (target != null) {
			// ���ڸñ�ŵ���Ʒ
			System.out.print("�������޸ĺ����Ʒ���ƣ�");
			target.name = sc.next();
			System.out.print("�������޸ĺ����Ʒ�ļ۸�");
			target.price = sc.nextDouble();

			System.out.println("�޸���Ʒ�ɹ���");
		} else {
			// �����ڸñ�ŵ���Ʒ
			System.out.println("��Ǹ�������ڸñ�ŵ���Ʒ!");
		}
	}
}
