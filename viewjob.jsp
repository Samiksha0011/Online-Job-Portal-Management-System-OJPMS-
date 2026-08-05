<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<meta charset="UTF-8">

<title>OJPMS - View Jobs</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/navbar.css">
<link rel="stylesheet" href="assests/jobs.css">
<link rel="stylesheet" href="assests/jobseeker_profile.css">

</head>

<body>

	<jsp:include page="navbar.jsp"/>

	<!-- Page Header -->
	<div class="page-header">

		<h1>Explore Career Opportunities</h1>

		<p class="subtitle">
			Discover jobs that match your skills and ambitions.
		</p>

	</div>

	<!-- Job Summary -->
	<div class="job-summary">

		<div class="summary-card">
			<h3>${jobs.size()}</h3>
			<p>Available Jobs</p>
		</div>

		<div class="summary-card">
			<h3>24x7</h3>
			<p>Job Updates</p>
		</div>

		<div class="summary-card">
			<h3>100%</h3>
			<p>Free Applications</p>
		</div>

	</div>

	<!-- Search Section -->
	<form action="viewjob" class="search-container">

		<input type="search"
			   name="search"
			   placeholder="Search by title, location or keyword">

		<input type="submit" value="Search">

		<a href="viewjob"
		   class="apply-btn"
		   style="text-decoration:none;">
			Refresh
		</a>

	</form>



	<!-- Empty Jobs Message -->
	<c:if test="${empty jobs}">

		<p class="no-job">
			No matching jobs found.
			Try searching with different keywords.
		</p>

	</c:if>
	<c:if test="${not empty resumeerror}">
   		<div class="error-banner"> ${resumeerror}
   		</div>
	</c:if>
	
	<c:if test="${not empty success}">
   		<div class="success-banner"> ${success}
   		</div>
	</c:if>
	<!-- Job Cards -->
	<div class="jobs-container">

		<c:forEach var="job" items="${jobs}">

			<div class="job-card">

				<h3>${job.title}</h3>

				<p>
					<b>📄 Description:</b>
					${job.description}
				</p>

				<p>
					<b>📍 Location:</b>
					${job.location}
				</p>

				<p>
					<b>₹ Salary:</b>
					${job.salary}
				</p>

				<p>
   					 <b>🗓️ Posted On:</b>
   					${job.postedDate}
				</p>
				
				<p>
					<b>Status:</b>
					Open
				</p>

				<p>
					<b>Application Type:</b>
					Quick Apply
				</p>

				<form action="applyjob" method="post">

					<input type="hidden"
						   name="jobId"
						   value="${job.id}">

					<input type="submit"
						   value="Apply Now"
						   class="apply-btn">

				</form>

				<c:if test="${appliedId == job.id}">
					<p style="color : red" class="error">${error}</p>
				</c:if>
				
				<%-- <c:if test="${not empty error}">
    				<div class="error-banner"> ${error}
   					</div>
				</c:if> --%>

			</div>

		</c:forEach>

	</div>

	<!-- Career Tips -->
	<div class="career-tips">

		<h2>Career Tips</h2>

		<ul>

			<li>Keep your resume updated with your latest skills.</li>

			<li>Apply only to jobs that match your profile.</li>

			<li>Read the job description carefully before applying.</li>

			<li>Prepare for interviews before receiving a call.</li>

			<li>Regularly check for newly posted opportunities.</li>

		</ul>

	</div>

</body>
</html>