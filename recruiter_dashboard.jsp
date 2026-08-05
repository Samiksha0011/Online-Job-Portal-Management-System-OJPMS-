<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<title>OJPMS - Recruiter Dashboard</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/recruiter_dashboard.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
%>

<div class="dashboard">

	<!-- Welcome Section -->
	<div class="welcome-section">

		<h1>Recruiter Dashboard</h1>

		<h2>Welcome Back, ${user.name}</h2>

		<p>
			Manage jobs, review applications,
			and hire talented candidates.
		</p>
		
		<p class="success"> ${success} </p>

	<%
		session.removeAttribute("success");
	%>

	</div>

	<!-- Statistics -->
	<div class="stats-section">

    <div class="card">
        <h2>${jobCount}</h2>
        <p>Total Jobs Posted</p>
    </div>

    <div class="card">
        <h2>12</h2>
        <p>Active Jobs</p>
    </div>

    <div class="card">
        <h2>${applicationCount}</h2>
        <p>Applications Received</p>
    </div>

    <div class="card">
        <h2>89%</h2>
        <p>Hiring Success Rate</p>
    </div>
   
    </div>

<div class="quick-actions">

    <h2>Quick Actions</h2>

    <div class="quick-actions-links">

        <a href="post_job.jsp">📋 Post Job</a>

        <a href="managejobs">📂 Manage Jobs</a>

        <a href="viewapplicants">👥 View Applicants</a>

        <a href="profile.jsp">Update Profile</a>

    </div>

</div>

	<!-- Recent Jobs -->
	<div class="recent-jobs">

		<h2>Recently Posted Jobs</h2>

		<ul>

			<li>
				No jobs posted yet.
			</li>

		</ul>

	</div>

	<!-- Latest Applications -->
	<div class="applications">

		<h2>Latest Applications</h2>

		<ul>

			<li>
				No applications received.
			</li>

		</ul>

	</div>

	<!-- Notifications -->
	<div class="notifications">

		<h2>Notifications</h2>

		<ul>

			<li>
				No new notifications.
			</li>

		</ul>

	</div>

	<!-- Hiring Tips -->
	<div class="tips">

		<h2>Recruiter Tips</h2>

		<ul>

			<li>
				Complete your company profile.
			</li>

			<li>
				Write detailed job descriptions.
			</li>

			<li>
				Respond to applicants promptly.
			</li>

			<li>
				Keep job postings updated.
			</li>

		</ul>

	</div>


</div>

</body>
</html>
