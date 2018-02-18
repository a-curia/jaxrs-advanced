package com.dbbyte.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author adrian
 * Implementing Filters - Cross Cutting Concerns
 * 
 * 2 types of filters - ContainerRequestFilter -> Resource -> ContainerResponseFilter
 * in this case i want the Response to be changed
 */

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		
		// will be called when the response would be sent
		// you can add header values here

		responseContext.getHeaders().add("keyPoweredBy", "My New Brand");
	}

}
