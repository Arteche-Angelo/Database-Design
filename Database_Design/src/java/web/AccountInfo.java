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
 * Servlet implementation class AccountInfo

 */
//author:angleo arteche
@WebServlet("/AccountInfo")
public class AccountInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                String url1 = "jdbc:mysql://localhost:3306/arteche";
                Class.forName("com.mysql.jdbc.Driver");
                conn1 = DriverManager.getConnection(url1 , "root", "Koda2244");
                if(conn1 != null) {
                    stmnt = conn1.createStatement();
                    sql="select Balance from  Account where AccountNumber='"+LoginSQL.AccountNumber+"';" ;
                    ResultSet rs = stmnt.executeQuery(sql);
                    while(rs.next()) {
                        LoginSQL.Balance = rs.getString("Balance");
                    }
                    out.println("<p>Account Number: "+LoginSQL.AccountNumber+"</p>");
                    out.println("<p>Username: "+LoginSQL.Username+"</p>");
                    out.println("<p>Balance: $"+LoginSQL.Balance+"</p>");
                    out.println("</html></body>");
                    
                }  
            } catch (ClassNotFoundException | SQLException ex) {
                
            }
        }
     		
}


