package com.example.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.ssl.DbKeyStoreSocketFactory.DbKeyStoreSocketException;

public class MyJDBC {

	public static void main(String[] args) throws IOException {
		FileReader file=new FileReader("src/main/resources/db.properties");
		Properties props=new Properties();
		props.load(file);
		String url=props.getProperty("url");
		String user=props.getProperty("user");
		String pass=props.getProperty("password");
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			int id=100;
			con=DriverManager.getConnection(url,user,pass);
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery("select * from actor where actor_id>"+id);
			
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
