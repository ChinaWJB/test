package niuke;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将只有空格和字母组成的字符串，中所有的字母大小写转换，并全部倒置
 * @author wjb
 *
 */
public class SwitchWordsAndReverse {
//	只是转换大小写，和反转，没有考虑空格
	/**
	 * 将字符串和空格组成的字符串中，字母大小写转换，并全部倒置
	 * 不能完成任务
	 * @param s
	 * @return
	 */
//	public String test1(String s){
//		s = s.trim();
//		if(s == null){
//			return null;
//		}
//		String[] s1 = s.split(" ");
//		String s2 = "";
//		char[] ch = null;
//		char[] ch2 = null;
//		int len = 0;
//		for(int i = 0; i<s1.length; i++){	
//			ch = s1[i].toCharArray();
//			len = ch.length;
//			ch2 = new char[len];
//			len -= 1;
//			for(int j = 0; j<ch.length; j++){
//				if(ch[j]>64 && ch[j]<91){
//					ch[j] += 32;
//					ch2[len--] = ch[j];
//				}else if(ch[j]>94 && ch[j]<123){
//					ch[j] -= 32;
//					ch2[len--] = ch[j];
//				}else{
//					
//				}
//			}
//			s2 = String.valueOf(ch2) + " " +s2;
//			
//		}			
//		
//		return s2.toString();
//	}
	
	/**
	 * 方法2
	 * 不可以完成要求
	 * 单词本身不反转
	 * 将字符串全部转换成字符，并将所有的字母转换大小写，在倒着写入字符串
	 * @param s
	 * @return
	 */
	public String test2(String s){		
		//进来先判断是否只有空格或传入的是空值
		Pattern p = Pattern.compile("\\s*");
		Matcher m = p.matcher(s);
		boolean b = m.matches();
		if(b){
			return "只有0个或多个空格";
		}
		
		String str = "";
		char[] ch = s.toCharArray();
		for(int i = 0; i<ch.length; i++){
			if(ch[i]>64 & ch[i]<91){
				ch[i] += 32;
			}else if(ch[i]>94 && ch[i]<123){
				ch[i] -= 32;
			}else{
				
			}
		}
		for(int j = ch.length-1; j>=0; j--){
			str += ch[j];
		}
		return str;
	}
	
	/**
	 * 方法3
	 * 只考虑单词之间有单个空格
	 * 不可行，没有考虑首尾的空格
	 * @param s
	 * @return
	 */
	public String test3(String s){
		String[] str = s.split(" ");
		String value = "";
		for(int i=0; i<str.length; i++){
			String temp = "";
			char[] ch = str[i].toCharArray();
			for(int j = 0; j<ch.length; j++){
				if(ch[j]>64 & ch[j]<91){
					ch[j] += 32;
				}else if(ch[j]>94 && ch[j]<123){
					ch[j] -= 32;
				}else{
					
				}
				temp += ch[j];
			}
			
			value = value + temp +" ";
		}
		return value;
	}
	
	/**
	 * 空格和字符串分别单独考虑
	 * 完全正确
	 * @param s
	 */
	public static String test4(String s){							
		char[] ch = s.toCharArray();
		int flag = 0;
		int count = 0;
		String string = "";
		String string0 = "";
		int[] c1 = new int[s.length()];

		String value = "";
		for(int i = 0; i<ch.length; i++){
			if(ch[i] == ' '){
				if(flag == 1){
					value = string + value;
				}
				
				string0 += ch[i];
				
				flag = 0;
				string = "";
			}else{
				if(flag == 0){
					value = string0 + value;
					count++;
				}
				
				if(ch[i]>64 && ch[i]<91){
					ch[i] += 32;
				}else if(ch[i]>94 && ch[i]<123){
					ch[i] -= 32;
				}					
				string = string + ch[i];
									
				flag = 1;
				string0 = "";
			}
		}
		value = string + string0 + value;
		return value;	
	}
	
	public static void main(String[] args) {
		SwitchWordsAndReverse t = new SwitchWordsAndReverse();
//		String s = "Hello World   I am  wjb";
//		String s = "  ";
		String s = " h    i   ";
		System.out.println(t.test4(s));
	}
}
