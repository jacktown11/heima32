package se.day30;

public class Student {
	private int sid;
	private String sname;
	private String sgender;
	private int sscore;
	public Student() {
		
	}
	public Student(int sid, String sname, String sgender, int sscore) {
		this.sid = sid;
		this.sname = sname;
		this.sgender = sgender;
		this.sscore = sscore;
	}
	public int getsid() {
		return sid;
	}
	public void setsid(int sid) {
		this.sid = sid;
	}
	public String getsname() {
		return sname;
	}
	public void setsname(String sname) {
		this.sname = sname;
	}
	public String getsgender() {
		return sgender;
	}
	public void setsgender(String sgender) {
		this.sgender = sgender;
	}
	public int getsscore() {
		return sscore;
	}
	public void setsscore(int sscore) {
		this.sscore = sscore;
	}
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender
				+ ", sscore=" + sscore + "]";
	}
}
