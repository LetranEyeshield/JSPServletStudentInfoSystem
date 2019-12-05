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
<body id="index-page">
	<% //set session pag nag log-in
		response.setHeader("Cache-Control","no-cache,must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0");
		if(session.getAttribute("user")==null){
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>LETRAN-MANAOAG STUDENT INFORMATION SYSTEM WEB APP. V1.0</h1>
	
	<div class="upper-container">
		<h3>Welcome <span>${user}</span></h3>
		<a href="new.jsp">ADD NEW RECORD</a>
		<form action="logout" method="post">
			<input class="log-out-btn" type="submit" value="log out" />
		</form>
	</div>
	
	<form action="search" method="post">
		<h2>SEARCH STUDENT</h2>
		<p><input type="text" name="search_field" /></p>
		<input type="submit" value="SEARCH"/>
	</form>
	
		<table border="1" cellspacing="2">
		<tr>
			<th>STUDENT NO:</th>
			<th>FIRST NAME</th>
			<th>MIDDLE NAME</th>
			<th>LAST NAME</th>
			<th>AGE</th>
			<th>GENDER</th>
			<th>BIRTHDAY</th>
			<th>CONTACT NO:</th>
			<th>ADDRESS</th>
			<th>FATHER'S NAME</th>
			<th>MOTHER'S NAME</th>
			<th>NATIONALITY</th>
			<th>RELIGION</th>
			<th>CIVIL STATUS</th>
			<th>COURSE</th>
			<th>YEAR</th>
		</tr>
		<c:forEach var="stds" items="${studentList}">
			<tr>
				<td name="snum"><c:out value="${stds.snum}"></c:out></td>
				<td><c:out value="${stds.first_name}"></c:out></td>
				<td><c:out value="${stds.middle_name}"></c:out></td>
				<td><c:out value="${stds.last_name}"></c:out></td>
				<td><c:out value="${stds.age}"></c:out></td>
				<td><c:out value="${stds.gender}"></c:out></td>
				<td><c:out value="${stds.birthday}"></c:out></td>
				<td><c:out value="${stds.contact_no}"></c:out></td>
				<td><c:out value="${stds.address}"></c:out></td>
				<td><c:out value="${stds.father_name}"></c:out></td>
				<td><c:out value="${stds.mother_name}"></c:out></td>
				<td><c:out value="${stds.nationality}"></c:out></td>
				<td><c:out value="${stds.religion}"></c:out></td>
				<td><c:out value="${stds.civil_status}"></c:out></td>
				<td><c:out value="${stds.course}"></c:out></td>
				<td><c:out value="${stds.year}"></c:out></td>
				<td>
					 <a href="edit?snum=<c:out value='${stds.snum}' />">Edit</a>
					 <a href="delete?snum=<c:out value='${stds.snum}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		
	<%@ include file="/footer.jsp" %>
	
</body>
</html>