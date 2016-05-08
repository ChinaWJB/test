package com.wjb.mulefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WriteFile {

	public void writeToFile1(File f, String s){
		FileOutputStream out = null;
		try {
			// if file doesnt exists, then create it
			if (!f.exists()) {
				f.createNewFile();
			}
			out = new FileOutputStream(f, true);
			out.write(s.getBytes());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFile2(File f, String s){
		FileWriter filewriter = null;
		try {
			// if file doesnt exists, then create it
			if (!f.exists()) {
				f.createNewFile();
			}
			filewriter = new FileWriter(f, true);
			filewriter.write(s);
			filewriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				filewriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFile3(File f, String s){
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			// if file doesnt exists, then create it
			if (!f.exists()) {
				f.createNewFile();
			}
			fw = new FileWriter(f);
			writer = new BufferedWriter(fw);
			writer.write(s);
			writer.flush();			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public void writerToFile4(File f, Set set){
		Iterator iterator = set.iterator();
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(f);
			writer = new BufferedWriter(fw);
			
			long begin3 = System.currentTimeMillis(); 
			
			while(iterator.hasNext()){
				writer.write(iterator.next().toString());
				writer.newLine();	//换行
			}
			writer.flush();
			
            long end3 = System.currentTimeMillis();   
            System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 豪秒"); 
			
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		File file = new File("D:/testmulefile.txt");
		String path = "D:/testmulefile.txt";
		String str = "Hello World!!!";
		WriteFile wf = new WriteFile();
		
		
//		wf.writeToFile1(file, str);
		
		
		/*测试输入多行*/
		Set set = new HashSet<String>();
		set.add("China");
		set.add("Ametica");
		set.add("Japan");
		wf.writerToFile4(file, set);
	}
}
