<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.jsp.ojpms.entity.User" %>

<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;500;600;700&display=swap"
rel="stylesheet">
<meta charset="UTF-8">
<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/navbar.css">
<title>Navbar</title>
</head>

<body>

<%
	User user = (User) session.getAttribute("user");
%>

<div class="navbar">

	<!-- Left Section -->
	<div class="nav-left">

		<a href="home.jsp" class="logo">
			OJPMS
		</a>

		<%
			if(user != null && user.getRole().equals("JOB_SEEKER"))
			{
		%>

		<form action="viewjob" method="get" class="nav-search">

			<input type="search"
				   name="search"
				   placeholder="Search jobs...">

			<button type="submit">
				Search
			</button>

		</form>

		<%
			}
		%>

	</div>

	<!-- Right Section -->
	<div class="nav-right">
		<button id="themeToggle" class="theme-btn">🌙 </button>
		<%
			if(user == null)
			{
		%>

			<a href="home.jsp" class="nav-btn">Home</a>

			<a href="login.jsp" class="nav-btn">Login</a>

			<a href="register.jsp" class="nav-btn">Register</a>

		<%
			}
			else if(user.getRole().equals("JOB_SEEKER"))
			{
		%>

			<a href="userdashboard" class="nav-btn">
				Dashboard
			</a>

			<a href="viewjob" class="nav-btn">
				Jobs
			</a>
			
			<a href="profile?id=<%= user.getId() %>" class="nav-btn">
    			 Profile
			</a>

			<span class="user-name">
				Hi, <%= user.getName() %>
			</span>

			<a href="logout" class="logout-btn">
				Logout
			</a>

		<%
			}
			else if(user.getRole().equals("RECRUITER"))
			{
		%>

			<a href="recruiterdashboard" class="nav-btn">
				Dashboard
			</a>

			<a href="post_job.jsp" class="nav-btn">
				Post Job
			</a>
			
			<a href="profile.jsp" class="nav-btn">
    			 Profile
			</a>

			<span class="user-name">
				Hi, <%= user.getName() %>
			</span>

			<a href="logout" class="logout-btn">
				Logout
			</a>

		<%
			}
		%>

	</div>

<script>

const themeBtn =
document.getElementById("themeToggle");

if(localStorage.getItem("theme")==="dark"){

    document.body.classList.add("dark-theme");

    themeBtn.innerHTML="☀️";
}

themeBtn.addEventListener("click",()=>{

    document.body.classList.toggle("dark-theme");

    if(document.body.classList.contains("dark-theme")){

        localStorage.setItem("theme","dark");

        themeBtn.innerHTML="☀️";
    }
    else{

        localStorage.setItem("theme","light");

        themeBtn.innerHTML="🌙";
    }

});

</script>
</div>

</body>
</html>