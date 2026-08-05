
package com.jsp.ojpms.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ojpms.dao.UserDao;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.EmailUtil;

@WebServlet("/reset")
public class ForgetPasswordController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		User user = UserDao.getUserByEmail(email);

		if (user == null) {
			req.setAttribute("error", "No account found with this email");

			req.getRequestDispatcher("reset.jsp").forward(req, resp);

			return;
		}

		int otp = 100000 + new Random().nextInt(900000);

		HttpSession session = req.getSession();

		session.setAttribute("otp", otp);
		session.setAttribute("email", email);
		session.setAttribute("otpPurpose", "FORGOT_PASSWORD");

		EmailUtil.sendEmail(email, "SmartHire Password Reset OTP", "Your OTP is : " + otp);

		resp.sendRedirect("verify_otp.jsp");
	}
}
