package com.wjb.testfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriteReadFile {
	/**
	 * ����������
	 *  1.boolean createNewFile() �����ڷ���true ���ڷ���false
	 *	2.boolean mkdir() ����Ŀ¼
	 *	3.boolean mkdirs() �����༶Ŀ¼
	 * �жϷ�����
	 *  1.boolean canExecute()�ж��ļ��Ƿ��ִ��
	 *  2.boolean canRead()�ж��ļ��Ƿ�ɶ�
	 *  3.boolean canWrite() �ж��ļ��Ƿ��д
	 *  4.boolean exists() �ж��ļ��Ƿ����
	 *  5.boolean isDirectory()
	 *  6.boolean isFile()
	 *  7.boolean isHidden()
	 *  8.boolean isAbsolute()�ж��Ƿ��Ǿ���·�� �ļ�������Ҳ���ж�
	 * ɾ���ļ�
	 *  1.boolean delete()
	 *  2.boolean deleteOnExit() �ļ�ʹ����ɺ�ɾ��
	 *  
	 *  �������ֽ���д�ļ�ʱ����Ҫͨ��
	 *  byte[] b = str.getBytes();
	 *  fop.write(b);����д��
	 * 
	 * ����1
	 * ���ļ���д����
	 * @param path
	 */
	public void writeFile1(String path){
		File f = new File(path);		
		FileOutputStream fos;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		try {
			fos = new FileOutputStream(f);
			osw = new OutputStreamWriter(fos);
			pw = new PrintWriter(osw);
			pw.write("abcdefghigklmnopqrstuvwxyz");
			pw.println();
			pw.append("abcdefghigklmnopqrstuvwxyz");
			pw.flush();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				pw.close();
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * ����2��Ӧ��������
	 * д�ļ�
	 * @param path
	 */
	public void writeFile2(String path){
		File f = new File(path);
		FileWriter fw = null;
		try {
//			fw = new FileWriter(f);
			fw = new FileWriter(path);//Ҳ����
			fw.write("abcdefghigklmnopqrstuvwxyz\r\n");//����"\n"�����ð������ܻ���
			fw.write("abcdefghigklmnopqrstuvwxyz");
//			fw.write("\n");
//			fw.append("abcdefghigklmnopqrstuvwxyz");
			fw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����3���ο��
	 * д�ļ�
	 * @param path
	 */
	public void writeFile3(String path){
		File f = new File(path);
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		char[] c = {'a','b','c','u'};
		try {
			fos = new FileOutputStream(f);
//			fos = new FileOutputStream(path);//Ҳ����
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			bw.write("qwerafdzcvetylkju");
			bw.newLine();
			bw.write("sdfvdvdd");
			bw.newLine();
			bw.append("huhuhuhuhuhu");
			bw.newLine();
			bw.write(c);
			bw.newLine();
			bw.append("werererererer");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				osw.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	/**
	 * �ҵ�ѡ��
	 * @param path
	 */
	public void writeFile4(String path){
		File f = new File(path);
		FileWriter fw = null;
		BufferedWriter bw = null;
		char[] c = {'a','b','c','u'};
		try {
//			fw = new FileWriter(f);
			fw = new FileWriter(path);//Ҳ����
			bw = new BufferedWriter(fw);
			
			bw.write("qwerafdzcvetylkju");
			bw.newLine();
			bw.write("sdfvdvdd");
			bw.newLine();
			bw.append("huhuhuhuhuhu");
			bw.newLine();
			bw.write(c);
			bw.newLine();
			bw.append("werererererer");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����1
	 * ���ļ�
	 * @param path
	 */
	public void readFile(String path){
		File f = new File(path);
		FileReader fr = null;
		int i;
		try {
			fr = new FileReader(f);
//			fr = new FileReader(path);//Ҳ��
			while((i = fr.read())!= -1){//read()���ص���һ���ַ���ASCIIֵ��������Ҫǿ��ת����char
//				System.out.println(i);
				System.out.print((char)i);
			}						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readFile2(String path){
		File f = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		String s = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while(br.read() != -1){
				s = br.readLine();
				System.out.println(s);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}
	
	public static void main(String[] args) {
		WriteReadFile wrf = new WriteReadFile();
		String path = "d:\\W.txt";
//		wrf.writeFile3(path);
		wrf.readFile2(path);
	}
}
