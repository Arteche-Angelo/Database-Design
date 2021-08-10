import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PositionPage {  
public static boolean create(int Transaction_ID, String StockTicker, int NumOfShares ) {

boolean status = false;
String sql = null;
Statement stmnt = null;
Connection conn1 = null;
try {
	String url1 = "jdbc:mysql://secs.oakland.edu:3306/arteche";
	conn1 = DriverManager.getConnection(url1, "arteche", "Koda2244");
	System.out.println("Transaction ID:"+ Transaction_ID);
	System.out.println("Stock Ticker:" + StockTicker);
	System.out.println("Number of Shares:"+ NumOfShares);
	
	if (conn1 !=null) {
		System.out.println("connected to database arteche");
		status =true;
		stmnt = conn1.createStatement();
		sql="Position info (Transaction_ID, Stock Ticker, NumOfShares, CostPerShare) values (" +"'" + Transaction_ID +"', '"+StockTicker+"', '"+ NumOfShares+"' "+ "0" + "');" ; 
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
