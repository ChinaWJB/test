package com.wjb.testSystem;

//import java.util.Iterator;
//import java.util.Map;
//import java.util.Properties;
import java.util.*;
import java.io.*;

public class TestGetSysParams {
	
	
	public static void main(String[] args) {
//		getgenv();
		System.out.println("logService: " + System.getenv("logService"));
	}
	
	public static void getgenv(){
		Map<String, String> map = System.getenv();
		for (Iterator<String> itr = map.keySet().iterator(); itr.hasNext();){
			String key = itr.next();
			System.out.println(key + "=" + map.get(key));
		}
	}
	
	public static void getproperty(){
		Properties props = System.getProperties();
		props.list(System.out);
	}
	
//	public static void getEnv(){
//		Properties prop = new Properties();
//		String OS = System.getProperty("os.name").toLowerCase();
//		Process p = null;
//		if(OS.indexOf("windows")>-1){
//			p = Runtime().getRuntime().exec("cmd /c set");
//		}
//	}
	
	public static void getparams(){
		try {
			Process p = Runtime.getRuntime().exec("cmd.exe /c set");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
