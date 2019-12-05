package com.letran.manaoag.sis.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.letran.manaoag.sis.entity.Student;
import com.mysql.jdbc.Connection;

public class StudentDAO {
	
	
	private String url="jdbc:mysql://localhost:3306/students",
			username="root",
			password="";
	private String driver = "org.gjt.mm.mysql.Driver";
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private final String INSERT_SQL="INSERT INTO students (student_no,first_name,middle_name,last_name,age,gender,birth_day,"
			+ "contact_no,address,father_name,mother_name,nationality,religion,civil_status,course,year)"
						+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String SELECT_BY_SNUM="SELECT * FROM students WHERE student_no=?";
	private final String SELECT_ALL="SELECT * FROM students";
	private final String DELETE_SQL="DELETE FROM students WHERE snum = ?";
	private final String UPDATE_SQL="UPDATE students SET student_no=?,first_name=?,middle_name=?,last_name=?,"
						+ "age=?,gender=?,birth_day=?,contact_no=?,address=?,father_name=?,mother_name=?,"
						+ "nationality=?,religion=?,civil_status=?,course=?,year=? WHERE sid=?";
	
	public StudentDAO() {
		
	}


public List<Student> selectAllStudents() {
	
	List<Student> students=new ArrayList<>();
	
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		ps=conn.prepareStatement(SELECT_ALL);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			String snum=rs.getString("student_no");
			String first_name=rs.getString("first_name");
			String middle_name=rs.getString("middle_name");
			String last_name=rs.getString("last_name");
			String age=rs.getString("age");
			String gender=rs.getString("gender");
			String birthday=rs.getString("birth_day");
			String contact_no=rs.getString("contact_no");
			String address=rs.getString("address");
			String father_name=rs.getString("father_name");
			String mother_name=rs.getString("mother_name");
			String nationality=rs.getString("nationality");
			String religion=rs.getString("religion");
			String civil_status=rs.getString("civil_status");
			String course=rs.getString("course");
			String year=rs.getString("year");
			
			students.add(new Student(snum,first_name,middle_name,last_name,age,gender,birthday,
					contact_no,address,father_name,mother_name,nationality,religion,
					civil_status,course,year));
		}
		
		conn.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return students;
}


public void AddStudent(Student student) {
	
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		ps = (PreparedStatement) conn.prepareStatement(INSERT_SQL);
		
		if(student.getSnum()==null || student.getFirst_name()==null  || student.getMiddle_name()==null
			|| student.getLast_name()==null || student.getAge()==null || student.getGender()==null
			|| student.getGender()==null || student.getBirthday()==null || student.getContact_no()==null
			|| student.getAddress()==null || student.getFather_name()==null || student.getMother_name()==null
			|| student.getNationality()==null || student.getReligion()==null || student.getCivil_status()==null
			|| student.getCourse()==null || student.getYear()==null) {
			
		}else {
			ps.setString(1, student.getSnum());
			ps.setString(2, student.getFirst_name());
			ps.setString(3, student.getMiddle_name());
			ps.setString(4, student.getLast_name());
			ps.setString(5, student.getAge());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getBirthday());
			ps.setString(8, student.getContact_no());
			ps.setString(9, student.getAddress());
			ps.setString(10, student.getFather_name());
			ps.setString(11, student.getMother_name());
			ps.setString(12, student.getNationality());
			ps.setString(13, student.getReligion());
			ps.setString(14, student.getCivil_status());
			ps.setString(15, student.getCourse());
			ps.setString(16, student.getYear());
			
			
			ps.executeUpdate();
			
			conn.close();
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public List<Student> searchStudent(String search_field) {
	
	String search_query="SELECT * FROM students WHERE first_name LIKE"+"'"+search_field+"%'"+"OR last_name LIKE"+"'"+search_field+"%'";
	
	List<Student> students=new ArrayList<>();
	
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		ps=conn.prepareStatement(search_query);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			String sid=Integer.toString(rs.getInt("sid"));
			String snum=rs.getString("student_no");
			String first_name=rs.getString("first_name");
			String middle_name=rs.getString("middle_name");
			String last_name=rs.getString("last_name");
			String age=rs.getString("age");
			String gender=rs.getString("gender");
			String birthday=rs.getString("birth_day");
			String contact_no=rs.getString("contact_no");
			String address=rs.getString("address");
			String father_name=rs.getString("father_name");
			String mother_name=rs.getString("mother_name");
			String nationality=rs.getString("nationality");
			String religion=rs.getString("religion");
			String civil_status=rs.getString("civil_status");
			String course=rs.getString("course");
			String year=rs.getString("year");
			
			students.add(new Student(sid,snum,first_name,middle_name,last_name,age,gender,birthday,
					contact_no,address,father_name,mother_name,nationality,religion,
					civil_status,course,year));
		}
		
		conn.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return students;
}


public void EditStudent(Student student) {
	
	String getSID = student.getSid();
	
	
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		ps = (PreparedStatement) conn.prepareStatement(UPDATE_SQL);
		
		ps.setString(1, student.getSnum());
		ps.setString(2, student.getFirst_name());
		ps.setString(3, student.getMiddle_name());
		ps.setString(4, student.getLast_name());
		ps.setString(5, student.getAge());
		ps.setString(6, student.getGender());
		ps.setString(7, student.getBirthday());
		ps.setString(8, student.getContact_no());
		ps.setString(9, student.getAddress());
		ps.setString(10, student.getFather_name());
		ps.setString(11, student.getMother_name());
		ps.setString(12, student.getNationality());
		ps.setString(13, student.getReligion());
		ps.setString(14, student.getCivil_status());
		ps.setString(15, student.getCourse());
		ps.setString(16, student.getYear());
		ps.setInt(17, Integer.parseInt(getSID));
			
		ps.executeUpdate();

		conn.close();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Student> getStudent(String student_no) {
	
	List<Student> students=new ArrayList<>();
	
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
		ps=conn.prepareStatement(SELECT_BY_SNUM);
		ps.setString(1, student_no);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			String sid = rs.getString("sid");
			String snum=rs.getString("student_no");
			String first_name=rs.getString("first_name");
			String middle_name=rs.getString("middle_name");
			String last_name=rs.getString("last_name");
			String age=rs.getString("age");
			String gender=rs.getString("gender");
			String birthday=rs.getString("birth_day");
			String contact_no=rs.getString("contact_no");
			String address=rs.getString("address");
			String father_name=rs.getString("father_name");
			String mother_name=rs.getString("mother_name");
			String nationality=rs.getString("nationality");
			String religion=rs.getString("religion");
			String civil_status=rs.getString("civil_status");
			String course=rs.getString("course");
			String year=rs.getString("year");
			
			students.add(new Student(sid,snum,first_name,middle_name,last_name,age,gender,birthday,
					contact_no,address,father_name,mother_name,nationality,religion,
					civil_status,course,year));
		}
		
		conn.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return students;
}





}
