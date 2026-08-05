package com.jsp.ojpms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.entity.Application;

@WebServlet("/viewapplicantresume")
public class ViewApplicantResumeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int applicationId = Integer.parseInt(req.getParameter("applicationId"));

		Application application = ApplicationDao.getApplicationById(applicationId);

		if (application == null || application.getResumePath() == null) {

			resp.getWriter().println("Resume Not Found");

			return;
		}

		File file = new File(application.getResumePath());

		resp.setContentType("application/pdf");

		resp.setHeader("Content-Disposition", "inline; filename=" + file.getName());

		FileInputStream fis = new FileInputStream(file);

		byte[] data = new byte[(int) file.length()];

		fis.read(data);

		resp.getOutputStream().write(data);

		fis.close();
	}
}