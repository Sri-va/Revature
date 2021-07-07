package com.revature.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDBUtils implements EmployeeDB {

	Connection conn;
	public EmployeeDBUtils() {
		String url="jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee";
		try {
			Class.forName("org.postgresql.Driver");
			this.conn=DriverManager.getConnection(url,"postgres","Srivatsan123");
			System.out.println("Connected to Employee DB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String checkLogin(String user, String password) {
		
		String query="select name,password from employee where name= ? and password=? ";
		try {
			PreparedStatement preps=this.conn.prepareStatement(query);
			preps.setString(1, user);
			preps.setString(2, password);
			ResultSet res=preps.executeQuery();
			while(res.next()) {
				if(user.equals(res.getString("name")) && password.equals(res.getString("password")))
						return "Login successfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Incorrect credentials";
	}
	
	
}
