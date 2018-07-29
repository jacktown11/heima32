package se.day30;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 学生成绩管理系统练习
 * 使用了dbutils和dbcp
 * @author tjk11
 *
 */
public class StudentManageSystem {
	public static void main(String[] args) throws SQLException, IOException {
		// 
		System.out.println("成绩高于80的女生数目是：" + countGirlsMoreThan(80));
		System.out.println();
		
		System.out.println("已修改" + modifyScoreNamedZhang() + "位姓张的同学分数至100");
		System.out.println();
		
		System.out.println("成绩高于60的女生如下：");
		System.out.println(getGirlsMoreThan(60));
		System.out.println();
		
		System.out.println("男生平均分：" + getAverage("男"));
		System.out.println("女生平均分：" + getAverage("女"));
		System.out.println("全班平均分：" + getAverage());
		System.out.println();
		
		System.out.println("所有学生按成绩升序排列：");
		showAllAndSaveGood();
		System.out.println();
		
		System.out.println("所有的学生：");
		System.out.println(getAllStudent());
		System.out.println();
		
		System.out.println("id为1的学生：");
		System.out.println(getStudentById("1"));
		System.out.println();
		
		System.out.println("删除id为13的学生：删除了" + deleteStudentById("13") + "条");
		System.out.println();
		
		Student aStudent = new Student(13, "jack", "男", 85);
		System.out.println("增加学生：" + aStudent.toString());
		addStudent(aStudent);
		System.out.println();
		
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("sscore", 77);
		info.put("sname", "bob");
		System.out.println("更新4号学生信息，更新了："+updateStudentById("4", info)+"条记录");
		System.out.println(getStudentById("4"));
	}
	
	/**
	 * 查询成绩高于指定值的女生数目
	 * @param score 成绩下界（不含）
	 * @return 超过给定成绩的女生数目
	 * @throws SQLException 
	 */
	public static long countGirlsMoreThan(int score) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String SQL = "SELECT COUNT(*) FROM student WHERE sscore>?";		
		long count = qr.query(SQL, new ScalarHandler<Long>(), score);	
		return count;
	}
	
	/**
	 * 修改新张的同学分数至满分
	 * @throws SQLException 
	 */
	public static int modifyScoreNamedZhang() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String updateSQL = "UPDATE student SET sscore=? WHERE sname LIKE '张%' && sgender='男'";
		int count = qr.update(updateSQL, 100);
		return count;
	}
	
	/**
	 * 显示成绩操作某一分数的女生
	 * @param score 成绩下界（不含）
	 * @return 所有分数高于指定分数的女生的List集合
	 * @throws SQLException 
	 */
	public static List<Student> getGirlsMoreThan(int score) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT * FROM student WHERE sscore>? AND sgender='女'";
		List<Student> result = qr.query(querySQL, new BeanListHandler<Student>(Student.class), score);
		return result;
	}
	
	/**
	 * 返回男生/女生平均分数
	 * @param gender 性别
	 * @return 给定性别的学生的平均分数
	 * @throws SQLException 
	 */
	public static double getAverage(String gender) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT AVG(sscore) FROM student WHERE sgender=?";
		return qr.query(querySQL, new ScalarHandler<BigDecimal>(), gender).doubleValue();
	}
	
	/**
	 * 
	 * @return 全班平均分数
	 * @throws SQLException 
	 */
	public static double getAverage() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT AVG(sscore) FROM student";
		return qr.query(querySQL, new ScalarHandler<BigDecimal>()).doubleValue();
	}
	
	/**
	 * 按成绩升序显示所有学生，并保存高于平均分的学生的信息到studentInfo.txt中
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void showAllAndSaveGood() throws SQLException, IOException {
		// 获取平均分
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT AVG(sscore) FROM student";
		double averageScore = qr.query(querySQL, new ScalarHandler<BigDecimal>()).doubleValue();
		
		// 按成绩升序获取所有学生信息
		querySQL = "SELECT * FROM student ORDER BY sscore ASC";
		List<Student> result = qr.query(querySQL, new BeanListHandler<Student>(Student.class));
		
		PrintStream printer = new PrintStream(new FileOutputStream("studentInfo.txt"));

		int sid, sscore;
		String sname, sgender;
		for(Student st : result) {
			sid = st.getsid();
			sname = st.getsname();
			sgender = st.getsgender();
			sscore  = st.getsscore();
			String aStudentInfo = sid+"-"+sname+"-"+sgender+"-"+sscore;
			if(sscore > averageScore) {
				printer.println(aStudentInfo);
			}
			System.out.println(aStudentInfo);
		}
		printer.close();
	}
	
	/**
	 * 查询所有的学生
	 * @return 所有学生的集合
	 * @throws SQLException 
	 */
	public static List<Student> getAllStudent() throws SQLException{
		String querySQL = "SELECT * FROM student";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(querySQL, new BeanListHandler<Student>(Student.class));
	}
	
	/**
	 * 根据id查询学生
	 * @param id 学生id
	 * @return 指定id的学生
	 * @throws SQLException 
	 */
	public static Student getStudentById(String id) throws SQLException{
		int sid = Integer.parseInt(id);
		String querySQL = "SELECT * FROM student WHERE sid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(querySQL, new BeanHandler<Student>(Student.class), sid);
	}
	/**
	 * 从数据库中根据id删除学生
	 * @param id 学生id
	 * @return 删除数目（成功为1，失败为0）
	 * @throws SQLException 
	 */
	public static int deleteStudentById(String id) throws SQLException{
		int sid = Integer.parseInt(id);
		String updateSQL = "DELETE FROM student WHERE sid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return (int) qr.update(updateSQL, sid);
	}
	
	/**
	 * 向数据库中添加学生
	 * @param aStudent 与添加的学生
	 * @return	添加成功数
	 * @throws SQLException 
	 */
	public static int addStudent(Student aStudent) throws SQLException{
		int sid = aStudent.getsid();
		String sname = aStudent.getsname();
		String sgender = aStudent.getsgender();
		int sscore = aStudent.getsscore();
		int changedNum = 0;
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT COUNT(*) FROM student WHERE sid=?";
		long existedNum = qr.query(querySQL, new ScalarHandler<Long>(), sid); 
		if(existedNum > 0) {
			//  已存在该id条目
			System.out.println("id重复：数据库中已存在该编号条目");
			return changedNum;
		}else {
			// 插入新条目
			String insertSQL = "INSERT INTO student SET sid=?,sname=?,sgender=?,sscore=?";
			changedNum = qr.update(insertSQL, new Object[] {sid, sname, sgender, sscore});
			System.out.println("成功添加学生："+ aStudent.toString());
			return changedNum;
		}
	}
	

	/**
	 * 根据id修改学员的信息
	 * @param id 学员id
	 * @param info 包含学生信息的Map集合(可以只含有sname,sgender,sscore部分信息)
	 * @return 成功更新条目数
	 * @throws SQLException 
	 */
	public static int updateStudentById(String id, Map<String, Object> info) throws SQLException{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String querySQL = "SELECT * FROM student WHERE sid=?";
		Map<String, Object> result = qr.query(querySQL, new MapHandler(), id);
		if(result != null) {
			// 数据库中存在该id
			Object value;
			for(String key : result.keySet()) {
				value = info.get(key);
				// 填补info中可能没有给出的参数项
				info.put(key, value!=null ? value : result.get(key));
			}
			String updateSQL = "UPDATE student SET sname=?,sgender=?,sscore=? WHERE sid=?";
			return qr.update(updateSQL, info.get("sname"), info.get("sgender"), info.get("sscore"), info.get("sid"));
		}else {
			System.out.println("数据库中不存在id为"+id+"的学生条目");
			return 0;
		}
	}
}