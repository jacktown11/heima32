package day11.practice1;

public class PhoneTestDrive {
	public static void main(String[] args) {
		go(new OldPhone());
		go(new NewPhone());
	}
	public static void go(Phone p) {
		p.call();
		p.sendMessage();
		if(p instanceof IPlay) {
			((IPlay) p).playGame();
		}
	}
}
