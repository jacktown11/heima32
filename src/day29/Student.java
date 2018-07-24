package day29;

public class Student {
	private int id;
	private String name;
	private String gender;
	private int score;
	public Student() {
		
	}
	public Student(int id, String name, String gender, int score) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", score=" + score + "]";
	}
}
