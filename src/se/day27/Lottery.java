package se.day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lottery {
	private final static int RED_LENGTH = 6;
	private final static int RED_MAX = 33;
	private final static int BLUE_MAX = 16;
	private ArrayList<Integer> red = new ArrayList<Integer>();
	private int blue;

	public static void main(String[] args) {
		System.out.println(new Lottery().toString());
	}
	
	public Lottery() {
		genLottery();
	}
	
	private void genLottery() {
		Random r = new Random();
		while(red.size() < RED_LENGTH) {
			int rand;
			do {
				rand = r.nextInt(RED_MAX)+1;				
			}while(red.contains(Integer.valueOf(rand)));
			red.add(rand);
		}
		Collections.sort(red);
		blue = r.nextInt(BLUE_MAX)+1;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(Integer redInt : red) {
			sb.append(redInt + ", ");
		}
		sb.append(blue);
		sb.append("]");
		return sb.toString();
	}
	
}
