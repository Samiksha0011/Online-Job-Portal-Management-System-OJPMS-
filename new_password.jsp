<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ page isELIgnored="false"%>
<html>

<head>

<meta charset="UTF-8">

<title>New Password</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/reset.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Create New Password</h1>

    <form action="updatepassword"
          method="post">

        <label>New Password</label>

        <input type="password"
               name="password"
               required>

        <label>Confirm Password</label>

        <input type="password"
               name="confirmPassword"
               required>

        <input type="submit"
               value="Update Password">

    </form>

    <p class="error">${error}</p>

</div>

</body>

</html>