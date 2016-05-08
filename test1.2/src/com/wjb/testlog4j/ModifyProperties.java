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
 * 		����1
 * 		����.properties�ļ���key��ò��ı�value	
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
				p.store(fos, "�����ļ�");
				
				fos.close();
				return myConfiguration;
			} catch (IOException e) {
				e.printStackTrace();
			}*/	
		

/*	
 * 		����2
 *		һ��һ�еĶ�ȡ�����ļ�
		File file = new File(System.getProperty("user.dir") + File.separator
				+ "log4j.properties");
		BufferedReader reader = null;
		String value = null;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"UTF-8");
			reader = new BufferedReader(isr);
			String readContent = null;
			int line = 1;
			//һ�ζ���һ�У�ֱ������null Ϊ�ļ�����
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
		
	
  		//����3
  		//��ȡ��дlog4j.properties �ļ������հ�	
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
			System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			int line = 1;
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null) {
				// �ж��Ƿ�����ؼ��֣����������Ҳ���ע�͵ļ�¼�������滻
				if (tempString.contains("log4j.appender.E.File")) {
					System.out.println("line " + line + ": " + tempString);
					
					String[] temp1 = tempString.split("=");
					String[] temp2 = temp1[1].split("/");
					String temp = temp1[0] + "=" + temp2[0] + "/" + temp2[1] + "/" + serviceName + "/" + temp2[3];
					
					tempString = tempString.replace(tempString, temp);
				}
				// ����ȡ�������еļ�¼д���������У������д��Դ�ļ��м���
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
		// �滻��������ļ�λ��
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
	
	//����
	public static void main(String[] args) {
		makeConfiguration("./nnn/��Ʊ����", null);
	}
}
