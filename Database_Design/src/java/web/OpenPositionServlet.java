package web;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class OpenPositionServlet
 */
@WebServlet("/OpenPositionServlet")
public class OpenPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
		response.setContentType("text/html");
		String Ticker =request.getParameter("StockTicker");
		String NumOfShares = request.getParameter("NumOfShares");
		String CostPerShare= request.getParameter("CostPerShare");
		System.out.println(Ticker);
		System.out.println(NumOfShares);
		System.out.println(CostPerShare);
		
		
		
		
		}
		
		
		
	}


