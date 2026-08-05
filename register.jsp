<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>OJPMS - Register</title>
<link rel="stylesheet" href="assests/register.css">
</head>
<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

	<!-- Branding -->
	<div class="logo-section">
		<h2>OJPMS</h2>
		<p>Online Job Portal Management System</p>
	</div>

	<!-- Heading -->
	<h1>Create Your Account</h1>
	<p>
		Join OJPMS and connect with top recruiters and exciting career opportunities.
	</p>

	<!-- Registration Form -->
	<form action="register" method="post">

		<label>Full Name</label>
		<input type="text"
			   name="name"
			   placeholder="Enter Full Name"
			   required>

		<label>Email Address</label>
		<input type="email"
			   name="email"
			   placeholder="Enter Email Address"
			   required>

		<label>Password</label>
		<input type="password"
			   id="password"
			   name="password"
			   placeholder="Create Password"
			   required>

	
		<label>Register As</label>
		<select name="role" required>

			<option value="">
				Select Role
			</option>

			<option value="JOB_SEEKER">
				Job Seeker
			</option>

			<option value="RECRUITER">
				Recruiter
			</option>

		</select>

		<br><br>

		<input type="submit" value="Create Account">
		
		<p  style="color: red" class="error">${error}</p>
	</form>

	<!-- Role Information -->
	<div class="role-info">

		<h3>Choose Your Role</h3>

		<ul>
			<li>
				<b>Job Seeker</b> - Search and apply for jobs.
			</li>

			<li>
				<b>Recruiter</b> - Post jobs and hire candidates.
			</li>
		</ul>

	</div>

	<!-- Benefits -->
	<div class="benefits">

		<h3>Benefits of Joining OJPMS</h3>

		<ul>
			<li>Access to multiple job opportunities.</li>
			<li>Create and manage your professional profile.</li>
			<li>Apply to jobs quickly.</li>
			<li>Connect with verified recruiters.</li>
			<li>Track your applications.</li>
		</ul>

	</div>

	<!-- Login Redirect -->
	<div class="login-link">

		<p>
			Already have an account?
			<a href="login.jsp">Login Here</a>
		</p>

	</div>

	<!-- Security Notice -->
	<div class="security-info">

		<p>
			🔒 Your information is securely stored and protected.
		</p>

	</div>

	<!-- Back Home -->
	<div class="back-home">

		<a href="home.jsp">
			← Back to Home
		</a>

	</div>

</div>


</body>
</html>
