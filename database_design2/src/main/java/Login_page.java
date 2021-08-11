import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_page {  
public static boolean login(String username,String password) {
	boolean status=false;  
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	try {
		String url1 = "jdbc:mysql://secs.oakland.edu:3306/arteche";
		conn1 = DriverManager.getConnection(url1, "arteche", "Koda2244");
		System.out.println("Enter Username:"+username);
		System.out.println("Enter password:"+password);
	
		
		if(conn1 != null) {
			System.out.println("connected to database arteche");
			status =true;
			stmnt = conn1.createStatement();
		}
	}
	catch (SQLException ex) {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;
		
	}
}