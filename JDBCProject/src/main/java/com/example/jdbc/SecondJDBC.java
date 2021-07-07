package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecondJDBC {

	public static void main(String[] args) {
		String url="jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/DVD_Rental";
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			int id=100;
			String name="A%";
			con=DriverManager.getConnection(url,"postgres","Srivatsan123");
			String query="select * from actor where actor_id>? and first_name like ?";
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, name);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString("first_name")+" "+rs.getString(3));
			}
			
			statement.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
