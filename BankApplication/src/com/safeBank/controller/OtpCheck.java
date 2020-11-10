package com.safeBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safeBank.model.Model;
@WebServlet("/Otp")
public class OtpCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sotp = request.getParameter("otp");
		System.out.println("Entered otp"+sotp);
		int otp = Integer.parseInt(sotp);
		try {
			Model m = new Model();
			m.setOTP(otp);
			boolean b = m.checking();
			if(b==true) {
				response.sendRedirect("/BankApplication/ChangePwd.html");
			}
			else {
				response.sendRedirect("/BankingApplication/OtpFail.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
