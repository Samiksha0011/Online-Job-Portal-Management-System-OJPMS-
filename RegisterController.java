package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.PasswordUtil;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");

		String hashedPassword = PasswordUtil.hashPassword(password);

		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("password: " + password);
		System.out.println("role: " + role);

		User user = new User(name, email, hashedPassword, role);

		User dbUser = UserDao.getUserByEmail(email);

		if (dbUser != null) {
			req.setAttribute("error", "An account with this email already exists. Please log in or use a different email.");

			req.getRequestDispatcher("register.jsp").forward(req, resp);

			return;
		}
		UserDao.save(user);

		if (role.equals("JOB_SEEKER")) {
			JobSeekerProfile profile = new JobSeekerProfile();

			profile.setUser(UserDao.getUserByEmail(email));

			JobSeekerProfileDao.saveProfile(profile);
		}
		resp.sendRedirect("home.jsp");
	}
}
