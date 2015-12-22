package com.wjb.testjackson;

//import java.awt.List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ListToJson {	
	private static ObjectMapper objectMapper = new ObjectMapper();		
	private static JsonGenerator jsonGenerator = null;
	private static List<Tests> list = new ArrayList<Tests>();
	private static Tests t1 = null;
	private static Tests t2 = null;
	
	public static void main(String[] args) {			
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		t1 = new Tests();		
		t1.setName("wjb");
		t1.setAddress("beijing");
		
		t2 = new Tests();
		t2.setName("www");
		t2.setAddress("xi'an");
		
		list.add(t1);
		list.add(t2);
						
		System.out.println("jsonGenerator");
        //list转换成JSON字符串
        try {
			jsonGenerator.writeObject(list);
	        System.out.println();
	        System.out.println("ObjectMapper");
	        //用objectMapper直接返回list转换成的JSON字符串
	        System.out.println("1###" + objectMapper.writeValueAsString(list));
	        System.out.print("2###");
	        //objectMapper list转换成JSON字符串
	        objectMapper.writeValue(System.out, list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
