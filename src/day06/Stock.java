package day06;
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
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");

		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		return userInput;
	}

	public static void showList(ArrayList<Good> goods) {
		System.out.printf("-------------库存清单------------\n");
		System.out.printf("%-16s%-8s%-8s%-6s\n", "品牌名称", "尺寸", "价格", "剩余数量");
		int totalLeftNum = 0;
		double totalMoney = 0;
		for (int i = 0; i < goods.size(); i++) {
			Good g = goods.get(i);
			System.out.printf("%-20s%-10f%-10.2f%-10d\n", g.brand, g.size,
					g.price, g.leftNum);
			totalLeftNum += g.leftNum;
			totalMoney += g.leftNum * g.price;
		}
		System.out.println("总共剩余货品数量： " + totalLeftNum);
		System.out.println("剩余货品总价值： " + totalMoney);
	}

	public static void updateLeftNum(ArrayList<Good> goods) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < goods.size(); i++) {
			Good g = goods.get(i);
			System.out.println("请输入" + g.brand + "的剩余数量:");
			g.leftNum = sc.nextInt();
		}
	}
}
