<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="UTF-8">
<title>OJPMS - Post Job</title>
<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/post_job.css">
</head>

<body>


<jsp:include page="navbar.jsp" />

<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
%>

<div class="form-container">

	<!-- Page Heading -->
	<div class="page-header">

		<h1>Post New Job</h1>

		<p>
			Create a new job opportunity and connect with talented
			candidates through OJPMS.
		</p>

	</div>

	<!-- Job Posting Form -->
	<form action="postjob" method="post">

		<label>Job Title</label>
		<input type="text"
			   name="title"
			   placeholder="e.g. Java Developer"
			   required>

		<label>Job Description</label>
		<textarea name="description"
				  rows="6"
				  placeholder="Describe responsibilities, requirements and expectations"
				  required></textarea>

		<label>Location</label>
		<input type="text"
			   name="location"
			   placeholder="e.g. Pune, Maharashtra"
			   required>

		<label>Salary</label>
		<input type="number"
			   name="salary"
			   placeholder="Enter Salary"
			   required>
			   
			   

		<input type="submit" value="Post Job">

	</form>

	<!-- Job Posting Guidelines -->
	<div class="guidelines">

		<h2>Job Posting Guidelines</h2>

		<ul>
			<li>Use a clear and meaningful job title.</li>
			<li>Mention important responsibilities.</li>
			<li>Provide accurate location information.</li>
			<li>Specify realistic salary details.</li>
			<li>Avoid misleading or incomplete information.</li>
		</ul>

	</div>

	<!-- Recruiter Tips -->
	<div class="tips">

		<h2>Recruiter Tips</h2>

		<ul>
			<li>Detailed job descriptions attract better candidates.</li>
			<li>Keep your postings updated regularly.</li>
			<li>Respond to applications quickly.</li>
			<li>Review applicants consistently.</li>
		</ul>

	</div>

	<!-- Quick Navigation -->
	<div class="quick-links">

		<a href="recruiter_dashboard.jsp">
			← Back to Dashboard
		</a>

	</div>

</div>


</body>
</html>
