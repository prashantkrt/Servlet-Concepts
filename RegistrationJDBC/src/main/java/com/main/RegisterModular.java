package com.main;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jdbc.util.JDBCApp;

@WebServlet("/Register")
public class RegisterModular extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");

//		PrintWriter writer = response.getWriter();
		JDBCApp app = new JDBCApp();
		app.setId(id);
		app.setAge(age);
		app.setName(name);
		app.setGender(gender);

//		app.jdbcRegister();
//
//		if (app.getRow() != 0) {
//			writer.println("Registration successfull");
//			writer.println(app.getId());
//			writer.println(app.getName());
//			writer.println(app.getAge());
//			writer.println(app.getGender());
//		} else {
//			writer.println("Registration Failed");
//		}

		int row = app.jdbcRegister();
		if (row != 0) {
			response.sendRedirect("/RegistrationJDBC/success.html");
		} else {
			response.sendRedirect("/RegistrationJDBC/fail.html");

		}

	}

}
