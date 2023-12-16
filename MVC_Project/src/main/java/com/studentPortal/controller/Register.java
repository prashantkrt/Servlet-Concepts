package com.studentPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentPortal.model.Model;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		

		if(password.equals(confirmPassword))
		{
			Model model = new Model(id,name,age,gender,userName,password);
			int row = model.register();
			if(row!=0)
			{
			 response.sendRedirect("/MVC_Project/registerSuccess.html");
			}
			else
			{
			 response.sendRedirect("/MVC_Project/failRegister.html");
			}			
		}
		else {
			System.out.println("Registration Failed due to password mismatch");
			response.sendRedirect("/MVC_Project/reregister.html");
		}
	}

}
