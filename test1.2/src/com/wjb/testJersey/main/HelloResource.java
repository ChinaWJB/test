package com.wjb.testJersey.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("hello")
public class HelloResource {
	@GET
	public String sayHello(){
		return "Hello World!";
	}
	
	@GET
	@Path("{param}")
	public String sayHelloToUTF8(@PathParam("param")String username){
		return "Hello " + username;
	}
}
