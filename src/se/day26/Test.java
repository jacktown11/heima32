package se.day26;

public class Test {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getState());
			}
		}.start();;
	}
}
