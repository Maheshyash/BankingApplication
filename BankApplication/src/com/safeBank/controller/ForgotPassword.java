package com.safeBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.safeBank.model.Model;
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saccno = request.getParameter("accno");
		System.out.println(saccno);
		int accno = Integer.parseInt(saccno);
		long num = Long.parseLong(request.getParameter("num"));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("num", num);
		session.setAttribute("accno", accno);
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setNum(num);
			boolean b = m.getOtp();
			
			if(b==true) {
				response.sendRedirect("/BankApplication/OtpCheck.html");
			}
			else {
				response.sendRedirect("/BankApplication/PasswordChangeFailed.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
