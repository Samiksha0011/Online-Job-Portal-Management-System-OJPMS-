package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.entity.JobSeekerProfile;

@WebServlet("/editjobseekerprofile")
public class EditJobSeekerProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");

		JobSeekerProfile profile = JobSeekerProfileDao.getProfileByUserId(Integer.parseInt(userId));

		req.setAttribute("profile", profile);

		req.getRequestDispatcher("edit_jobseeker_profile.jsp").forward(req, resp);
	}

}
