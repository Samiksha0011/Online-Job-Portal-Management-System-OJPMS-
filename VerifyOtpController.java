package com.jsp.ojpms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyotp")
public class VerifyOtpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String enteredOtp = req.getParameter("otp");

		HttpSession session = req.getSession();

		Integer generatedOtp = (Integer) session.getAttribute("otp");

		if (generatedOtp != null &&
			    Integer.parseInt(enteredOtp) == generatedOtp)
			{
			    String purpose =
			        (String) session.getAttribute("otpPurpose");

			    if("FORGOT_PASSWORD".equals(purpose))
			    {
			        resp.sendRedirect("new_password.jsp");
			    }
			    else if("CHANGE_PASSWORD".equals(purpose))
			    {
			        resp.sendRedirect("new_password.jsp");
			    }
			    else if("CHANGE_EMAIL".equals(purpose))
			    {
			        resp.sendRedirect("updateemail");
			    }
			}
			else {
				req.setAttribute("error", "Invalid OTP");

				req.getRequestDispatcher("verify_otp.jsp").forward(req, resp);
			}
	}
}