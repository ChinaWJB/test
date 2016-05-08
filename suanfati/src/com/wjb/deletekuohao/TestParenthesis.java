package com.wjb.deletekuohao;

import java.util.Stack;

/**
 * (1,(2,3),(4,(5,6),7))
 * 功能1，消除表达式中的括号，结果为：(1,2,3,4,5,6,7)
 * 功能2，同时，要判断表达式是否正确（括号是否正确，整个字符串是否有其它字符）
 * 括号：parenthesis、bracket
 * @author wjb
 *
 */
public class TestParenthesis {
	/**
	 * 方法1：
	 * 
	 * 直接合成结果
	 * 
	 * @param s
	 * @return
	 */
	public static String change_str(String s){
		String result = "(";			//用于构造结果集
		char[] ch = s.toCharArray();	//转换成字符数组
		int bracket_num = 0;			//用于判断括号的是否匹配
		int i = 0;
		while(i < ch.length){
			if(ch[i] == '('){
				bracket_num ++;
			}
			else if(ch[i] ==')'){
				if(bracket_num > 0){
					bracket_num --;
				}else{					//反括号数目出现负值，肯定有异常
					System.out.println("Expression wrong!");
					return null;
				}
			}
			else if(ch[i] == ','){
				result += ch[i++];	//ch[i++]为','，和result拼接结果集后i++
				continue;
			}
			else if(ch[i] >= '0' && ch[i] <= '9'){
				result += ch[i++];	//只是将数字和","和结果集结合，
				continue;
			}
			else{						//说明有其它的字符，就输出异常
				System.out.println("Expression wrong!");
				return null;
			}
			i++;	//很重要，循环次数判断条件
		}
		if(bracket_num != 0){	//最后的括号数应该为0，否则肯定有异常
			System.out.println("Expression wrong!");
			return null;
		}
		result += ')';	//拼接结果字符串的最后一个反括号
		return result;
	}
	
	/**
	 * 方法2：
	 * 
	 * 用栈实现
	 * 
	 * @param s
	 * @return
	 */
	public static String test(String s){
		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();
		int count = 0;
		stack.push('(');
		String value = "";
		for(int i = 0; i<ch.length; i++){
			if(ch[i] == '('){
				count++;
			}else if(ch[i] == ')'){
				if(count>0){
					count--;
				}else{
					System.out.println("ERROR");//反括号多不匹配
					return null;
				}
			}else if(ch[i] >= '0' && ch[i] <= '9'){
				stack.push(ch[i]);
			}else if(ch[i] == ','){
				stack.push(ch[i]);
			}else{
				System.out.println("ERROR");//有其他字符
				return null;
			}
		}
		if(count != 0){
			System.out.println("ERROR");//最终括号不匹配
			return null;
		}
		stack.push(')');
		while(!stack.isEmpty()){
			value = stack.pop() + value;
		}
		return value;
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(1,(2,3),(4,(5,6),7))";
//		String result = change_str(s);
		String result = test(s);
		if(result != null){
			System.out.println(result);
		}
		
		s = "((1,(2,3),(4,(5,6),7))";
//		result = change_str(s);
		result = test(s);
		if(result != null){
			System.out.println(result);
		}
	}
}
