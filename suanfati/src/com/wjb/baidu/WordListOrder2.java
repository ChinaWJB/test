//package com.wjb.baidu;
///**
// * 小强方法：（没做出来）
// * 		String left[]存放尾字符和当前字符串首字符相等的字符串
// * 		String right[]存放首字符和当前字符串尾字符相等的字符串
// * @author wjb
// *
// */
//public class WordListOrder2 {
//	
//	public static int canArrangeWords(String arr[]){
//		String[] usedStr = new String[arr.length]; 
//		int[] used = new int[arr.length];
//		
//	}
//	
//	public static int test(String[] arr, int index, int[] used){
//		String[] left = new String[arr.length];
//		String[] right = new String[arr.length];
//		int n = 0;
//		int m = 0;
//		char start = arr[index].charAt(0);
//		char end = arr[index].charAt(arr[index].length());
//		for(int i = 0; i<arr.length; i++){
//			if(used[i] != 1){
//				if(arr[index].charAt(0) == end){
//					right[n++] = arr[index];
//					used[i] = 1;
//				}
//			}
//		}
//	}
//}
