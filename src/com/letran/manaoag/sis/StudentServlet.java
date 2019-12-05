package com.letran.manaoag.sis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letran.manaoag.sis.dao.StudentDAO;
import com.letran.manaoag.sis.entity.Student;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name="StudentServlet",urlPatterns= {
		"/search",
		"/new",
		"/edit",
		"/update",
		"/delete"
		})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDAO studentDAO;
	
	private String url="jdbc:mysql://localhost:3306/students",
			username="root",
			password="";
	
	private String driver = "org.gjt.mm.mysql.Driver";
	
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
	
		String action=request.getServletPath();
		
		if(action.equals("/new")) {
			addStudent(request,response);
		}else if(action.equals("/edit")) {
			ShowEditForm(request,response);
		}else if(action.equals("/update")) {
			UpdateStudent(request,response);
		}else if(action.equals("/search")) {
			SearchStudent(request,response);
		}else if(action.equals("/delete")) {
			
		}else {
			StudentList(request,response);
		}
		
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

	private void UpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		String snum=request.getParameter("snum");
		String first_name=request.getParameter("first_name");
		String middle_name=request.getParameter("middle_name");
		String last_name=request.getParameter("last_name");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String contact_no=request.getParameter("contact_no");
		String address=request.getParameter("address");
		String father_name=request.getParameter("father_name");
		String mother_name=request.getParameter("mother_name");
		String nationality=request.getParameter("nationality");
		String religion=request.getParameter("religion");
		String civil_status=request.getParameter("civil_status");
		String course=request.getParameter("course");
		String year=request.getParameter("year");
		
		
		studentDAO=new StudentDAO();
		
		studentDAO.EditStudent(new Student(sid,snum,first_name,middle_name,last_name,age,gender,birthday,
				contact_no,address,father_name,mother_name,nationality,religion,
				civil_status,course,year));
		
		//response.sendRedirect("success.jsp");
		StudentList(request,response);
	}
	
	public void StudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		studentDAO=new StudentDAO();
		
		List<Student> students = new ArrayList<>();
		students=studentDAO.selectAllStudents();
		request.setAttribute("studentList", students);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	

private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	String snum=request.getParameter("snum");
	String first_name=request.getParameter("first_name");
	String middle_name=request.getParameter("middle_name");
	String last_name=request.getParameter("last_name");
	String age=request.getParameter("age");
	String gender=request.getParameter("gender");
	String birthday=request.getParameter("birthday");
	String contact_no=request.getParameter("contact_no");
	String address=request.getParameter("address");
	String father_name=request.getParameter("father_name");
	String mother_name=request.getParameter("mother_name");
	String nationality=request.getParameter("nationality");
	String religion=request.getParameter("religion");
	String civil_status=request.getParameter("civil_status");
	String course=request.getParameter("course");
	String year=request.getParameter("year");
	
	
	studentDAO=new StudentDAO();
	
	studentDAO.AddStudent(new Student(snum,first_name,middle_name,last_name,age,gender,birthday,
			contact_no,address,father_name,mother_name,nationality,religion,
			civil_status,course,year));
	
	RequestDispatcher rd=request.getRequestDispatcher("new.jsp");
	rd.forward(request, response);
	
}


private void ShowEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	String getSnum = request.getParameter("snum");
	request.setAttribute("snum", getSnum);
	
	studentDAO=new StudentDAO();
	
	List<Student> students = new ArrayList<>();
	students=studentDAO.getStudent(getSnum);
	request.setAttribute("student", students);
	RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
	rd.forward(request, response);
	
	
	}


private void SearchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String search_field=request.getParameter("search_field");
	
	studentDAO=new StudentDAO();
	
	List<Student> students = new ArrayList<>();
	students=studentDAO.searchStudent(search_field);
	request.setAttribute("studentList", students);
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	
	}

}
