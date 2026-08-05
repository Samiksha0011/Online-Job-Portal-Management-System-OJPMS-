package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.entity.User;

@WebServlet("/viewapplicants")
public class ViewApplicantsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		User recruiter = (User) session.getAttribute("user");

		List<Application> applications = ApplicationDao.getAllApplications();

		req.setAttribute("applications", applications);

		req.setAttribute("recruiterId", recruiter.getId());

		req.getRequestDispatcher("view_applicants.jsp").forward(req, resp);
	}
}