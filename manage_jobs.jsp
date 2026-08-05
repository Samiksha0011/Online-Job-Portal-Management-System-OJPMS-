<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Jobs</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/manage_job.css?v=3">

</head>

<body>

	<jsp:include page="navbar.jsp" />

	<%
	if (session.getAttribute("user") == null)
		response.sendRedirect("login.jsp");
	%>

	<div class="jobs-page">

		<h1>Manage Jobs</h1>

		<p>View all jobs posted by you.</p>

		<c:if test="${empty jobs}">
			<h3>No jobs posted yet.</h3>
		</c:if>

		<div class="jobs-container">

			<c:forEach var="job" items="${jobs}">

				<div class="job-card">

					<h2>${job.title}</h2>

					<p>
						<b>Description:</b> ${job.description}
					</p>

					<p>
						🗓️<b>Posted on:</b> ${job.postedDate}
					</p>
					
					<p>
						📍<b>Location:</b> ${job.location}
					</p>

					<p>
						<b>Salary:</b> ₹${job.salary}
					</p>

					<span class="status"> ● Active </span>
				 <div class="job-actions">

   					 <a href="editjob?id=${job.id}" class="action-btn edit-btn">
        				✏️ Edit
					  </a>

   					 <a href="deletejob?id=${job.id}" class="action-btn delete-btn" onclick="return confirm('Are you sure you want to delete this job?');">
        				🗑️ Delete

    				</a>

				</div>
				</div>

			</c:forEach>

		</div>

	</div>

</body>
</html>