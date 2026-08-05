package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.ApplicationDao;
import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.entity.User;

@WebServlet("/myapplications")
public class MyApplicationsController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null)
	        {
	            resp.sendRedirect("login.jsp");
	            return;
	        }

	        User user = (User) session.getAttribute("user");

	        List<Application> applications = ApplicationDao.getApplicationsByUser(user.getId());

	        req.setAttribute("applications",applications);

	        req.getRequestDispatcher("my_applications.jsp").forward(req, resp);
	}
}
