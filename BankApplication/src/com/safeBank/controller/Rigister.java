package com.safeBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.safeBank.model.*;
@WebServlet("/Register")
public class Rigister extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String custid= request.getParameter("custid");
		int accno = Integer.parseInt(request.getParameter("accno"));
		String pwd = request.getParameter("pwd");
		int bal = Integer.parseInt(request.getParameter("bal"));
		String email = request.getParameter("email");
		String snum =request.getParameter("num");
		long num = Long.parseLong(snum);
		try {
			Model m = new Model();
			m.setName(name);
			m.setCustid(custid);
			m.setAccno(accno);
			m.setPwd(pwd);
			m.setBal(bal);
			m.setEmail(email);
			m.setNum(num);
			
			boolean b = m.register();
			
			if(b==true) {
				response.sendRedirect("/BankApplication/SuccessReg.html");
			}
			else {
				response.sendRedirect("/BankApplication/FailureReg.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
