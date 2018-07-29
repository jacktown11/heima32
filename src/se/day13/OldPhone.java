package se.day13;

public class OldPhone extends Phone{
	public OldPhone() {
		System.out.println("Old phone constructor");
	}
	
	{
		System.out.println("construct block code");
	}
	
	
	public void call() {
		System.out.println("Call with old phone");
	}
	public void sendMessage(String message) {
		System.out.println("Old phone is sending message: " + message);
	}
}
