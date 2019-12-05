package com.letran.manaoag.sis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/home","/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action=request.getServletPath();
		
		if(action.equals("/home")) {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			StudentServlet studServ = new StudentServlet();
			
			if(user.equals("admin") && pass.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				studServ.StudentList(request, response);
			}else if(user.equals("eyeshield") && pass.equals("rosalin")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				studServ.StudentList(request, response);
			}else {
				response.sendRedirect("login.jsp");
			}
		}else if(action.equals("/logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
