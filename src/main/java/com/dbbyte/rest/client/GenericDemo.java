package com.dbbyte.rest.client;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.dbbyte.messenger.model.Message;

/**
 * Handling Generic Types
 */

public class GenericDemo {

	public static void main(String[] args) {

		
		Client client = ClientBuilder.newClient();

		List<Message> response = client
				.target("http://localhost:8080/jaxrs-advanced/api/")
				.path("messages")
				.queryParam("year", 2018)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>() {});
		
		System.out.println(response);
		

	}

}
