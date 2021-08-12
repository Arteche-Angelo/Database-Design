package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosePositionSQL {  
public static boolean Close(String Transaction_ID)  {
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
			sql="Select * from Positions where Transaction_ID ="+Transaction_ID+";" ; 
			ResultSet rs = stmnt.executeQuery(sql);
			System.out.println(rs);
			
			
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. ");
		
		}
	  
		return status;
		
	}
}