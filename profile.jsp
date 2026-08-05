<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.jsp.ojpms.entity.User" %>

<%
    User user = (User) session.getAttribute("user");

    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="assests/base.css">
    <link rel="stylesheet" href="assests/navbar.css">
    <link rel="stylesheet" href="assests/profile.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="profile-wrapper">

    <div class="profile-card">

       <div class="profile-header">

    	<div class="avatar">
       		 ${user.name.substring(0,1).toUpperCase()}
   		 </div>

   			 <h2>${user.name}</h2>

   			 <p class="role">${user.role}</p>

   		 <div class="profile-badge">
       		 Active Member
   			 </div>

</div>

        <div class="profile-details">
       	  <p> <b>ID:</b> ${user.getId()}</p>
          <p>📧 <b>Email:</b> ${user.email}</p>
		  <p>👤 <b>Role:</b> ${user.role}</p>
		  
		  
        </div>

        <!-- <div class="profile-actions">
            <a href="editprofile" class="btn">Edit Profile</a>
        </div> -->

		<form action="editprofile" >
			<input type="text" hidden="" name="userId" value="${user.id }">
			<input type="submit" value="Edit">
		</form>
    </div>

</div>

</body>
</html>