package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;

@WebServlet("/managejobs")
public class ManageJobsController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);

		if(session == null || session.getAttribute("user") == null)
		{
			resp.sendRedirect("login.jsp");
			return;
		}

		User recruiter = (User) session.getAttribute("user");

		List<Job> jobs = JobDao.getJobsByRecruiter(recruiter.getId());

		req.setAttribute("jobs", jobs);

		req.getRequestDispatcher("manage_jobs.jsp").forward(req, resp);
	}
}