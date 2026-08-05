<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>OJPMS - Reset Password</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/reset.css">
<link rel="stylesheet" href="assests/navbar.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Reset Password</h1>

    <p class="form-subtitle">
        Enter your registered email address and create a new password.
    </p>

    <form action="reset" method="post">

    <label>Email Address</label>

    <input type="email"
           name="email"
           placeholder="Enter your registered email"
           required>

    <input type="submit"
           value="Send OTP">

</form>

    <div class="form-links">

        <a href="login.jsp"
           class="btn">
            Back to Login
        </a>

        <a href="register.jsp"
           class="btn register-btn">
            Create New Account
        </a>

    </div>

    <p class="success">
        ${success}
    </p>

    <p class="error">
        ${error}
    </p>

    <div class="security-note">

        <h3>Security Notice</h3>

        <p>
            Never share your password with anyone.
            OJPMS support will never ask for your password.
        </p>

    </div>

</div>

</body>
</html>