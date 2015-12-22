package com.wjb.testJersey.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class HelloTest {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:1111/myapp/").path("hello/ÄãºÃ");
//		Integer integer = target.request().post(Entity.entity(MediaType.APPLICATION_JSON_TYPE), Integer.TYPE);

		String s = target.request().get(String.class);
		System.out.println("@@@@@" + s);	
	}
}
