package com.dbbyte.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author adrian
 * 
 * by default, every time you make this API request, JAX-RS is creating a new instance of this MyResource class
 * newer shares the same resource
 * they are Request scoped
 * 
 * we can change is with Singleton(instance created just once); will be destroyed at server restart
 */

@Path("{pathParam}/test")
//@Singleton // method variables will not work with this because we need to create new instance
public class MyRsourceTwo {
	
	private int count; 
	
	// member variables - use them is there are many methods that should be executed with same params
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethodTwo(/*@PathParam("pathParam") String pathParamExample,@QueryParam("query") String queryParamExample*/) {
		return "pathParam = "+pathParamExample+" and queryParam ="+ queryParamExample;
	}

}
