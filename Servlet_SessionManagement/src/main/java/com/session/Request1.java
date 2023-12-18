package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Request1")
public class Request1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		if(session.isNew())
		{
			writer.println("New session with ID :"+session.getId());
		}
		else {
			writer.println("<h2> existing session is being used with ID :"+session.getId()+"</h2>");
		}
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		System.out.println(id+" "+name+" "+age+" "+gender);
		
		session.setAttribute(id, id);
		session.setAttribute(name, name);
		session.setAttribute(age, age);
		session.setAttribute(gender, gender);
		
		//setting for 60s
		session.setMaxInactiveInterval(60);
		
		
//		request.getServletContext().getRequestDispatcher("/Request2").forward(request, response);
		request.getRequestDispatcher("/Request2").include(request, response);	
		
		writer.close();

	}

}
