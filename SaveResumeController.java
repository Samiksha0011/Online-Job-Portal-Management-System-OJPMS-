package com.jsp.ojpms.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;

@WebServlet("/saveresume")
@MultipartConfig
public class SaveResumeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		Part resumePart = req.getPart("resume");

		String fileName = "resume_" + user.getId() + ".pdf";

		String uploadPath = "E:\\Uploads\\Resumes";
		
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		resumePart.write(uploadPath + File.separator + fileName);

		String dbPath = "E:/Uploads/Resumes/" + fileName;

		JobSeekerProfile profile = JobSeekerProfileDao.getProfileByUserId(user.getId());

		profile.setResumePath(dbPath);

		JobSeekerProfileDao.updateProfile(profile);

		session.setAttribute("success", "Resume uploaded successfully");

		resp.sendRedirect("profile?id=" + user.getId());
	}
}