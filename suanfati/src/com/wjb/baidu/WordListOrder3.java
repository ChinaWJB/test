package com.wjb.baidu;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 用ArrayList<String>和整型数组取代Iterator
 * @author wjb
 *
 */
public class WordListOrder3 {
	static int value = -1;
	public static int canArrangeWords(String arr[]){
		if(arr.length == 1){
			return -1;
		}		
		
		//用于方便查找，当前索引的对应的数组中的字符串是否已经被用过
		int[] index = new int[arr.length];
		for(int i = 0; i<index.length; i++){
			index[i] = 0;
		}
		
		//存放已经用过的字符串，通过容量大小来判断是否已经满足条件
		ArrayList<String> al = new ArrayList<String>();
		
		//循环让每数组中的每一个元素都当一回首元素
		for(int i = 0; i<arr.length; i++){
			String str = arr[i];
			al.add(str);
			index[0] = 1;
			test(arr, str, al, index);
			if(value == 1){
				break;
			}else{
				al.remove(str);
				index[0]=0;
			}
//			System.out.println((String)it.next());
		}
		return value;
	}
	
	public static void test(String[] arr, String s, ArrayList<String> al, int[] index){
		if(value ==1){
			return;
		}
		int j = 0;
		while(j < arr.length && value != 1){
			if(index[j] == 0){
				char begin = arr[j].charAt(0);
				char end = s.charAt(s.length()-1);
				if(begin == end){
					al.add(arr[j]);
					index[j] = 1;
					if(al.size() == arr.length){
						value = 1;
						break;
					}	
					test(arr, arr[j], al, index);
					if(value != 1){
						al.remove(arr[j]);
						index[j] = 0;
					}

				}				
			}
			j++;			
		}
	}
	
	public static void copy(ArrayList<String> seto, ArrayList<String> seti){
		Iterator it = seto.iterator();
		while(it.hasNext()){
			seti.add((String)it.next());
		}
	}
	
	public static void main(String[] args) {
//		String[] arr = {"ett","trc","cba","abu","utc"};
		String[] arr = {"abc","cba","abc","cbu","tbm"};
//		String[] arr = {"abc"};
		int num = canArrangeWords(arr);
		System.out.println(num);
//		canArrangeWords(arr);
	}
}
