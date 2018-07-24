package day13;

public class NewPhone extends Phone{
	public void call() {
		System.out.println("Call with new phone");
	}
	public void sendMessage(String message) {
		System.out.println("New phone is sending message: " + message);
	}
	
	
	public void playGame() {
		new GamePlaying() {
			public void play() {
				System.out.println("Playing with new phone");
			}
		}.play();
	}
}
