<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ page import="com.jsp.ojpms.entity.JobSeekerProfile"%>

<%
JobSeekerProfile profile = (JobSeekerProfile) request.getAttribute("profile");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Professional Profile</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/navbar.css">
<link rel="stylesheet" href="assests/jobseeker_profile.css?v=3">

</head>

<body>

	<jsp:include page="navbar.jsp" />

	<div class="profile-container">

		<!-- LEFT SIDEBAR -->

		<div class="profile-sidebar">

			<div class="avatar">${user.name.substring(0,1).toUpperCase()}</div>

			<h2>${user.name}</h2>

			<p class="headline">${empty profile.headline ?
            "Professional Headline Not Added" :
            profile.headline}

			</p>


			<div class="contact-info">

				<p>📧 ${user.email}</p>

				<p>📞 ${empty profile.mobileNumber ?
                "Not Added" :
                profile.mobileNumber}

				</p>

				<p>📍 ${empty profile.location ?
                "Not Added" :
                profile.location}

				</p>

			</div>

			<div class="completion-section">

				<h4>Profile Completion</h4>

				<div class="progress-bar">

					<div class="progress" style="width:${completionPercentage}%">
					</div>

				</div>

				<p>${completionPercentage}%Complete</p>

				<c:if test="${completionPercentage < 100}">
					<small> Complete your profile to attract recruiters. </small>
				</c:if>

			</div>

			<c:if test="${empty viewOnly}">

    <div class="profile-actions">

        <form action="editjobseekerprofile">

            <input type="hidden"
                   name="userId"
                   value="${user.id}">

            <button type="submit">
                Edit Profile
            </button>

        </form>

        <a href="changepassword">
            Change Password
        </a>

        <a href="changeemail.jsp">
            Change Email
        </a>

    </div>

</c:if>
		</div>

		<!-- RIGHT CONTENT -->

		<div class="profile-content">

			<%
			String success = (String) session.getAttribute("success");

			if (success != null) {
			%>

			<div class="success-banner">

				<%=success%>

			</div>

			<%
			session.removeAttribute("success");
			}
			%>

			<!-- ABOUT -->

			<div class="section">

				<h3>👤 About Me</h3>

				<p class="about-text">${empty profile.about ?

                "Tell recruiters about yourself. Highlight your strengths, experience, interests and career goals."

                :

                profile.about}

				</p>

			</div>

			<!-- SKILLS -->

			<div class="section">

				<h3>🛠️ Skills</h3>

				<div class="skills-container">

					<%
					String skills = profile != null ? profile.getSkills() : null;

					if (skills != null && !skills.trim().isEmpty()) {
						String[] skillArray = skills.split(",");

						for (String skill : skillArray) {
					%>

					<span class="skill-badge"> <%=skill.trim()%>

					</span>

					<%
					}
					} else {
					%>

					<p>No skills added yet.</p>

					<%
					}
					%>

				</div>

			</div>

			<!-- EDUCATION -->

			<div class="section">

				<h3>🎓 Education</h3>

				<div class="education-item">

					<p>

						<b>Degree :</b> ${empty profile.education ?
                    "Not Added" :
                    profile.education}

					</p>

					<p>

						<b>College :</b> ${empty profile.college ?
                    "Not Added" :
                    profile.college}

					</p>

					<p>

						<b>Graduation Year :</b> ${empty profile.graduationYear ?
                    "Not Added" :
                    profile.graduationYear}

					</p>

				</div>

			</div>

			<!-- PROFESSIONAL LINKS -->

			<div class="section">

				<h3>🔗 Professional Links</h3>

				<%
				boolean hasLinks =

						(profile.getLinkedinUrl() != null && !profile.getLinkedinUrl().isEmpty())

						||

						(profile.getGithubUrl() != null && !profile.getGithubUrl().isEmpty());

				if (!hasLinks) {
				%>

				<p>No professional links added yet.</p>

				<%
				}
				%>

				<%
				if (profile.getLinkedinUrl() != null && !profile.getLinkedinUrl().isEmpty()) {
				%>

				<a class="link-item" href="<%=profile.getLinkedinUrl()%>"
					target="_blank"> 🔗 LinkedIn Profile </a>

				<%
				}
				%>

				<%
				if (profile.getGithubUrl() != null && !profile.getGithubUrl().isEmpty()) {
				%>

				<a class="link-item" href="<%=profile.getGithubUrl()%>"
					target="_blank"> 🔗 GitHub Profile </a>

				<%
				}
				%>

			</div>

			<!-- RESUME -->
<c:if test="${empty viewOnly}">
			<div class="section">

				<h3>📄 Resume</h3>

				<div class="resume-box">

					<%
if (profile.getResumePath() == null
    || profile.getResumePath().isEmpty()) {
%>

    <h4>No Resume Uploaded Yet</h4>

    <p>
        Resume not available.
    </p>

    <c:if test="${empty viewOnly}">
        <a href="uploadresume"
           class="resume-btn">

            Upload Resume

        </a>
    </c:if>

<%
}
else {
%>

    <h4>Resume Uploaded Successfully</h4>

    <div class="resume-actions">

        <a href="viewresume"
           target="_blank"
           class="resume-btn">

            View Resume

        </a>

        <c:if test="${empty viewOnly}">

            <a href="uploadresume"
               class="resume-btn">

                Update Resume

            </a>

            <a href="removeresume"
               class="resume-btn delete-btn"
               onclick="return confirm('Are you sure you want to remove your resume?');">

                Remove Resume

            </a>

        </c:if>

    </div>

<%
}
%>
				</div>

			</div>
</c:if>

<c:if test="${not empty viewOnly}">

    <div class="back-section">

        <a href="viewapplicants"
           class="back-btn">

            ←  Applicant List

        </a>

    </div>

</c:if>
		</div>
	</div>

</body>
</html>