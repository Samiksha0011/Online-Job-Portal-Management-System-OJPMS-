package com.jsp.ojpms.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;

@WebServlet("/removeresume")
public class RemoveResumeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		JobSeekerProfile profile = JobSeekerProfileDao.getProfileByUserId(user.getId());

		if (profile != null && profile.getResumePath() != null) {

			File file = new File(profile.getResumePath());

			if (file.exists()) {

				boolean deleted = file.delete();
				System.out.println("Resume Deleted : "+deleted);
			}

			profile.setResumePath(null);

			JobSeekerProfileDao.updateProfile(profile);

			session.setAttribute("success", "Resume removed successfully");
		}

		resp.sendRedirect("profile?id=" + user.getId());
	}
}