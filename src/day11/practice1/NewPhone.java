package day11.practice1;

public class NewPhone extends Phone implements IPlay{
	public void call() {
		System.out.println("Call by a new phone.");
	}
	public void sendMessage() {
		System.out.println("Send message by a new phone");
	}
	public void playGame() {
		System.out.println("Play a wonderful game with a new phone");
	}
}
