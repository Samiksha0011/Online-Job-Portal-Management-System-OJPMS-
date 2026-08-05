package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.EmailUtil;

@WebServlet("/changeemail")
public class ChangeEmailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("change_mail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String newEmail = req.getParameter("newEmail");

		User existingUser = UserDao.getUserByEmail(newEmail);

		if (existingUser != null) {
			req.setAttribute("error", "This email is already registered");

			req.getRequestDispatcher("change_mail.jsp").forward(req, resp);

			return;
		}

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		int otp = 100000 + new Random().nextInt(900000);

		session.setAttribute("otp", otp);

		session.setAttribute("otpPurpose", "CHANGE_EMAIL");

		session.setAttribute("newEmail", newEmail);

		EmailUtil.sendEmail(user.getEmail(), "OJPMS Change Email OTP", "Your OTP is : " + otp);

		resp.sendRedirect("verify_otp.jsp");
	}
}