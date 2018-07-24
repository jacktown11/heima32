package day02;

public class Stock {
	public static void main(String[] args) {
		Good gd1 = new Good("MacBookAir", 13.3, 6988.88, 5);
		Good gd2 = new Good("ThinkpadT450", 14.0, 5999.99, 10);
		Good gd3 = new Good("ASUS-FL5800", 15.6, 4999.9, 18);

		int totalLeft = gd1.left + gd2.left + gd3.left;
		double totalMoney = gd1.getTotalMoney() + gd2.getTotalMoney()
				+ gd3.getTotalMoney();

		// 打印清单标题
		System.out.printf(
				"-----------------------------%s-----------------------------\n",
				"商城库存清单");

		// 打印表头
		System.out.printf("%-16s%-4s%-6s%-2s\n", "品牌型号", "尺寸", "价格", "库存数");

		// 打印表内容
		System.out.println(gd1);
		System.out.println(gd2);
		System.out.println(gd3);

		// 打印表底部
		System.out.printf(
				"-----------------------------%s-----------------------------\n",
				"------------");

		// 打印统计结果
		System.out.println("总库存数：" + totalLeft);
		System.out.println("库存商品总金额：" + totalMoney);
	}
}
