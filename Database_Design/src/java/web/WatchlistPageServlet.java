/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author angelo
 */
@WebServlet(name = "WatchlistPageServlet", urlPatterns = {"/WatchlistPageServlet"})
public class WatchlistPageServlet extends HttpServlet {

    
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String Watchlist_Name = request.getParameter("Watchlist_Name");
		String StockTicker1 = request.getParameter("Ticker1");
                String StockTicker2 = request.getParameter("Ticker2");
                String StockTicker3 = request.getParameter("Ticker3");
                String StockTicker4 = request.getParameter("Ticker4");
                String StockTicker5 = request.getParameter("Ticker5");
		System.out.println(Watchlist_Name);
		if(WatchlistPage.create(Watchlist_Name, StockTicker1,StockTicker2,StockTicker3,StockTicker4,StockTicker5)) {
			System.out.println("connected to database");
		   	RequestDispatcher rd=request.getRequestDispatcher("Account_page.html");  
		    rd.forward(request,response);
		    }
			
		
		
		
		
	}

}
