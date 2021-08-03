import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountSQL {  
public static boolean create(String username,String password,String passwordrepeat){
	boolean status=false;  
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	try {
		String url1 = "jdbc:mysql://secs.oakland.edu:3306/arteche";
		conn1 = DriverManager.getConnection(url1, "arteche", "Koda2244");
		System.out.println("Username:"+username);
		System.out.println("password:"+password);
		System.out.println("Password repeated:" +passwordrepeat);
		
		if(conn1 != null) {
			System.out.println("connected to database arteche");
			status =true;
			stmnt = conn1.createStatement();
			sql="Insert into Account ( Username, Password, balance) values (" +"'" + username +"', '"+password+"', '"+ "0" + "');" ; 
			stmnt.execute(sql);
			
			
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;
		
	}
}