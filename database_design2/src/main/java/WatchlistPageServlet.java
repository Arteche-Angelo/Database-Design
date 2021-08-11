

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WatchlistPageServlet
 */
@WebServlet("/WatchlistPageServlet")
public class WatchlistPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String Watchlist_ID = request.getParameter("Watchlist ID");
		String Watchlist_Name = request.getParameter("Watchlist Name");
		String StockTicker = request.getParameter("Stock Ticker");
		System.out.println(Watchlist_ID);
		System.out.println(Watchlist_Name);
		System.out.println(StockTicker);
		
		if(WatchlistPage.create(Watchlist_ID, Watchlist_Name, StockTicker)) {
			System.out.println("connected to database");
		   	RequestDispatcher rd=request.getRequestDispatcher("WatchlistPage.html");  
		    rd.forward(request,response);
		    }
			
		
		
		
		
	}

}
