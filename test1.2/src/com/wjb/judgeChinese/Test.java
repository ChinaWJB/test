package com.wjb.judgeChinese;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断一个字符串中是否含有中文字符，
 * 若含有则用正则表达式匹配的方式找出字符串中的中文字符
 * @author wjb
 *
 */
public class Test {
	public static void judgeChineseCharactor(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		//根据字节数和字符串长度，判断是否存在中文字符
		if(str.getBytes().length == str.length()){
			System.out.println("无汉字");
		}else{
			//如果存在中文字符，找出字符串中的中文字符
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			while(m.find()){
				System.out.print(m.group(0) + "  ");
			}
		}
	}
	
	public static void main(String[] args) {
		judgeChineseCharactor("Hello World");
		judgeChineseCharactor("hello 你好   world 世界");
	}
}
