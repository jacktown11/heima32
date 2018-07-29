package se.day08;

public class Good {
	int id;
	String name;
	double price;
	
	public Good(int i, String n, double p) {
		id = i;
		name = n;
		price = p;
	}
	
	public String toString() {
		return String.format("%-10d%-15s%10.2f", id, name, price);
	}
}
