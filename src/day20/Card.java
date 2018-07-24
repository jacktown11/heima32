package day20;

import java.util.ArrayList;

public class Card {
	public final static String EMPTY_COLOR = ""; // 无花色（大小王）
	public final static String SPADE_COLOR = "\u2660"; // 黑桃
	public final static String HEARTS_COLOR = "\u2665"; // 红桃
	public final static String DIAMOND_COLOR = "\u2666"; // 方块
	public final static String CLUB_COLOR = "\u2663"; // 梅花
	public static ArrayList<String> names = new ArrayList<String>();

	public String name;
	public String color;
	public int value;

	static {
		final String[] _names = {"3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A", "2", "QUEEN", "KING"};
		for (int i = 0; i < _names.length; i++) {
			names.add(_names[i]);
		}
	}

	public static void main(String[] args) {

	}

	public Card(String name) {
		// 单参数，用于没有花色值的传入“QUEEN”或“KING”
		final int size = names.size();
		final String queen = names.get(size - 2);
		final String king = names.get(size - 1);

		if (queen.equals(name) || king.equals(name)) {
			this.name = name;
			this.color = Card.EMPTY_COLOR;
			this.value = names.indexOf(name);
		}
	}

	public Card(String name, String color) {
		int pos = names.indexOf(name);
		int size = names.size();
		if (pos >= 0 && pos < size - 2
				&& (Card.SPADE_COLOR.equals(color)
						|| Card.CLUB_COLOR.equals(color)
						|| Card.DIAMOND_COLOR.equals(color)
						|| Card.HEARTS_COLOR.equals(color))) {
			this.name = name;
			this.color = color;
			this.value = pos;
		}
	}
	
}
