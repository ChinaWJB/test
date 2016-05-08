package jianzhioffer.stackqueque;

import java.util.Stack;

/**
 * 两个栈模拟队列
 * 
 * 压队列：
 * 		只往栈1中压
 * 弹队列：
 * 		只弹出栈2的元素
 * 		如果栈2不为空，只是弹出栈2中的元素即可
 * 		如果栈2为空，则先将栈1中的元素全部弹出，并压入到栈2中
 * 
 * @author wjb
 *
 */
public class StackToQueue {
	static Stack<Character> s1 = new Stack<Character>();
	static Stack<Character> s2 = new Stack<Character>();
	
	public static void offer(char value){
		s1.push(value);
	}
	
	public static char pull(){
		if(!s2.isEmpty()){
			return s2.pop();
		}else if(!s1.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}else{
			return (Character) null;
		}
	}
	
	public static void main(String[] args) {
		offer('a');
		offer('b');
		offer('c');
		
		char c1 = pull();
		System.out.println(c1);
		

		
		char c2 = pull();
		System.out.println(c2);
		

		
		char c3 = pull();
		System.out.println(c3);
		
		offer('a');
		offer('d');
		char c4 = pull();
		char c5 = pull();
		System.out.println(c4);
		System.out.println(c5);
	}
}	
