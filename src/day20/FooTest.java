package day20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FooTest {
	public static void main(String[] args) {
		ArrayList<Foo> a = new ArrayList<Foo>();
		a.add(new Foo(1));
		a.add(new Foo(2));
		a.add(new Foo(3));

		try {
			FileOutputStream fileOut = new FileOutputStream("./Foo.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
