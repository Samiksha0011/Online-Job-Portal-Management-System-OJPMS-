package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.EmailUtil;

@WebServlet("/changepassword")
public class ChangePasswordController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		int otp = 100000 + new Random().nextInt(900000);

		session.setAttribute("otp", otp);
		session.setAttribute("email", user.getEmail());
		session.setAttribute("otpPurpose", "CHANGE_PASSWORD");

		EmailUtil.sendEmail(user.getEmail(), "SmartHire Change Password OTP", "Your OTP is : " + otp);

		resp.sendRedirect("verify_otp.jsp");
	}
}