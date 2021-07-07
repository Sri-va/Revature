package com.example.rest.RestExample;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("controller")
public class Controller {

	@GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
        return "Hello From Controller";
    }
	
	@GET
    @Path("/hello/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloParam(@PathParam("id") int num) {
        return "Hi From Controller " + num;
    }
	
	@GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetJson() {
        ObjectMapper mapper = new ObjectMapper();
        MyClass my = new MyClass();
        try {
            return mapper.writeValueAsString(my);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        }
    }
}

