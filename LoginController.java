package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.PasswordUtil;

@WebServlet(value = "/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		System.out.println("email : " + email);
		System.out.println("password : " + password);

		User user = UserDao.getUser(email);

		System.out.println(user);
	
		// DEBUGGING
		System.out.println("Entered Password : " + password);

		if (user != null) {
			System.out.println("Stored Hash : " + user.getPassword());

			boolean result = PasswordUtil.verifyPassword(password, user.getPassword());

			System.out.println("Password Match : " + result);
		} else {
			System.out.println("User not found");
		}

		// ORIGINAL LOGIN LOGIC
		if (user != null && PasswordUtil.verifyPassword(password, user.getPassword())) {
			HttpSession session = req.getSession(true);

			session.setAttribute("user", user);

			if (user.getRole().equals("JOB_SEEKER")) {
				resp.sendRedirect("userdashboard");
			} else if (user.getRole().equals("RECRUITER")) {
				resp.sendRedirect("recruiterdashboard");
			}
		} else {
			req.setAttribute("error", "Invalid Email or Password");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
}