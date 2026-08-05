package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.entity.User;

@WebServlet("/recruiterdashboard")
public class RecruiterDashboardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		User recruiter = (User) session.getAttribute("user");

		int jobCount = JobDao.getJobCountByRecruiter(recruiter.getId());

		int applicationCount = ApplicationDao.getApplicationCountForRecruiter(recruiter.getId());

		System.out.println("Jobs Posted = " + jobCount);
		System.out.println("Applications = " + applicationCount);

		req.setAttribute("jobCount", jobCount);
		req.setAttribute("applicationCount", applicationCount);

		req.getRequestDispatcher("recruiter_dashboard.jsp").forward(req, resp);
	}
}