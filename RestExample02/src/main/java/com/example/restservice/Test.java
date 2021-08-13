package com.example.restservice;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.example.restservice.CorsFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("test")
public class Test{

	
	
	@GET
	@Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
	public String getHello() {
		ObjectMapper obj=new ObjectMapper();
        try {
			return obj.writeValueAsString("Hello From Test");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "False";
	}
	
	@GET
	@Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
	public String getHi() {
        return "Hi From Test";
	}
}
