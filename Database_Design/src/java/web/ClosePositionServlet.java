package web;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClosePositionServlet
 */
@WebServlet("/ClosePositionServlet")
public class ClosePositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
		response.setContentType("text/html");
		String Transaction_ID=request.getParameter("Transaction_ID");
		System.out.println(Transaction_ID);		
	}
}
