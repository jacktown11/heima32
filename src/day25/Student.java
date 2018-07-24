package day25;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{
	private String name;
	private String gender;
	private int age;
	
	public Student() {
		
	}
	
	public Student(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + "-" + gender + "-" + age;
	}
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o instanceof Student) {
			Student s = (Student) o;			
			return this.age==s.age && 
					this.name.equals(s.name) && 
					this.gender.equals(s.gender);
		}else {
			return false;
		}
	}
	public int hashCode() {
		return (name+gender+age).hashCode();
	}

	public int compareTo(Student o) {
		return this.age - o.age;
	}
}
