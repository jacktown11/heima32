package se.day04;
import java.util.Scanner;
public class Shopp {

	public static void main(String[] args) {
		String[] brand = {"MacBookAir", "ThinkpadT450"};
		double[] size = {13.3, 15.6};
		double[] price = {8993.4, 4999.2};
		int[] leftNum = {0, 0};
		boolean isExit = false;
		do {
			int userInput = getUserChoose();
			if (userInput == 1) {
				showList(brand, size, price, leftNum);
			} else if (userInput == 2) {
				updateLeftNum(brand, leftNum);
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

	public static void showList(String[] brand, double[] size, double[] price,
			int[] leftNum) {
		System.out.printf("-------------����嵥------------\n");
		System.out.printf("%-16s%-8s%-8s%-6s\n", "Ʒ������", "�ߴ�", "�۸�", "ʣ������");
		int totalLeftNum = 0;
		double totalMoney = 0;
		for (int i = 0; i < brand.length; i++) {
			System.out.printf("%-20s%-10f%-10.2f%-10d\n", brand[i], size[i],
					price[i], leftNum[i]);
			totalLeftNum += leftNum[i];
			totalMoney += leftNum[i] * price[i];
		}
		System.out.println("�ܹ�ʣ���Ʒ������ " + totalLeftNum);
		System.out.println("ʣ���Ʒ�ܼ�ֵ�� " + totalMoney);
	}

	public static void updateLeftNum(String[] brand, int[] leftNum) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < brand.length; i++) {
			System.out.println("������" + brand[i] + "��ʣ������:");
			leftNum[i] = sc.nextInt();
		}
	}
}
