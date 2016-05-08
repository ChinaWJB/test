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
	 * 创建方法：
	 *  1.boolean createNewFile() 不存在返回true 存在返回false
	 *	2.boolean mkdir() 创建目录
	 *	3.boolean mkdirs() 创建多级目录
	 * 判断方法：
	 *  1.boolean canExecute()判断文件是否可执行
	 *  2.boolean canRead()判断文件是否可读
	 *  3.boolean canWrite() 判断文件是否可写
	 *  4.boolean exists() 判断文件是否存在
	 *  5.boolean isDirectory()
	 *  6.boolean isFile()
	 *  7.boolean isHidden()
	 *  8.boolean isAbsolute()判断是否是绝对路径 文件不存在也能判断
	 * 删除文件
	 *  1.boolean delete()
	 *  2.boolean deleteOnExit() 文件使用完成后删除
	 *  
	 *  另外用字节流写文件时，需要通过
	 *  byte[] b = str.getBytes();
	 *  fop.write(b);才能写入
	 * 
	 * 方法1
	 * 向文件中写东西
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
	 * 方法2，应该是最快的
	 * 写文件
	 * @param path
	 */
	public void writeFile2(String path){
		File f = new File(path);
		FileWriter fw = null;
		try {
//			fw = new FileWriter(f);
			fw = new FileWriter(path);//也可以
			fw.write("abcdefghigklmnopqrstuvwxyz\r\n");//单独"\n"不管用啊，不能换行
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
	 * 方法3，次快的
	 * 写文件
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
//			fos = new FileOutputStream(path);//也可以
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
	 * 我的选择
	 * @param path
	 */
	public void writeFile4(String path){
		File f = new File(path);
		FileWriter fw = null;
		BufferedWriter bw = null;
		char[] c = {'a','b','c','u'};
		try {
//			fw = new FileWriter(f);
			fw = new FileWriter(path);//也可以
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
	 * 方法1
	 * 读文件
	 * @param path
	 */
	public void readFile(String path){
		File f = new File(path);
		FileReader fr = null;
		int i;
		try {
			fr = new FileReader(f);
//			fr = new FileReader(path);//也行
			while((i = fr.read())!= -1){//read()返回的是一个字符的ASCII值，所以需要强制转换成char
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
