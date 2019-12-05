<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/StudentInfoSystemJSPServlet/css/style.css" />
<title>Insert title here</title>
</head>
<body id="new-page">
<% //set session pag nag log-in
		response.setHeader("Cache-Control","no-cache,must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0");
		if(session.getAttribute("user")==null){
			response.sendRedirect("login.jsp");
		}
	%>
<h1>LETRAN-MANAOAG STUDENT INFORMATION SYSTEM WEB APP. V1.0</h1>
<h2>ADD STUDENT</h2>

	<div class="upper-container">
		<h3>Welcome <span>${user}</span></h3>
		<a href="new.jsp">ADD NEW RECORD</a>
		<form action="logout" method="post">
			<input class="log-out-btn" type="submit" value="log out" />
		</form>
	</div>

	<form action="new" method="post">
	<p><input type="text" name="snum" placeholder="Student No:" /></p>
	<p><input type="text" name="first_name" placeholder="First Name:" /></p>
	<p><input type="text" name="middle_name" placeholder="Middle Name:" /></p>
	<p><input type="text" name="last_name" placeholder="last Name:" /></p>
	<p><input type="text" name="age" placeholder="Age:" /></p>
	<p>Gender: 
		<select name = "gender">
			 <option value = "Male">Male</option>
			 <option value = "Female">Female</option>
		</select>
	</p>
	<p><input type="text" name="birthday" placeholder="Birthday:" /></p>
	<p><input type="text" name="contact_no" placeholder="Contact No:" /></p>
	<p><input type="text" name="address" placeholder="Address:" /></p>
	<p><input type="text" name="father_name" placeholder="Father's Name:" /></p>
	<p><input type="text" name="mother_name" placeholder="Mother's Name:" /></p>
	<p><input type="text" name="nationality" placeholder="Nationality:" /></p>
	<p><input type="text" name="religion" placeholder="Religion:" /></p>
	<p>Civil Status: 
		<select name = "civil_status">
			 <option value = "Single">Single</option>
			 <option value = "Married">Married</option>
			 <option value = "Widowed">Widowed</option>
			 <option value = "Separated">Separated</option>
			 <option value = "Divorced">Divorced</option>
		</select>
	</p>
	<p>Course:
		<select name = "course">
			 <option value = "BSIT">BSIT</option>
			 <option value = "Com-Tech">Com-Tech</option>
			 <option value = "Com-Prog">Com-Prog</option>
			 <option value = "BSED">BSED</option>
			 <option value = "BEED">BEED</option>
			 <option value = "BSRE">BSRE</option>
			 <option value = "BSBA">BSBA</option>
		</select>
	</p>
	<p>Year:
		<select name = "year">
			 <option value = "1">1</option>
			 <option value = "2">2</option>
			 <option value = "3">3</option>
			 <option value = "4">4</option>
		</select>
	</p>
	
	<input type="submit" value="SUBMIT" />
</form>

<%@ include file="/footer.jsp" %>
</body>
</html>