<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>View Applicants</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/navbar.css">
<link rel="stylesheet" href="assests/view_applicants.css?v=3">

</head>

<body>

	<jsp:include page="navbar.jsp" />

	<div class="page-header">

		
		<h1>Applicants Dashboard</h1>

		<p>Review and manage candidates who applied to your job postings.
		</p>
		

	</div>

	<div class="jobs-container">

		<c:forEach var="app" items="${applications}">


<c:if test="${app.job.recuriter.id == recruiterId}">

				<div class="job-card">

					<h3>${app.job.title}</h3>

					<p>

						👤 <b>Applicant:</b> ${app.user.name}

					</p>

					<p>

						📧 <b>Email:</b> ${app.user.email}

					</p>

					<p>

						📍 <b>Job Location:</b> ${app.job.location}

					</p>

					<p>

						🗓️ <b>Applied On:</b> ${app.appliedDate}

					</p>

					<!-- ACTION BUTTONS -->

					<div class="applicant-actions">

						<a href="profile?id=${app.user.id}&viewOnly=true"
							class="action-btn profile-btn"> View Profile </a> <a
							href="viewapplicantresume?applicationId=${app.id}"
							class="action-btn resume-btn" target="_blank"> View Resume </a>

					</div>

					<!-- SHORTLIST / REJECT -->

					<c:if test="${app.status == 'APPLIED'}">

						<div class="decision-actions">

							<a
								href="updateapplicationstatus?applicationId=${app.id}&status=SHORTLISTED"
								class="decision-btn accept-btn"
								onclick="return confirm('Shortlist this applicant?');">

								Shortlist </a> <a
								href="updateapplicationstatus?applicationId=${app.id}&status=REJECTED"
								class="decision-btn reject-btn"
								onclick="return confirm('Reject this applicant?');"> Reject

							</a>

						</div>

					</c:if>

					<!-- STATUS -->

					<div class="status-container">

						<c:choose>

							<c:when test="${app.status == 'APPLIED'}">

								<span class="status status-applied"> 📄 Applied </span>

							</c:when>

							<c:when test="${app.status == 'SHORTLISTED'}">

								<span class="status status-selected"> ⭐ Shortlisted </span>

							</c:when>

							<c:when test="${app.status == 'HIRED'}">

								<span class="status status-selected"> 🎉 Hired </span>

							</c:when>

							<c:otherwise>

								<span class="status status-rejected"> ❌ Rejected </span>

							</c:otherwise>

						</c:choose>

					</div>

				</div>

			</c:if>


</c:forEach>

	</div>

</body>
</html>
