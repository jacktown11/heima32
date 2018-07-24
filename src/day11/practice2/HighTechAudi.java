package day11.practice2;

public class HighTechAudi extends Audi implements HighTechCar{
	public void run() {
		System.out.println("A high tech audi car is running.");
	}
	public void autoStop() {
		System.out.println("A high tech audi car is stopping automatically.");
	}
	public void autoRun() {
		System.out.println("A high tech audi car is running automatically.");
	}
}
