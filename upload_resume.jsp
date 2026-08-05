<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Upload Resume</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/upload_resume.css">
</head>

<body>

	<jsp:include page="navbar.jsp" />

	<div class="upload-wrapper">

		<div class="upload-card">

			<div class="upload-icon">📄</div>

			<h1>Upload Resume</h1>

			<p>Upload your latest resume in PDF format.</p>

			<form action="saveresume" method="post" enctype="multipart/form-data">

				<div class="file-box">

					<input type="file" name="resume" accept="application/pdf" required>

				</div>

				<button type="submit" class="upload-btn">Upload Resume</button>

			</form>

			<div class="resume-info">

				Supported Format: PDF <br> Recommended Size: Less than 5 MB

			</div>

		</div>

	</div>

</body>

</html>