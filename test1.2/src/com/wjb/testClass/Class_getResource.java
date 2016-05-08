package com.wjb.testClass;

import java.io.File;
import java.util.List;

public class Class_getResource {
	private static File file = null;
	private static Class_getResource cg;
	
	static{
		cg = new Class_getResource();
		file = new File(cg.getClass().getResource("/log4j.xml").getFile());
		System.out.println("log4j.xml path: " + file.getName());	
	}
	
	public static void main(String[] args) {
//		Class_getResource cg = new Class_getResource();//log4j.xml
//		file = new File(cg.getClass().getResource("/log4j.xml").getFile());
//		System.out.println("log4j.xml path: " + file.getName());
//		System.out.println("max" + Integer.MAX_VALUE);
//		System.out.println("min" + Integer.MIN_VALUE);
	}		
}
