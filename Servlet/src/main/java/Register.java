

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public Register() {
       System.out.println("Register object is created");       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uName");
		String city= request.getParameter("uCity");
		String phoneNo= request.getParameter("uNumber");
		
		PrintWriter write = response.getWriter();
		
		write.println("<html><head><title> First App</title></head>");
		write.println("<body bgcolor='cyan'> <h1><marquee>Welcome to our dynamic app</marquee></h1></body>");		
		write.println("<table>");
		write.println("<tr><th>Name</th> <th>City</th> <th>Phone</th></tr>");
		write.println("<tr><td>"+name+"</td> <td>"+city+"</th> <td>"+phoneNo+"</td></tr>");		
		write.println("</table>");		
		write.println("</html>");
		write.close();	
		
	}

}
