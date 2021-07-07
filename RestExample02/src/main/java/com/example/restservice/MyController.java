package com.example.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.restservice.CorsFilter;

@Path("mycontroller")
public class MyController {

	@GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
        return "Hello From Controller";
	}
	
	@POST
	@Path("/forms")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String PostForm(@FormParam("username") String name,@FormParam("password") String password) {
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
					,"postgres","Srivatsan123");
			PreparedStatement preps=conn.prepareStatement("INSERT INTO EMPLOYEE(id,name,password) VALUES(6,?,?)");
			preps.setString(1, name);
			preps.setString(2,password);
			int row=preps.executeUpdate();
			System.out.println("Row :"+row);
			if(row==0)
				return "Not Executed";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Executed";
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String UpdateForm(@FormParam("username") String name,@FormParam("password") String password, @FormParam("id") int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
					,"postgres","Srivatsan123");
			PreparedStatement preps=conn.prepareStatement("UPDATE employee SET name= ?, password= ? WHERE id = ?");
			preps.setString(1, name);
			preps.setString(2,password);
			preps.setInt(3, id);
			int row=preps.executeUpdate();
			System.out.println("Row :"+row);
			if(row==0)
				return "Not Executed";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Executed";
	}
	


	@GET
    @Path("/getform")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloParam(@QueryParam("id") int num) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
					,"postgres","Srivatsan123");
			PreparedStatement preps=conn.prepareStatement("SELECT name FROM employee WHERE id="+num);
			ResultSet res=preps.executeQuery();
			boolean flag=false;
			while(res.next()) {
				String name=res.getString("name");
				ObjectMapper map=new ObjectMapper();
				return map.writeValueAsString(name);
			}
			if(!flag)
				System.out.println("No");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Executed";
    }
	
	@GET
    @Path("/deleteform")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteform(@QueryParam("id") int num) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
					,"postgres","Srivatsan123");
			PreparedStatement preps=conn.prepareStatement("DELETE FROM employee WHERE id="+num);
			int row=preps.executeUpdate();
			if(row==0)
				return "No";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Executed";
    }
	
	@GET
    @Path("/json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetJson(@PathParam("id") int num) {
		
		ObjectMapper mapper;
		String value=null;
        try {
        	Class.forName("org.postgresql.Driver");
    		Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/DVD_Rental"
    				,"postgres","Srivatsan123");
    		PreparedStatement preps=conn.prepareStatement("SELECT * FROM actor WHERE actor_id="+num);
    		ResultSet res=preps.executeQuery();
    		boolean flag=false;
    		while(res.next()) {
    			String firstname=res.getString("first_name");
    			String lastname=res.getString("last_name");
    			MyClass my = new MyClass(firstname,lastname);
    			mapper=new ObjectMapper();
    			value = mapper.writeValueAsString(my);
    			flag=true;
    		}
    		if(!flag)
    			System.out.println("No");
    		
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        }
        return value;
    }
}

