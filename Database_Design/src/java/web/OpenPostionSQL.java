package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenPostionSQL {  
public static boolean Open(String Ticker,String NumOfShares,String CostPerShare)  {
	boolean status=false;  
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	try {
		
		String url1 = "jdbc:mysql://localhost:3306/arteche";
		conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
		
		
		if(conn1 != null) {
			System.out.println("connected to database arteche");
			status =true;
			stmnt = conn1.createStatement();
			sql="Insert into Positions ( AccountNumber, StockTicker, NumOfShares, CostPerShare) values (" +"'" + LoginSQL.AccountNumber +"', '"+Ticker+"', '"+ NumOfShares + "', '"+CostPerShare+"');" ; 
			stmnt.execute(sql);
			
			
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;
		
	}
}