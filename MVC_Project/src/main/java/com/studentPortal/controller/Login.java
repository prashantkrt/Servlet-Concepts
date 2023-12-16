package com.studentPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentPortal.model.Model;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Model model = new Model();
		model.setUserName(userName);
		model.setPassword(password);

		int row = model.login();
		System.out.println(row);

		String dbUser = model.getUserName();
		String dbPassword = model.getPassword();

		if (row!=0 && (userName .length()!=0 && password.length()!=0) && (dbPassword.length()!=0 && dbUser.length()!=0) && 
				(dbUser.equals(userName) && dbPassword.equals(password))) {
			response.sendRedirect("/MVC_Project/loginSuccess.jsp");
		} else {
			response.sendRedirect("/MVC_Project/loginFail.jsp");
		}
	}
}
