package one;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlconnect {
	
	

	public static Connection connect()  throws SQLException,Exception{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/web";
	String user="sa";
	String password="000";
	
		Class.forName(driver);
		System.out.println("Sussce driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println("login");
	
		
		return conn;
	
	}
	
}
