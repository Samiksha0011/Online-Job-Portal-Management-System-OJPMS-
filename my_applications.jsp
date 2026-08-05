<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Applications</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/my_applications.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
%>

<div class="applications-page">

	<h1>My Applications</h1>

	<p>
		Track all the jobs you have
		applied for.
	</p>

	<c:if test="${empty applications}">

		<h3>
			You haven't applied for any jobs yet.
		</h3>

	</c:if>
<div class="applications-grid">	
	<c:forEach var="app"
			   items="${applications}">

		<div class="application-card">

			<h2>
				${app.job.title}
			</h2>

			<p>

				<b>Description:</b>

				${app.job.description}

			</p>

			<p>

			 📍	<b>Location:</b>

				${app.job.location}

			</p>

			<p>

				<b>Salary:</b>

				₹${app.job.salary}

			</p>
			
			<p>
    			<b>Applied On:</b>
    			${app.appliedDate}
			</p>

			<c:choose>

    <c:when test="${app.status == 'APPLIED'}">

        <span class="status status-applied">
            📄 Applied
        </span>

    </c:when>

    <c:when test="${app.status == 'SHORTLISTED'}">

        <span class="status status-review">
            ⭐ Shortlisted
        </span>

    </c:when>

    <c:when test="${app.status == 'HIRED'}">

        <span class="status status-selected">
            🎉 Hired
        </span>

    </c:when>

    <c:when test="${app.status == 'REJECTED'}">

        <span class="status status-rejected">
            ❌ Rejected
        </span>

    </c:when>

</c:choose>

		</div>

	</c:forEach>
</div>
</div>

</body>
</html>