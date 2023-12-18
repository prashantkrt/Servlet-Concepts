package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@WebServlet("/Request2")
public class Request2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);// want existing session not new session
		
		if(session!=null)
		{
			//Thread safe used with Vector
			Enumeration<String> en = session.getAttributeNames();
			while(en.hasMoreElements())
			{
				String nameInfo = en.nextElement();
				Object name = session.getAttribute(nameInfo);
				writer.println(name+" "+nameInfo);	
				
				long creationTime = session.getCreationTime();
				long lastAccessTime= session.getLastAccessedTime();
				
				writer.println("<h3>Creation Time </h3>"+new Date(creationTime)+"<h3>Last Access Time : </h3>"+new Date(lastAccessTime));	
			}			
			
		}
		else {
			
			writer.println("No session information available for this user");
			
		}
		
		writer.close();
		

	}

}
