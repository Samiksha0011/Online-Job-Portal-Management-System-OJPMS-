package com.jsp.ojpms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.dao.JobSeekerProfileDao;
import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.EmailUtil;
import com.jsp.ojpms.util.JPAUtil;

@WebServlet(value = "/applyjob")
public class ApplyJobController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String stringId = req.getParameter("jobId");
		System.out.println("JobId : " + stringId);

		int id = Integer.parseInt(stringId);

		// 🔐 LOGIN CHECK (IMPORTANT ADDITION)
		HttpSession session = req.getSession(false);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		EntityManager em = JPAUtil.getEm();
		Job job = em.find(Job.class, id);

		System.out.println("Logged User Id : " + user.getId());
		JobSeekerProfile profile = JobSeekerProfileDao.getProfileByUserId(user.getId());

		System.out.println("Profile = " + profile);

		if (profile != null) {
			System.out.println("Resume Path = " + profile.getResumePath());
		}

		if (profile == null || profile.getResumePath() == null || profile.getResumePath().isEmpty()) {

			req.setAttribute("resumeerror", "Please upload your resume before applying.");

			List<Job> list = JobDao.getAllJobs();

			req.setAttribute("jobs", list);

			req.getRequestDispatcher("viewjob.jsp").forward(req, resp);

			return;
		}

		Application application = new Application();
		application.setJob(job);
		application.setUser(user);
		application.setAppliedDate(LocalDate.now());
		application.setResumePath(profile.getResumePath());

		if (ApplicationDao.isAlreadyApplied(user.getId(), id)) {

			req.setAttribute("appliedId", id);
			req.setAttribute("error", "Already Applied for " + job.getTitle());

			List<Job> list = JobDao.getAllJobs();
			req.setAttribute("jobs", list);

			req.getRequestDispatcher("viewjob.jsp").forward(req, resp);

		} else {

			ApplicationDao.saveApplication(application);

			String subject = "Application for " + job.getTitle();

			String message = "Hello " + user.getName() + ", \n\n" + "You have successfully applied for the job: "
					+ job.getTitle() + " Location: " + job.getLocation() + "\n\n" + "We will notify you soon\n\n"
					+ "Best Regards,\n" + "SmartHire Team";

			EmailUtil.sendEmail(user.getEmail(), subject, message);

			// Recruiter Mail
			User recruiter = job.getRecuriter();

			String recruiterSubject = "New Application for " + job.getTitle();

			String recruiterMessage = "Hello, \n\n" + "A new candidate has applied.\n\n" + "Name: " + user.getName()
					+ "\n" + "Email: " + user.getEmail() + "\n\n" + "Please login to review...\n\n" + "Best Regards,\n"
					+ "SmartHire Team";

			EmailUtil.sendEmail(recruiter.getEmail(), recruiterSubject, recruiterMessage);

			req.setAttribute("success", "You have successfully applied for the job: " + job.getTitle());
			req.getRequestDispatcher("viewjob").forward(req, resp);
		}
	}
}