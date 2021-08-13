package com.example.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

class Emp {
	private String name;
	private String password;
	
	public Emp() {}
	
	public Emp(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", password=" + password + "]";
	}
}

@Path("mycontroller")
public class MyController {

	

    @Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Test gethello() {
        return new Test();
	}
	
	@POST
	@Path("/forms")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String PostForm(String data) {
		try {
			
//			Class.forName("org.postgresql.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
//					,"postgres","Srivatsan123");
//			PreparedStatement preps=conn.prepareStatement("SELECT name FROM employee WHERE password=?");
//			preps.setString(1, password);
//			ResultSet rs=preps.executeQuery();
//			
			System.out.println("hello -> " + data);
			ObjectMapper obj=new ObjectMapper();
			Emp e=obj.readValue(data, Emp.class);
			System.out.println(e.getName());
//			System.out.println(rs.getFetchSize());
//			if(rs.getFetchSize()==0)
//			HttpServletResponse response = null;
//			response.sendRedirect("RestExample02/webapi/mycontroller/getform");
				return obj.writeValueAsString(e.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Incorrect";
		
	}
	
	@PUT
	@Path("/update/{id}")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String UpdateForm(@PathParam("id") int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://database-1.czhcku1df67r.us-east-2.rds.amazonaws.com/Employee"
					,"postgres","Srivatsan123");
			PreparedStatement preps=conn.prepareStatement("UPDATE employee SET name= ?, password= ? WHERE id = ?");
			preps.setString(1, "Test");
			preps.setString(2,"Update");
			preps.setInt(3, id);
			int row=preps.executeUpdate();
			System.out.println("Row :"+row);
			ObjectMapper obj=new ObjectMapper();
			if(row>0)
				return obj.writeValueAsString("Done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Not Executed";
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
		return "Executed get";
    }
	
	@DELETE
    @Path("/deleteform/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteform(@PathParam("id") int num) {
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

