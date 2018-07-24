package day09;
import java.util.ArrayList;
import java.util.Random;
public class CallName {
	static ArrayList<Student> st = new ArrayList<Student>();
	public static void main(String[] args) {
		addStudents();
		printStudents();
		System.out.println("----------------");
		randomCall();
	}
	
	public static void addStudents() {
		st.add(new Student("张三", 20));
		st.add(new Student("张四", 21));
		st.add(new Student("张五", 22));
		st.add(new Student("张六", 23));
		st.add(new Student("张七", 24));
	}
	
	public static void printStudents() {
		for(int i = 0; i < st.size(); i++) {
			System.out.println(st.get(i));
		}
	}
	
	public static void randomCall() {
		int size = st.size();
		int rand = new Random().nextInt(size);
		System.out.println(st.get(rand).getName());
	}
}
