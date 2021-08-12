/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angelo
 */
@WebServlet(name = "DisplayWatchlist", urlPatterns = {"/DisplayWatchlist"})
public class DisplayWatchlist extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String sql = null;
    Statement stmnt = null;
    Connection conn1 = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try {
              
            
            String url1 = "jdbc:mysql://localhost:3306/arteche";
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
            if (conn1 != null) {
                stmnt = conn1.createStatement();
                sql = "select WatchlistName,StockTicker from watchlist where AccountNumber= '" + LoginSQL.AccountNumber + "' ;";
                ResultSet rs = stmnt.executeQuery(sql);

                
                while (rs.next()) {
                    String WatchlistName = rs.getString("WatchlistName");
                out.println("<p>" + WatchlistName + "</p>");
                    String Ticker = rs.getString("StockTicker");
                    out.println("<p>" + Ticker + "</p>");

                }

                out.println("</html></body>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("error");
        }
    }

}
