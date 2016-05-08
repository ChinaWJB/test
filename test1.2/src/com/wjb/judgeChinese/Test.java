package com.wjb.judgeChinese;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ж�һ���ַ������Ƿ��������ַ���
 * ����������������ʽƥ��ķ�ʽ�ҳ��ַ����е������ַ�
 * @author wjb
 *
 */
public class Test {
	public static void judgeChineseCharactor(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		//�����ֽ������ַ������ȣ��ж��Ƿ���������ַ�
		if(str.getBytes().length == str.length()){
			System.out.println("�޺���");
		}else{
			//������������ַ����ҳ��ַ����е������ַ�
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			while(m.find()){
				System.out.print(m.group(0) + "  ");
			}
		}
	}
	
	public static void main(String[] args) {
		judgeChineseCharactor("Hello World");
		judgeChineseCharactor("hello ���   world ����");
	}
}
