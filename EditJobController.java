package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.entity.Job;

@WebServlet("/editjob")
public class EditJobController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String id = req.getParameter("id");

		Job job = JobDao.getJobById(Integer.parseInt(id));

		req.setAttribute("job", job);

		req.getRequestDispatcher( "edit_job.jsp").forward(req, resp);
	}
}