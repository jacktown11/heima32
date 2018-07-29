package se.day27;

public class Conference {
	public static void main(String[] args) {
		new Thread(new Entry("前门")).start();
		new Thread(new Entry("后门")).start();
	}
}
