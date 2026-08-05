package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.JPAUtil;

@WebServlet(value = "/profile")
public class ProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stringId = req.getParameter("id");
		System.out.println("StringId : " + stringId);

		int id = Integer.parseInt(stringId);

		EntityManager em = JPAUtil.getEm();
		User user = em.find(User.class, id);

		JobSeekerProfile profile = JobSeekerProfileDao.getProfileByUserId(id);

		int completedFields = 0;

		if (profile.getHeadline() != null && !profile.getHeadline().trim().isEmpty())
			completedFields++;

		if (profile.getAbout() != null && !profile.getAbout().trim().isEmpty())
			completedFields++;

		if (profile.getMobileNumber() != null && !profile.getMobileNumber().trim().isEmpty())
			completedFields++;

		if (profile.getSkills() != null && !profile.getSkills().trim().isEmpty())
			completedFields++;

		if (profile.getEducation() != null && !profile.getEducation().trim().isEmpty())
			completedFields++;

		if (profile.getCollege() != null && !profile.getCollege().trim().isEmpty())
			completedFields++;

		if (profile.getLocation() != null && !profile.getLocation().trim().isEmpty())
			completedFields++;

		if (profile.getLinkedinUrl() != null && !profile.getLinkedinUrl().trim().isEmpty())
			completedFields++;

		if (profile.getGithubUrl() != null && !profile.getGithubUrl().trim().isEmpty())
			completedFields++;

		if (profile.getResumePath() != null && !profile.getResumePath().trim().isEmpty())
			completedFields++;

		int completionPercentage = completedFields * 10;
		String viewOnly = req.getParameter("viewOnly");

		req.setAttribute("user", user);
		req.setAttribute("profile", profile);
		req.setAttribute("viewOnly", viewOnly);
		req.setAttribute("completionPercentage", completionPercentage);

		if (user.getRole().equals("JOB_SEEKER")) {
			req.getRequestDispatcher("jobseeker_profile.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		}
	}
}
