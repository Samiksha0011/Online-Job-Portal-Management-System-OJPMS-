<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Job</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/edit_job.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
%>

<div class="form-container">

	<h1>Edit Profile</h1>

	<form action="edituserprofile" method="post">

		<input type="hidden" name="id" value="${user.id}">

		<label>User Name</label>
		<input type="text" name="name" value="${user.name}" required>

		<label>Email</label>
		<input type="email" value="${user.email}" readonly>
		
		<input type="submit" value="Edit Profile">
	</form>
	
	<div style="margin-top:15px;">
			<form action="changeemail" >
 	   			<input type="submit" value="Change Email">
			</form>	
	
			<form action="changepassword">
   				 <input type="submit" value="Change Passowrd">
			</form>	
   		</div>

</div>

</body>
</html>