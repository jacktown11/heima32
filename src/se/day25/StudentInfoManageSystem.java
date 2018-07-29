package se.day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class StudentInfoManageSystem{
	private ArrayList<Student> sts = new ArrayList<Student>();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new StudentInfoManageSystem().start();
	}
	
	public void start()  throws IOException, ClassNotFoundException{
		getStudentInfo();
		printStudentsInfo();
		System.out.println("getted");
		System.out.println();
		
		serializeStudentInfo();
		printStudentsInfo();
		System.out.println("serialized");
		System.out.println();
		
		deSerializeStudentInfo();
		printStudentsInfo();
		System.out.println("deserialized");
		System.out.println();
		
		reorderStudent();
		printStudentsInfo();
		System.out.println("reordered");
		System.out.println();
		
		resaveStudentInfo();
		printStudentsInfo();
		System.out.println("resaved");
		System.out.println();		
	}
	
	

	public void getStudentInfo() throws IOException {

		String parts[];
		System.out.println("Please input students info:");
		BufferedReader reader = new BufferedReader(new FileReader("d:\\temp\\test\\info_init.txt"));
		String line = null;
		while((line = reader.readLine()) != null) {
			parts = line.split("[,，]");
			if(parts.length == 3) {
				sts.add(new Student(parts[0], parts[1], Integer.parseInt(parts[2])));
			}
		}
		reader.close();
	}
	
	public void serializeStudentInfo() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new 
				FileOutputStream("d:\\temp\\test\\info.ser"));
		oos.writeObject(sts);
		oos.close();
	}
	
	public void deSerializeStudentInfo() 
			throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new 
				FileInputStream("d:\\temp\\test\\info.ser"));
		sts = (ArrayList<Student>) ois.readObject();
		ois.close();
	}
	
	public void reorderStudent() {
		HashSet<Student> studentSet = new HashSet<Student>(sts);
		sts = new ArrayList<Student>(studentSet);
		Collections.sort(sts);
	}
	public void resaveStudentInfo() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\temp\\test\\info_sorted.txt"));
		for(Student item : sts) {
			bw.write(item.toString());
			bw.newLine();
		}
		bw.close();
	}
	
	public void printStudentsInfo() {
		for(Student s : sts) {
			System.out.println(s.toString());
		}
	}
	
}
