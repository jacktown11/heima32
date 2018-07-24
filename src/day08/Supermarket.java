package day08;

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
					System.out.println("没有该项操作可用");
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
		System.out.println("\n--------商品管理系统--------");
		System.out.println("1.查看商品");
		System.out.println("2.添加商品");
		System.out.println("3.删除商品");
		System.out.println("4.修改商品");
		System.out.println("5.退出系统");
		System.out.print("请输入你需要进行的操作对应编号：");
		return sc.nextInt();
	}

	public static void showGoods() {
		System.out.println("\n------------------商品清单------------------");
		System.out.printf("%-6s%-11s%8s\n", "商品编号", "商品名称", "价格");
		for (Good good : goods) {
			System.out.println(good);
		}
		System.out.println("--------------------------------------------");
	}
	public static void addGood() {
		// 添加一条商品
		Scanner sc = new Scanner(System.in);

		System.out.println("\n商品添加：");
		System.out.print("请输入添加的商品的编号：");
		int id = sc.nextInt();
		System.out.print("请输入添加的商品名称：");
		String name = sc.next();
		System.out.print("请输入添加的商品的价格：");
		double price = sc.nextDouble();

		goods.add(new Good(id, name, price));

		System.out.println("添加商品成功。");
	}

	public static void deleteGood() {
		// 删除一条商品信息
		Scanner sc = new Scanner(System.in);
		System.out.println("\n商品删除：");
		System.out.print("请输入需要删除的商品的编号：");
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
			System.out.println("删除成功！");
		} else {
			System.out.println("抱歉，不存在该编号的商品！");
		}
	}

	public static void modifyGood() {
		// 商品信息修改
		Scanner sc = new Scanner(System.in);
		System.out.println("\n商品修改:");
		System.out.print("请输入需要修改的商品的编号：");
		int id = sc.nextInt();

		Good target = null;
		for (Good g : goods) {
			if (g.id == id) {
				target = g;
			}
		}
		if (target != null) {
			// 存在该编号的商品
			System.out.print("请输入修改后的商品名称：");
			target.name = sc.next();
			System.out.print("请输入修改后的商品的价格：");
			target.price = sc.nextDouble();

			System.out.println("修改商品成功。");
		} else {
			// 不存在该编号的商品
			System.out.println("抱歉，不存在该编号的商品!");
		}
	}
}
