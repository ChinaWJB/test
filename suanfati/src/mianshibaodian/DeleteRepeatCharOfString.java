package mianshibaodian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteRepeatCharOfString {
	/**
	 * 方法1，
	 * 自己想的，
	 * 原理：用map判断重复，用ArrayList装map中没有出现过的字符
	 * @param s
	 * @return
	 */
	public String test(String s){
		String str = "";
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		ArrayList<Character> al = new ArrayList<Character>();
		
		for(int i = 0; i<s.length(); i++){
			if(map.get(s.charAt(i)) != null){
				continue;
			}else {
				map.put(s.charAt(i), 1);
				al.add(s.charAt(i));
			}
		}
		for(int j = 0; j < al.size(); j++){
			str += al.get(j);
		}			
		return str;	
	}
	
	/**
	 * 方法2
	 * 暴力法，
	 * 两个循环进行比较，将所有的重复的字符赋为'\0';
	 * 最后将所有'\0'去掉
	 * 省略。。。。。。
	 */
	
	/**
	 * 空间交换
	 * 申请一个256的int类型的数组，出现一次将对应为置1，否则置0，重复出现时将字符数组对应位置'\0'
	 * int位32位，所以大小为8就可以了
	 * @param str
	 * @return
	 */
	public String removeDuplicate(String str){
		String s = "";
		char[] c = str.toCharArray();
		int len = c.length;
		int[] flag = new int[8];
		//先将标志位字符数组初始化为0
		for(int i = 0; i<8; i++){
			flag[i] = 0;
		}
		
		//利用类桶的查找+移位，位判断的方法进行判重复出现的字符，并将其置'\0'
		for(int i = 0; i<c.length; i++){
			int index = c[i]/32;		//可以理解为桶的索引0~7
			int shift = c[i]%32;		//可以理解为桶中元素的索引0~31
			if(((flag[index]) & (1<<shift)) != 0){
				c[i] = '\0';
			}
			flag[index] |= (1<<shift); 
		}
		
		//将字符数组中的'\0'取消，并将非'\0'的字符向前填充字符数组
		int l = 0;
		for(int i = 0; i<c.length; i++){
			if(c[i] != '\0'){
				c[l++] = c[i];
			}
		}				
		return new String(c, 0, l);
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteRepeatCharOfString d = new DeleteRepeatCharOfString();
		String s = "   ab   ccdddef";
		System.out.println(d.test(s));
		System.out.println(d.removeDuplicate(s));
	}
}
