package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.entity.User;

@WebServlet("/userdashboard")
public class UserDashboardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		User user = (User) session.getAttribute("user");

		int appliedJobs = ApplicationDao.getApplicationCountByUser(user.getId());

		System.out.println("Applied Jobs = " + appliedJobs);

		req.setAttribute("appliedJobs", appliedJobs);

		req.getRequestDispatcher("user_dashboard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		User user = (User) session.getAttribute("user");

		int appliedJobs = ApplicationDao.getApplicationCountByUser(user.getId());

		System.out.println("Applied Jobs = " + appliedJobs);

		req.setAttribute("appliedJobs", appliedJobs);

		req.getRequestDispatcher("user_dashboard.jsp").forward(req, resp);
	}
}