<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<title>OJPMS - User Dashboard</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/user_dashboard.css">

</head>

<body>

<jsp:include page="navbar.jsp" />

<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
%>

<div class="dashboard">

	<!-- Welcome Section -->
	<div class="welcome-section">

		<h1>Welcome Back, ${user.name}</h1>

		<p>
			Manage your profile, explore opportunities,
			and track your job applications.
		</p>
		
		<p class="success"> ${success} </p>
	<%
		session.removeAttribute("success");
	%>
	</div>

	<!-- Dashboard Statistics -->
	<div class="stats-section">

		<div class="card">
			<h2>${appliedJobs}</h2>
			<p>Applied Jobs</p>
		</div>

		<div class="card">
			<h2>0</h2>
			<p>Saved Jobs</p>
		</div>

		<div class="card">
			<h2>0</h2>
			<p>Interview Calls</p>
		</div>

		<div class="card">
			<h2>0</h2>
			<p>Profile Views</p>
		</div>

	</div>


<div class="quick-actions">

    <h2>Quick Actions</h2>

    <div class="quick-actions-links">

         <a href="viewjob">💼 View Jobs </a>

       <a href="editjobseekerprofile?userId=${user.id}"> 👤 Update Profile </a>

        <a href="uploadresume">📋 Upload Resume  </a>

        <a href="myapplications"> 📋 My Applications </a>

    </div>

</div>

	<!-- Profile Completion -->
	<div class="profile-section">

		<h2>Profile Completion</h2>

		<p>
			Complete your profile to improve visibility
			to recruiters.
		</p>

		<h3>40%</h3>

	</div>
<div class="dashboard-grid">
	<!-- Recommended Jobs -->
	<div class="recommended-jobs">

		<h2>Recommended Jobs</h2>

		<ul>

			<li>
				Java Developer - Pune
			</li>

			<li>
				Full Stack Developer - Mumbai
			</li>

			<li>
				Data Analyst - Bangalore
			</li>

		</ul>

	</div>

	<!-- Recent Activity -->
	<div class="recent-activity">

		<h2>Recent Activity</h2>

		<ul>

			<li>
				No recent activity available.
			</li>

		</ul>

	</div>

	<!-- Resume Status -->
	<div class="resume-status">

		<h2>Resume Status</h2>

		<p>
			No resume uploaded yet.
		</p>

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

	<!-- Career Tips -->
	<div class="career-tips">

		<h2>Career Tips</h2>

		<ul>

			<li>
				Keep your resume updated.
			</li>

			<li>
				Apply to jobs regularly.
			</li>

			<li>
				Add relevant skills to your profile.
			</li>

		</ul>

	</div>
	
	</div>

</div>

</body>
</html>
