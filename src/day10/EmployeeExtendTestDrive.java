package day10;

public class EmployeeExtendTestDrive {
	public static void main(String[] args) {		
		JavaEE j = new JavaEE(34, "jack");
		Android a = new Android(27, "Tom");
		Network n = new Network(34, "Frank");
		Hardware h = new Hardware(34, "Lucy");
		
		j.work();
		a.work();
		n.work();
		h.work();
	}
}
