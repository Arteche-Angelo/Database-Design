package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class WatchlistPage {  
public static boolean create(String Watchlist_Name,String Ticker1, String Ticker2, String Ticker3, String Ticker4, String Ticker5) {

boolean status = false;
String sql = null;
Statement stmnt = null;
Statement stmnt2 = null;
Statement stmnt3 = null;
Statement stmnt4 = null;
Statement stmnt5 = null;
Connection conn1 = null;
try {
        Class.forName("com.mysql.jdbc.Driver");
	String url1 = "jdbc:mysql://localhost:3306/arteche";
	conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
	System.out.println("Watchlist Name:"+ Watchlist_Name);
	
	if (conn1 !=null) {
		System.out.println("connected to database arteche");
		status =true;
		stmnt = conn1.createStatement();
                stmnt2 = conn1.createStatement();
                stmnt3 = conn1.createStatement();
                stmnt4 = conn1.createStatement();
                stmnt5 = conn1.createStatement();
		sql="insert into watchlist(AccountNumber,WatchlistName, StockTicker) values (" +"'"+ LoginSQL.AccountNumber +"','" + Watchlist_Name +"', '"+Ticker1+"');" ; 
		stmnt.execute(sql);
                sql="insert into watchlist(AccountNumber,WatchlistName, StockTicker) values (" +"'" + LoginSQL.AccountNumber +"','"+ Watchlist_Name +"', '"+Ticker2+"');" ; 
		stmnt2.execute(sql);
                sql="insert into watchlist(AccountNumber,WatchlistName, StockTicker) values (" +"'" + LoginSQL.AccountNumber +"','"+ Watchlist_Name +"', '"+Ticker3+"');" ; 
		stmnt3.execute(sql);
                sql="insert into watchlist(AccountNumber,WatchlistName, StockTicker) values (" +"'"+ LoginSQL.AccountNumber +"','" + Watchlist_Name +"', '"+Ticker4+"');" ; 
		stmnt4.execute(sql);
                sql="insert into watchlist(AccountNumber,WatchlistName, StockTicker) values ("+"'" + LoginSQL.AccountNumber +"','" + Watchlist_Name +"', '"+Ticker5+"');" ; 
		stmnt5.execute(sql);
	}
	
}
catch (SQLException ex)
	 {
		System.out.println("An error occurred. ");
		
		} catch (ClassNotFoundException ex) {
        
    }
	  
		return status;
}
}
