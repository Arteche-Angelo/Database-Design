package web;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String n = request.getParameter("uname");
	    String p=request.getParameter("psw");  
	        
	    
	    if(LoginSQL.validate(n, p)){
	    	System.out.println("succsefully logged in");
	    	  RequestDispatcher rd=request.getRequestDispatcher("Account_page.html");
                            rd.forward(request,response);
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("Login_page.html");  
	        rd.include(request,response);  
	    } 
	          
	    }

}
