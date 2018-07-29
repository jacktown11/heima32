package se.day27;

public class AwardDraw {
	public static void main(String[] args) {
		new Thread(new Drawer(), "抽奖箱1").start();
		new Thread(new Drawer(), "抽奖箱2").start();
	}
}
