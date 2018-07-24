package day02;

public class Good {
	String name;
	double size;
	double price;
	int left;
	public Good(String n, double s, double p, int l) {
		name = n;
		size = s;
		price = p;
		left = l;
	}
	public String toString() {
		String res = String.format("%-20s%-6.1f%-8.2f%-5d", name, size, price,
				left);
		return res;
	}
	public double getTotalMoney() {
		return price * left;
	}
}
