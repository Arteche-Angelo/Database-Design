package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginSQL {  
	public static String Username =null;
	public static String AccountNumber =null;
	public static String Balance =null;
public static boolean validate(String name,String pass){  

	boolean status=false;  
	String sql =null;
	Connection conn1 = null;
	Statement stmnt = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url1 = "jdbc:mysql://localhost:3306/arteche";
		System.out.println("name:" + name + "\n");
		System.out.println("pass:" + pass + "\n");
		conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
		if (conn1 != null) {
			System.out.println("Connected to the database spend");
			stmnt =conn1.createStatement();
			sql = "select * from account where Username='"+name+ "' and password ='"+pass+"';";
			ResultSet rs = stmnt.executeQuery(sql);
			if(rs != null) {
                            while(rs.next()){
				Username= rs.getString("Username");
                                System.out.println(Username);
                                        
				AccountNumber =rs.getString("AccountNumber");
                                System.out.println(AccountNumber);
				Balance= rs.getString("Balance");
                                System.out.println(Balance);
				status = true;
                            }
			}else {
				System.out.println("no account under that username or password");
			}
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. Maybe user/password is invalid");
		ex.printStackTrace();
	}   catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

	return status;  

	}  

}  