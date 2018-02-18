package com.dbbyte.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * INVOCATIONS
 * 
 * prepare the request and put all the things you need to do; the ideea is to
 * create the request object which contains all the infos about request other
 * objects can issue that request object, without knowing what is the request
 * this is the object called Invocation
 */

public class InvocationDemo {

	public static void main(String[] args) {

		// API to get all messages for year: /api/messages?year={year}

		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForMessagesByYear(2015);
		Response response = invocation.invoke(); // this is what is doing the HTTP request
		
		System.out.println(response.getStatus());
		
		// i do not want to have the logic for preparing this request residing in the
		// main method; i want to off-load that responsibility
		// i want control of when the request gets executed, but not on how/request
		// details

	}

	private Invocation prepareRequestForMessagesByYear(int year) {
		
		// i do not want to do get() here, i just want to prepare the request in ready status
		
		Client client = ClientBuilder.newClient();

		Invocation target = client
				.target("http://localhost:8080/jaxrs-advanced/api/")
				.path("messages")
				.queryParam("year", year)
				.request(MediaType.APPLICATION_JSON)
				.buildGet();
		
		return target;
	}

}
