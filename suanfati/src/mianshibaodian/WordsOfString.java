package mianshibaodian;

public class WordsOfString {
	/**
	 * 自己写的在一个字符串中找出所有单词的个数;
	 * 1.先去除字符串首的空格
	 * 2.进入两个if判断
	 * 3.第一个if，用s.charAt(index)和' '比较i，若为空格，则进入里面的if，否则结束本次循环
	 * 4.第二个if，再次比较i+1，若不为空格则count++，否则结束本次循环
	 * @param s
	 * @return
	 */
	public int wordCount(String s){
		int count = 0;
		int j = 0;
		s = s.trim();
		
		/*去除字符串首的空格*/
		if(s.charAt(0) == ' '){
			for(; j<s.length(); j++){
				if(s.charAt(j) != ' '){					
					break;
				}
			}
		}
		for(int i = j; i<s.length(); i++){
			if(s.charAt(i) == ' '){
				if(s.charAt(i+1) != ' '){
					count++;
				}
			}
		}		
		return count+1;
	}
	
	/**
	 * java面试宝典
	 * 利用标志位来判断是否为空，
	 * 只要为' '就将标志位赋0
	 * 充分利用if()和else if()
	 * @param s
	 * @return
	 */
	public int wordCount2(String s){
		int count = 0;
		int signal = 0;		//用标志位来判断是否为下一个单词，只要是空格，就将signal赋0
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == ' '){
				signal = 0;
			}else if(signal == 0){	//进入该程序满足两个条件：1.字符不为空，2.标志位为0（确保是空格后的单词）
				signal = 1;
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		WordsOfString wn = new WordsOfString();
		System.out.println(wn.wordCount("   I am     wangjiabin"));
	}
}
