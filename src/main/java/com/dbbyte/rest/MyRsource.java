package com.dbbyte.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

@Path("test")
@Singleton
public class MyRsource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		
		count = count + 1;
		
		return "Hello Test - "+count;
	}

}
