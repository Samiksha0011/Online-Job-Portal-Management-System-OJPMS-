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

@WebServlet("/updateemail")
public class UpdateEmailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		String newEmail = (String) session.getAttribute("newEmail");

		boolean result = UserDao.updateEmail(user.getId(), newEmail);

		if (result) {
			user.setEmail(newEmail);

			session.setAttribute("user", user);

			session.setAttribute("success", "Email updated successfully");

			session.removeAttribute("otp");
			session.removeAttribute("otpPurpose");
			session.removeAttribute("newEmail");

			resp.sendRedirect("profile.jsp");
		} else {
			session.setAttribute("error", "Unable to update email");

			resp.sendRedirect("profile.jsp");
		}
	}
}