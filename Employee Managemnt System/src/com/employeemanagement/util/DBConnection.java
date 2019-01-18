package com.employeemanagement.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	public static Connection createConnection()
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/Employee Management System";
		String username="root";
		String password="12345";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		return con;
	}
}
