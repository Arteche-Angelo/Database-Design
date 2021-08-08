import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WatchlistPage {  
public static boolean create(String Watchlist_ID, String Watchlist_Name) {

boolean status = false;
String sql = null;
Statement stmnt = null;
Connection conn1 = null;
try {
	String url1 = "jdbc:mysql://secs.oakland.edu:3306/arteche";
	conn1 = DriverManager.getConnection(url1, "arteche", "Koda2244");
	System.out.println("Watchlist ID:"+ Watchlist_ID);
	System.out.println("Watchlist Name:"+ Watchlist_Name);
	
	if (conn1 !=null) {
		System.out.println("connected to database arteche");
		status =true;
		stmnt = conn1.createStatement();
		sql="Watchlist info (Watchlist_ID, Watchlist_Name, Stock Ticker) values (" +"'" + Watchlist_ID +"', '"+Watchlist_Name+"', '"+ "0" + "');" ; 
		stmnt.execute(sql);
	}
	
}
catch (SQLException ex)
	 {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;
}
}
