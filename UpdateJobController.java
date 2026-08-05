package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.entity.Job;

@WebServlet("/updatejob")
public class UpdateJobController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Job job = JobDao.getJobById(id);

		job.setTitle(req.getParameter("title"));

		job.setDescription(req.getParameter("description"));

		job.setLocation(req.getParameter("location"));

		job.setSalary(Double.parseDouble(req.getParameter("salary")));

		JobDao.updateJob(job);

		resp.sendRedirect("managejobs");
	}
}