package com.jsp.ojpms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.JobDao;
import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.EmailUtil;

@WebServlet(value = "/postjob")
public class PostJobController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String location = req.getParameter("location");
		String salary = req.getParameter("salary");

		System.out.println(title);
		System.out.println(description);
		System.out.println(location);
		System.out.println(salary);

		Job job = new Job();
		job.setTitle(title);
		job.setDescription(description);
		job.setLocation(location);
		job.setSalary(Double.parseDouble(salary));
		job.setPostedDate(LocalDate.now());
		HttpSession session = req.getSession();
		User recruiter = (User) session.getAttribute("user");
		job.setRecuriter(recruiter);

		JobDao.saveJob(job);

		new Thread(() -> {

			List<User> jobSeekers = UserDao.getAllJobSeekers();

			for (User u : jobSeekers) {

				String message = "Dear " + u.getName()

						+ ",\n\n"

						+ "A new job opportunity has been posted on OJPMS.\n\n"

						+ "Job Title : " + job.getTitle()

						+ "\nLocation : " + job.getLocation()

						+ "\nSalary : ₹" + job.getSalary()

						+ "\n\nLogin to OJPMS and apply now."

						+ "Best Regards,\n" + "SmartHire Team";

				try {
					EmailUtil.sendEmail(u.getEmail(), "New Job Opportunity Available", message);
				} catch (Exception e) {
					System.out.println("Failed for : " + u.getEmail());
				}
			}

		}).start();

		resp.sendRedirect("post_job.jsp");
	}

}
