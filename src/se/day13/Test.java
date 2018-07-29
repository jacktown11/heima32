package se.day13;

public class Test {
	public static void main(String[] args) {
		OldPhone o = new OldPhone();
		NewPhone n = new NewPhone();
		
		o.call();
		o.sendMessage("hello");
		
		n.call();
		n.sendMessage("hello");
		n.playGame();
	}
}
