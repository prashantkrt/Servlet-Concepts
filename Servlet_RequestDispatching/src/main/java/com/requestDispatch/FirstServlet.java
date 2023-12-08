package com.requestDispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Control in First Servlet");

		RequestDispatcher reqDispatch = request.getRequestDispatcher("/SecondServlet");
		reqDispatch.forward(request,response);
//		reqDispatch.include(request,response);		
		

//		ServletContext context= request.getServletContext();
//		RequestDispatcher reqDispatch=context.getRequestDispatcher("SecondServlet");
//		reqDispatch.forward(request,response);
		
		//method chaining
//		request.getServletContext().getRequestDispatcher("/SecondServlet").forward(request, response);
//		request.getRequestDispatcher("/SecondServlet").include(request, response);
		request.getServletContext().getRequestDispatcher("/SecondServlet").include(request, response);
		
		response.sendRedirect("/Servlet_RequestDispatching/response1.html");
		
		
	}

}
