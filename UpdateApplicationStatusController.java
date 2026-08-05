package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.util.EmailUtil;

@WebServlet("/updateapplicationstatus")
public class UpdateApplicationStatusController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int applicationId = Integer.parseInt(req.getParameter("applicationId"));

		String status = req.getParameter("status");

		Application application = ApplicationDao.getApplicationById(applicationId);

		if (application == null) {

			resp.sendRedirect("viewapplicants");

			return;
		}

		ApplicationDao.updateStatus(applicationId, status);

		// Email Notification

		String subject = "";

		String message = "";

		if (status.equals("SHORTLISTED")) {

			subject = "Application Shortlisted";

			message = "Hello " + application.getUser().getName() + ",\n\n"
			    + "Congratulations!\n\n"

			    + "We are pleased to inform you that your application for the position of "

			    + application.getJob().getTitle()

			    + " has been shortlisted.\n\n"

			    + "Our recruitment team was impressed with your profile and qualifications. The recruiter may contact you soon regarding the next steps in the hiring process.\n\n"

			    + "Thank you for choosing SmartHire.\n\n"

			    + "Best Regards,\n"
			    + "SmartHire Team";
		}

		else if (status.equals("REJECTED")) {

			subject = "Application Status Update";

			message = "Hello " + application.getUser().getName() + ",\n\n"

			    + "We would like to inform you that the recruiter for the position of "

			    + application.getJob().getTitle()

			    + " has reviewed your application and updated its status.\n\n"

			    + "Based on the recruiter's decision, your application has not been selected for the next stage of the hiring process.\n\n"

			    + "This update has been shared with you through the SmartHire platform on behalf of the recruiter.\n\n"

			    + "We appreciate the time and effort you invested in applying for this opportunity. We encourage you to continue exploring and applying for other positions available on SmartHire.\n\n"

			    + "We wish you success in your job search and future career endeavors.\n\n"

			    + "Best Regards,\n"
			    + "SmartHire Team";

		}

		EmailUtil.sendEmail(application.getUser().getEmail(), subject, message);

		HttpSession session = req.getSession();

		session.setAttribute("success", "Application status updated successfully");

		resp.sendRedirect("viewapplicants");
	}
}