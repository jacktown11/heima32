package day11;

public class AnimalExtendsTestDrive {
	public static void main(String[] args) {
		go(new Cat());
		go(new Dog());
	}
	
	public static void go(Animal a) {
		a.eat();
		if(a instanceof Cat) {
			((Cat) a).catchMouse();
		}else if(a instanceof Dog) {
			((Dog) a).keepHome();
		}
	}
}
