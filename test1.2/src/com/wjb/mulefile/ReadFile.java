package com.wjb.mulefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFile {
    /** 
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ��� 
     */ 
	public void readFileByBytes(String fileName){
		File file = new File(fileName);
		InputStream in = null;
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�"); 
			// һ�ζ�һ���ֽ� 
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {  
				System.out.write(tempbyte);  
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
    /** 
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ� 
     */  
    public static void readFileByChars(String fileName) {  
        File file = new File(fileName);  
        Reader reader = null;  
        try {  
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
            // һ�ζ�һ���ַ�  
            reader = new InputStreamReader(new FileInputStream(file));  
            int tempchar;  
            while ((tempchar = reader.read()) != -1) {  
                // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�  
                // ������������ַ��ֿ���ʾʱ���ỻ�����С�  
                // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�  
                if (((char) tempchar) != '\r') {  
                    System.out.print((char) tempchar);  
                }  
            }   
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{
        	try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    /** 
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    } 
    
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.readFileByLines("D:/testmulefile.txt");
	}
	
}
