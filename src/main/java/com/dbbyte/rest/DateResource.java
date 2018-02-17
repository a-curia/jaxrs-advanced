package com.dbbyte.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dbbyte.rest.model.MyDate;

/**
 * 
 * @author adrian
 *
 *         date/today 
 *         date/tommorrow 
 *         date/yesterday
 */

@Path("date/{dateString}")
public class DateResource {
	
	/**
	 * 
	 * ParamConverter - has methods to convert from your String to your Custom data type: T fromString(String value)
	 * ParamConverterProvider - tells Jersey to use this ParamConverter given the type; ParamConverter getConverter(Class rawType,...)
	 * 
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") MyDate param) {

		return "Got - " + param.toString();
	}

}
