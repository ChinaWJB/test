package com.wjb.testlog4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Testlog4j {
	private static Logger logger = Logger.getLogger(Testlog4j.class);
	public static void main(String[] args) {
//		BasicConfigurator.configure();
//		PropertyConfigurator.configure("src/log4j2.properties");
//		PropertyConfigurator.configure("src/log4j.xml");
		logger.debug("this is debug message!!!");
		logger.info("this is info message!!");
		logger.error("this is error message!");
	}
}
