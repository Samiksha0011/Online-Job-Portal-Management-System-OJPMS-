<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ page isELIgnored="false"%>
<html>

<head>

<meta charset="UTF-8">

<title>Verify OTP</title>

<link rel="stylesheet" href="assests/base.css">
<link rel="stylesheet" href="assests/reset.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Verify OTP</h1>

    <p class="form-subtitle">

        Enter the OTP sent to your email.

    </p>

    <form action="verifyotp" method="post">

        <label>OTP</label>

        <input type="text"
               name="otp"
               placeholder="Enter OTP"
               required>

        <input type="submit"
               value="Verify OTP">

    </form>

    <p class="error">${error}</p>

</div>

</body>

</html>