package com.dbbyte.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * MessageBody Writer/Reader
 * 
 * I want to return a Date type
 * 2018-02-17T16:09:50.079+0200|Severe: MessageBodyWriter not found for media type=text/plain, type=class java.util.Date, genericType=class java.util.Date.
 * 
 * You are asking Jersey to convert from plain text to Date.. but Jersey does not know to do that
 * 
 */

@Path("dtest")
public class MyRsourceThree {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date testReturnDate() {
		return Calendar.getInstance().getTime();
	}

}
