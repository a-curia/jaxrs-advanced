package com.dbbyte.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dbbyte.messenger.model.Message;

public class RestApiClient {

	private final static String TARGET_URL = "http://localhost:8080/jaxrs-advanced/api/messages/1";
	
	public static void main(String[] args) {

		Client client = ClientBuilder.newClient(); // oance per application
		
//		Response response = client.target(TARGET_URL).request(MediaType.APPLICATION_JSON).get(); // this is Fluent API
//		Message message = response.readEntity(Message.class); // unwrap message instance into response
//		System.out.print(message.getMessage());
		
		Message response = client.target(TARGET_URL).request(MediaType.APPLICATION_JSON).get(Message.class); // this is Fluent API
		System.out.print(response.getMessage());
		
		/*
		WebTarget target = client.target(TARGET_URL);
		Builder builder = target.request();
		Response response = builder.get();
		*/
	}

}
