

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PositionPageServlet
 */
@WebServlet("/PositionPageServlet")
public class PositionPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String Transaction_ID = request.getParameter("Transaction ID");
		String StockTicker = request.getParameter("Stock Ticker");
		String NumOfShares = request.getParameter("Number of Shares");
		System.out.println(Transaction_ID);
		System.out.println(StockTicker);
		System.out.println(NumOfShares);
		
		if(PositionPage.create(Transaction_ID, StockTicker, NumOfShares)) {
			System.out.println("connected to database");
		   	RequestDispatcher rd=request.getRequestDispatcher("PositionPage.html");  
		    rd.forward(request,response);
	}

}
}
