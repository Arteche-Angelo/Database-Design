package web;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class CreateAccountSQL {  
public static boolean create(String username,String password,String passwordrepeat)  {
    
        boolean status=false;
        String sql= null;
        Statement stmnt = null;
        Connection conn1 = null;
       try { 
          
        String url1 = "jdbc:mysql://localhost:3306/arteche";
           System.out.println("before driver manager");
        Class.forName("com.mysql.jdbc.Driver");
        conn1 = DriverManager.getConnection(url1 , "root", "Koda2244");
           System.out.println("past drivermanager");
        System.out.println("Username:"+username);
        System.out.println("password:"+password);
        System.out.println("Password repeated:" +passwordrepeat);
        
        if(conn1 != null) {
            System.out.println("connected to database arteche");
            stmnt = conn1.createStatement();
            sql="Insert into account ( Username, Password, Balance) values (" +"'" + username +"', '"+password+"', '"+ "0" + "');" ;
            stmnt.execute(sql);
            status =true;
            
        }
        
        
    } catch (SQLException ex) {
           System.out.println("Errot");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CreateAccountSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
	return status;	
	}
}
