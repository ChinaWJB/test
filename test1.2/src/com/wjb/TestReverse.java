package com.wjb;

import java.io.File;

public class TestReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverse(-123454891));
		tree("D:\\eclipse");
		
	}
	
	public static void tree(String path) {
		File f = new File(path);
		if (!f.isDirectory()) return;
		recurse(f, 1);
	}
	
	public static void recurse(File f, int depth) {
		File[] list = f.listFiles();
		int noDir = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				for (int j = 0; j < i + depth - noDir; j++) System.out.print("  ");
				System.out.println(list[i].getName());
			} else {
				noDir++;
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				recurse(list[i], depth + 1);
			}
		}
	}
 
	
	public static int reverse(int num) {
		int re = 0;
		if (num > Math.pow(2, 32) || num < 0) return 0;
		while (num > 0) {
			re = re * 10 + num % 10;
			num /= 10;
		}
		if (re > Math.pow(2, 32) || re < 0) return 0;
		return re;
	}
}
