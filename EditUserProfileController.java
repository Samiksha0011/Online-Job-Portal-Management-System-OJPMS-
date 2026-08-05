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

@WebServlet(value = "/edituserprofile")
public class EditUserProfileController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String stringId = req.getParameter("id");
		String name = req.getParameter("name");

		int id = Integer.parseInt(stringId);

		System.out.println(id);
		System.out.println(name);

		User user = new User();

		// IMPORTANT
		user.setId(id);

		user.setName(name);

		UserDao.updateProfile(user);

		// Update session user
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("user");

		if (sessionUser != null) {
			sessionUser.setName(name);

			session.setAttribute("user", sessionUser);

			if (sessionUser.getRole().equals("JOB_SEEKER")) {
				
				session.setAttribute("success", "Profile updated successfully");
				resp.sendRedirect("userdashboard");

			} else if (sessionUser.getRole().equals("RECRUITER")) {

				session.setAttribute("success", "Profile updated successfully");
				resp.sendRedirect("recruiterdashboard");
			}
		}
	}
}