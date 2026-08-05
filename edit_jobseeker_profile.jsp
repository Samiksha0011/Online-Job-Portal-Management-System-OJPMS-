<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Professional Profile</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/edit_job.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

	<h1>Edit User Profile</h1>

	<form action="updatejobseekerprofile"
		  method="post">

		<input type="hidden"
			   name="id"
			   value="${profile.id}">
			   
		<label>Full Name</label>

		<input type="text"
      		name="name"
       		value="${profile.user.name}"
       		required>

		<label>Email</label>

		<input type="email"
     		  	value="${profile.user.email}"
       			readonly>
       			
		<label>Headline</label>
		<input type="text"
			   name="headline"
			   value="${profile.headline}">

		<label>About</label>
		<textarea name="about">${profile.about}</textarea>

		<label>Mobile Number</label>
		<input type="text"
			   name="mobileNumber"
			   value="${profile.mobileNumber}">

		<label>Skills</label>
		<input type="text"
			   name="skills"
			   value="${profile.skills}">

		<label>Education</label>
		<input type="text"
			   name="education"
			   value="${profile.education}">

		<label>College</label>
		<input type="text"
			   name="college"
			   value="${profile.college}">

		<label>Graduation Year</label>
		<input type="text"
			   name="graduationYear"
			   value="${profile.graduationYear}">

		<label>Location</label>
		<input type="text"
			   name="location"
			   value="${profile.location}">

		<label>LinkedIn URL</label>
		<input type="text"
			   name="linkedinUrl"
			   value="${profile.linkedinUrl}">

		<label>GitHub URL</label>
		<input type="text"
			   name="githubUrl"
			   value="${profile.githubUrl}">

		<input type="submit"
			   value="Save Profile">

	</form>

</div>

</body>
</html>