package day29;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInfo {
	private static Connection con = JDBCUtils.getConnection();
	
	public static void main(String[] args) throws NumberFormatException, SQLException, IOException{
		count();
		System.out.println();
		
		modifyScore();
		System.out.println();
		
		showGirlsMoreThan60();
		System.out.println();
		
		int average = showAverage();
		saveHighScoreStudent(average);
		System.out.println(getAllStudent().toString());
		System.out.println();
		
		System.out.println(getStudentById("13"));
		System.out.println();
		
		System.out.println("删除13是否成功：" + deleteStudentById("13"));
		System.out.println();
		
		System.out.println("插入学生");
		addStudent(new Student(13,"book","男",23));
		addStudent(new Student(13,"book","男",23));		
		System.out.println();
		
		System.out.println(getStudentById("13"));
	}
	public static boolean updateStudentById(Student aStudent) throws SQLException {
		boolean isSucceed = false;
		String querySQL = "SELECT * FROM student WHERE sid=?";
		PreparedStatement pst = con.prepareStatement(querySQL);
		pst.setInt(1, aStudent.getId());
		ResultSet result = pst.executeQuery();
		
		if(result.next()) {
			// 存在该id条目
			result.close();
			pst.close();
			String insertSQL = "UPDATE student SET sid=?,sname=?,sgender=?,sscore=?";
			pst = con.prepareStatement(insertSQL);
			pst.setInt(1, aStudent.getId());
			pst.setString(2, aStudent.getName());
			pst.setString(3, aStudent.getGender());
			pst.setInt(4, aStudent.getScore());
			isSucceed = pst.executeUpdate() > 0;
		}else {
			// 不存在该条目
			System.out.println("已存在该条目");
		}
		pst.close();
		
		return isSucceed;
	}
	public static boolean addStudent(Student aStudent) throws SQLException{
		boolean isSucceed = false;
		String querySQL = "SELECT * FROM student WHERE sid=?";
		PreparedStatement pst = con.prepareStatement(querySQL);
		pst.setInt(1, aStudent.getId());
		ResultSet result = pst.executeQuery();
		
		if(!result.next()) {
			// 不存在该id条目
			result.close();
			pst.close();
			String insertSQL = "INSERT INTO student(sid, sname, sgender, sscore) VALUES (?,?,?,?)";
			pst = con.prepareStatement(insertSQL);
			pst.setInt(1, aStudent.getId());
			pst.setString(2, aStudent.getName());
			pst.setString(3, aStudent.getGender());
			pst.setInt(4, aStudent.getScore());
			isSucceed = pst.executeUpdate() > 0;
		}
		pst.close();
		
		if(isSucceed) {
			System.out.println("成功添加学生：" + aStudent);
		}else {
			System.out.println("数据库中已有编号"+aStudent.getId()+"的学生存在，不能再次添加。");			
		}
		return isSucceed;
	}
	public static boolean deleteStudentById(String id) throws NumberFormatException, SQLException{
		String sql = "DELETE FROM student WHERE sid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(id));
		int deletedNum= pst.executeUpdate();
		pst.close();
		return deletedNum > 0;
	}
	
	public static Student getStudentById(String id) throws NumberFormatException, SQLException{
		String sql = "SELECT * FROM student WHERE sid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(id));
		ResultSet result = pst.executeQuery();
		Student aStudent = null;
		if(result.next()) {
			aStudent = new Student(result.getInt("sid"), result.getString("sname"), result.getString("sgender"), result.getInt("sscore"));
		}
		result.close();
		pst.close();
		return aStudent;
	}
	
	public static List<Student> getAllStudent() throws SQLException{
		String sql = "SELECT * FROM student";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet result = pst.executeQuery();
		List<Student> students = new ArrayList<Student>();
		while(result.next()) {
			students.add(new Student(result.getInt("sid"), result.getString("sname"), result.getString("sgender"), result.getInt("sscore")));
		}
		result.close();
		pst.close();
		return students;
	}
	
	public static void saveHighScoreStudent(int average) throws SQLException, IOException {
		String sql = "SELECT * FROM student WHERE sscore>?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, average);
		ResultSet result = pst.executeQuery();
		FileWriter fw = new FileWriter("studentInfo.txt");
		PrintWriter writer = new PrintWriter(fw);
		while(result.next()) {
			writer.println(result.getString(1) + "-" + 
					result.getString(2) + "-" + 
					result.getString(3) + "-" + 
					result.getString(4));
		}
		System.out.println("成功写入文件studenInfo.txt");
		writer.close();
		result.close();
		pst.close();
	}
	
	public static int showAverage() throws SQLException {
		String sql = "SELECT AVG(sscore) as avescore FROM student WHERE sgender='男'";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet result = pst.executeQuery();
		if(result.next()) {
			System.out.println("所有男学生的平均成绩是" + result.getInt("avescore"));
		}
		result.close();
		pst.close();
		
		sql = "SELECT AVG(sscore) as avescore FROM student WHERE sgender='女'";
		pst = con.prepareStatement(sql);
		result = pst.executeQuery();
		if(result.next()) {
			System.out.println("所有女学生的平均成绩是" + result.getInt("avescore"));
		}
		result.close();
		pst.close();
		
		sql = "SELECT AVG(sscore) as avescore FROM student";
		pst = con.prepareStatement(sql);
		result = pst.executeQuery();
		int average = 0;
		if(result.next()) {
			average = result.getInt("avescore");
			System.out.println("全班学生的平均成绩是" + average);
		}
		result.close();
		pst.close();
		return  average;
	}
		
	public static void showGirlsMoreThan60() throws SQLException {
		String sql = "SELECT * FROM student WHERE sgender='女' && sscore>60";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet result = pst.executeQuery();
		if(result.next()) {
			System.out.println("超过60分的女生如下：");
			do {				
				System.out.println(result.getString("sname") + "..." + result.getString("sgender") + "..." + result.getInt("sscore"));
			}while(result.next());
		}else {
			System.out.println("不存在超过60分的女生");
		}
		result.close();
		pst.close();
	}
	
	public static void count() throws SQLException {
		String sql = "SELECT COUNT(*) AS count FROM student WHERE sgender='女' && sscore>=80;";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet result = pst.executeQuery();
		if(result.next()) {
			System.out.println("80分以上女生有" + result.getInt("count") + "个");
		}
		pst.close();
	}
	
	public static void modifyScore() throws SQLException {
		String sql1 = "SELECT * FROM student WHERE sgender='男'";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		ResultSet result1 = pst1.executeQuery();

		int numOfZhang = 0;
		int sid;
		String sname;
		String sql2;
		PreparedStatement pst2 = null;
		while(result1.next()) {
			// 遍历所有男同学
			sid = result1.getInt("sid");
			sname = result1.getString("sname");
			if(sname.startsWith("张")) {			
				// 该男同学姓张，需要修改其成绩
				numOfZhang++;
				sql2 = "UPDATE student SET sscore=100 WHERE sid=?";
				pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, sid);
				if(pst2.executeUpdate() > 0) {
					System.out.println("成功修改男生"+sname+"的成绩至100.");
				}				
				pst2.close();
			}
		}
		if(numOfZhang == 0){			
			System.out.println("没有姓张的男同学");
		}
		result1.close();
		pst1.close();
	}
	
	
}
