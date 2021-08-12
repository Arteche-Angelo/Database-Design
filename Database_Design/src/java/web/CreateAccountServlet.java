package web;



import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	         {
		response.setContentType("text/html");
		String Username =request.getParameter("Username");
		String Password = request.getParameter("psw");
		String PasswordRepeat= request.getParameter("psw-repeat");
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(PasswordRepeat);
		
		if(Password.equals(PasswordRepeat)) {
                    
                        if(CreateAccountSQL.create(Username, Password, PasswordRepeat)) {
                            System.out.println("connected to database");
                            RequestDispatcher rd=request.getRequestDispatcher("Login_page.html");
                            rd.forward(request,response);
                            JOptionPane.showMessageDialog(null, "Account created you can now log in");
                            
                        }
                    }else{

	         JOptionPane.showMessageDialog(null, "passwords do not match");
		}
		
		
	}

}
