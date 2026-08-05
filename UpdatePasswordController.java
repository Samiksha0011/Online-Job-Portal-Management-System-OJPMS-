package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.PasswordUtil;

@WebServlet("/updatepassword")
public class UpdatePasswordController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password = req.getParameter("password");

		String confirmPassword = req.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {
			req.setAttribute("error", "Passwords do not match");

			req.getRequestDispatcher("new_password.jsp").forward(req, resp);

			return;
		}

		HttpSession session = req.getSession();

		String email = (String) session.getAttribute("email");

		String hashedPassword = PasswordUtil.hashPassword(password);

		UserDao.updatePassword(email, hashedPassword);

		session.removeAttribute("otp");
		session.removeAttribute("email");

		User user = (User) session.getAttribute("user");

		if (user != null) {
			session.setAttribute("success", "Password updated successfully");

			if (user.getRole().equals("JOB_SEEKER")) {
				resp.sendRedirect("userdashboard");
			} else {
				resp.sendRedirect("recruiterdashboard");
			}
		} else {
			req.setAttribute("success", "Password updated successfully. Please login.");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}