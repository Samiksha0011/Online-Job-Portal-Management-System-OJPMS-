package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.entity.Job;

@WebServlet("/deletejob")
public class DeleteJobController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String stringId = req.getParameter("id");
		int id = Integer.parseInt(stringId);
//		Job job = JobDao.getJobById(Integer.parseInt(stringId));

		JobDao.removeJob(id);
		
		
		req.getRequestDispatcher("managejobs").forward(req, resp);
	}
}
