<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/StudentInfoSystemJSPServlet/css/style.css" />
<title>LETRAN-MANAOAG</title>
</head>
<body id="edit-page">

<h1>LETRAN-MANAOAG STUDENT INFORMATION SYSTEM WEB APP. V1.0</h1>

<h2>EDIT STUDENT</h2>

	<div class="upper-container">
		<h3>Welcome <span>${user}</span></h3>
		<a href="new.jsp">ADD NEW RECORD</a>
		<form action="logout" method="post">
		<input class="log-out-btn" type="submit" value="log out" />
	</form>
	</div>

	<% //set session pag nag log-in
		response.setHeader("Cache-Control","no-cache,must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0");
		if(session.getAttribute("user")==null){
			response.sendRedirect("login.jsp");
		}
	%>

<form action="update" method="post">
<c:forEach var="std" items="${student}">
	<p>ID<input type="text" name="sid" readonly="readonly" value="<c:out value="${std.sid}"></c:out>"/></p>
	<p>Student ID: <input type="text" name="snum" value="<c:out value="${std.snum}"></c:out>"/></p>
	<p>First Name: <input type="text" name="first_name" value="<c:out value="${std.first_name}"></c:out>"/></p>
	<p>Middle Name: <input type="text" name="middle_name" value="<c:out value="${std.middle_name}"></c:out>"/></p>
	<p>Last Name: <input type="text" name="last_name" value="<c:out value="${std.last_name}"></c:out>"/></p>
	<p>Age: <input type="text" name="age" value="<c:out value="${std.age}"></c:out>"/></p>
	<p>Gender: 
		<select name = "gender">
			 <option><c:out value="${std.gender}"></c:out></option>
			 <option value = "Male">Male</option>
			 <option value = "Female">Female</option>
		</select>
	</p>
	<p>Birthday: <input type="text" name="birthday" value="<c:out value="${std.birthday}"></c:out>"/></p>
	<p>Contact No: <input type="text" name="contact_no" value="<c:out value="${std.contact_no}"></c:out>"/></p>
	<p>Address: <input type="text" name="address" value="<c:out value="${std.address}"></c:out>"/></p>
	<p>Father's Name: <input type="text" name="father_name" value="<c:out value="${std.father_name}"></c:out>"/></p>
	<p>Mother's Name: <input type="text" name="mother_name" value="<c:out value="${std.mother_name}"></c:out>"/></p>
	<p>Nationality: <input type="text" name="nationality" value="<c:out value="${std.nationality}"></c:out>"/></p>
	<p>Religion: <input type="text" name="religion" value="<c:out value="${std.religion}"></c:out>"/></p>
	<p>Civil Status: 
		<select name = "civil_status">
			<option><c:out value="${std.civil_status}"></c:out></option>
			 <option value = "Single">Single</option>
			 <option value = "Married">Married</option>
			 <option value = "Widowed">Widowed</option>
			 <option value = "Separated">Separated</option>
			 <option value = "Divorced">Divorced</option>
		</select>
	</p>
	<p>Course:
		<select name = "course">
			<option><c:out value="${std.course}"></c:out></option>
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
			<option><c:out value="${std.year}"></c:out></option>
			 <option value = "1">1</option>
			 <option value = "2">2</option>
			 <option value = "3">3</option>
			 <option value = "4">4</option>
		</select>
	</p>
	</c:forEach>
	
	<input type="submit" value="SAVE CHANGES" />
</form>

<%@ include file="/footer.jsp" %>

</body>
</html>