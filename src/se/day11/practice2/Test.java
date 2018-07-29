package se.day11.practice2;

public class Test {
	public static void main(String[] args) {
		go(new Audi());
		go(new HighTechAudi());
	}
	public static void go(Audi a) {
		a.run();
		if(a instanceof HighTechCar) {
			((HighTechCar) a).autoRun();
			((HighTechCar) a).autoStop();
		}
	}
}
