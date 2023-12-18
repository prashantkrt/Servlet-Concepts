
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet is loaded");
	}

	public FirstServlet() {
		super();
		System.out.println("Servlet is instantialted");
	}

	// init and destroy are the part of the servlet lifecycle
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init is initialized or invoked");
	}

	public void destroy() {
		System.out.println("At the end to close the app");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Method to handle the request and response");

		PrintWriter writer = response.getWriter();
		writer.println("My Application");
	}

}
