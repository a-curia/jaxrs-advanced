package com.dbbyte.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dbbyte.messenger.model.Message;

public class RestApiClient {

	private final static String BASE_TARGET_URL = "http://localhost:8080/jaxrs-advanced/api/";
	private final static String MESSAGES_PATH = "messages";
	
	public static void main(String[] args) {

		Client client = ClientBuilder.newClient(); // once per application
		
		WebTarget baseTarget = client.target(BASE_TARGET_URL);
		WebTarget messagesTarget = baseTarget.path(MESSAGES_PATH);
//		messagesTarget.path("1") // path parameter
		WebTarget singleMEssageTarget = messagesTarget.path("{messageIdVar}"); // generic message id
		
		Message message = singleMEssageTarget
				.resolveTemplate("messageIdVar", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message.getMessage());
				
		
		Message messageA = singleMEssageTarget
				.resolveTemplate("messageIdVar", "5")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(messageA.getMessage());
		
//		Message response = client.target(TARGET_URL).request(MediaType.APPLICATION_JSON).get(Message.class); // this is Fluent API
//		System.out.print(response.getMessage());
		
		
//		Response response = client.target(TARGET_URL).request(MediaType.APPLICATION_JSON).get(); // this is Fluent API
//		Message message = response.readEntity(Message.class); // unwrap message instance into response
//		System.out.print(message.getMessage());
		
		
		/*
		WebTarget target = client.target(TARGET_URL);
		Builder builder = target.request();
		Response response = builder.get();
		*/
		
		
		// Making a POST request
		Message postMessage = new Message(5,"aaaa","Adrian Curia");
		Response postResponse = messagesTarget.request().post(Entity.json(postMessage)); // this Entity.json(postMessage) converts Java instance  to JSON or XML...
		
		if (postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		Message createdMessage = postResponse.readEntity(Message.class);// unwrap the object and get the entity out of it; you don't have the respons estatus anymore
		
		System.out.println("Post Response = "+createdMessage.getMessage());
		
		// Making PUT/PATCH is the same
		
	}

}
