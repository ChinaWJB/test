package com.wjb.testlog4j;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

public class ModifyProperties {
	
	public static String makeConfiguration(String location, String configuration){
		String value = null;
		String myConfigurationURL = "src/log4j2.properties";
		
		String[] loc = location.split("/");
		String serviceName = loc[loc.length-1];
		
/*	
 * 		方法1
 * 		根据.properties文件的key获得并改变value	
		if(configuration == null){
			
		}else{
			myConfiguration = configuration;
		}
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(new File(myConfiguration)));
				Properties p = new Properties();
				p.load(in);
				String value = p.getProperty("log4j.appender.D.File");
				System.out.println("D before name:" + value);
				String[] temp1 = value.split("/");
				String temp2 = temp1[0] + "/" + temp1[1] + "/" + serviceName + "/" + temp1[3];
				System.out.println("D after name:" + temp2);
				p.setProperty("log4j.appender.D.File", temp2);		
				FileOutputStream fos = new FileOutputStream(new File(myConfiguration));
				p.store(fos, "保存文件");
				
				fos.close();
				return myConfiguration;
			} catch (IOException e) {
				e.printStackTrace();
			}*/	
		

/*	
 * 		方法2
 *		一行一行的读取配置文件
		File file = new File(System.getProperty("user.dir") + File.separator
				+ "log4j.properties");
		BufferedReader reader = null;
		String value = null;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"UTF-8");
			reader = new BufferedReader(isr);
			String readContent = null;
			int line = 1;
			//一次读入一行，直到读到null 为文件结束
			while((readContent = reader.readLine()) != null){
				if(readContent.contains("log4j.appender.D.File")){
					String[] temp = readContent.split("=");
					value = temp[1].trim();
				}
				line++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
	
  		//方法3
  		//读取改写log4j.properties 文件的最终版	
		if(configuration == null){
			
		}else{
			myConfigurationURL = configuration;
			System.out.println("myConfiguration: " + myConfigurationURL);
		}
		File f = new File(myConfigurationURL);
		BufferedReader reader = null;
		StringBuffer strBuffer = new StringBuffer();
		PrintWriter printWriter;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 判断是否包含关键字，将包含并且不是注释的记录，进行替换
				if (tempString.contains("log4j.appender.E.File")) {
					System.out.println("line " + line + ": " + tempString);
					
					String[] temp1 = tempString.split("=");
					String[] temp2 = temp1[1].split("/");
					String temp = temp1[0] + "=" + temp2[0] + "/" + temp2[1] + "/" + serviceName + "/" + temp2[3];
					
					tempString = tempString.replace(tempString, temp);
				}
				// 将读取到的所有的记录写到缓冲区中，最后在写到源文件中即可
				strBuffer.append(tempString);
				strBuffer.append(System.getProperty("line.separator"));
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// 替换后输出的文件位置
		try {
			printWriter = new PrintWriter(myConfigurationURL);
			printWriter.write(strBuffer.toString().toCharArray());
			printWriter.flush();
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(new File(myConfigurationURL)));
			Properties p = new Properties();
			p.load(in);
			value = p.getProperty("log4j.appender.E.File");
			System.out.println("D before name:" + value);
		} catch (IOException e) {
			e.printStackTrace();
		}					
		return value;
	}
	
	//测试
	public static void main(String[] args) {
		makeConfiguration("./nnn/订票服务", null);
	}
}
