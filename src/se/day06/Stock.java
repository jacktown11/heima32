package se.day06;
import java.util.Scanner;
import java.util.ArrayList;
public class Stock {
	static ArrayList<Good> goods = new ArrayList<Good>();
	
	public static void main(String[] args) {
		goods.add(new Good("MacBookAir", 13.3, 8993.4, 0));
		goods.add(new Good("ThinkpadT450", 15.6, 4999.2, 0));		
		boolean isExit = false;
		do {
			int userInput = getUserChoose();
			if (userInput == 1) {
				showList(goods);
			} else if (userInput == 2) {
				updateLeftNum(goods);
			} else {
				isExit = true;
			}
		} while (!isExit);

	}

	public static int getUserChoose() {
		System.out.println("-------------������------------");
		System.out.println("1.�鿴����嵥");
		System.out.println("2.�޸���Ʒ�������");
		System.out.println("3.�˳�");
		System.out.println("������Ҫִ�еĲ�����ţ�");

		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		return userInput;
	}

	public static void showList(ArrayList<Good> goods) {
		System.out.printf("-------------����嵥------------\n");
		System.out.printf("%-16s%-8s%-8s%-6s\n", "Ʒ������", "�ߴ�", "�۸�", "ʣ������");
		int totalLeftNum = 0;
		double totalMoney = 0;
		for (int i = 0; i < goods.size(); i++) {
			Good g = goods.get(i);
			System.out.printf("%-20s%-10f%-10.2f%-10d\n", g.brand, g.size,
					g.price, g.leftNum);
			totalLeftNum += g.leftNum;
			totalMoney += g.leftNum * g.price;
		}
		System.out.println("�ܹ�ʣ���Ʒ������ " + totalLeftNum);
		System.out.println("ʣ���Ʒ�ܼ�ֵ�� " + totalMoney);
	}

	public static void updateLeftNum(ArrayList<Good> goods) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < goods.size(); i++) {
			Good g = goods.get(i);
			System.out.println("������" + g.brand + "��ʣ������:");
			g.leftNum = sc.nextInt();
		}
	}
}
