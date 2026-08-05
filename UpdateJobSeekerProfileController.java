package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;

@WebServlet("/updatejobseekerprofile")
public class UpdateJobSeekerProfileController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		JobSeekerProfile profile = JobSeekerProfileDao.getProfileById(id);

		profile.setId(id);

		profile.setHeadline(req.getParameter("headline"));

		profile.setAbout(req.getParameter("about"));

		profile.setMobileNumber(req.getParameter("mobileNumber"));

		profile.setSkills(req.getParameter("skills"));

		profile.setEducation(req.getParameter("education"));

		profile.setCollege(req.getParameter("college"));

		profile.setGraduationYear(req.getParameter("graduationYear"));

		profile.setLocation(req.getParameter("location"));

		profile.setLinkedinUrl(req.getParameter("linkedinUrl"));

		profile.setGithubUrl(req.getParameter("githubUrl"));

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		String name = req.getParameter("name");

		/* Update User Table */
		user.setName(name);

		User dbUser = new User();

		dbUser.setId(user.getId());

		dbUser.setName(name);

		UserDao.updateProfile(dbUser);

		/* Keep Relation */
		profile.setUser(user);

		/* Update Professional Profile */
		JobSeekerProfileDao.updateProfile(profile);

		/* Update Session */
		session.setAttribute("user", user);

		session.setAttribute("success", "Professional profile updated successfully");

		resp.sendRedirect("profile?id=" + user.getId());
	}
}