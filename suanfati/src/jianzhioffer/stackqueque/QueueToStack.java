package jianzhioffer.stackqueque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列模拟栈操作
 * 压栈：
 * 		往不为0的队列中压入元素、
 * 弹栈：
 * 		看哪个队列中只有一个元素就弹出
 * 		如果没有只有一个的队列，则肯定一个为空，一个钟多于一个元素，这时，将有元素的队列中的元素弹出并压入到空队列，但要保留最后一个，并弹出
 * @author wjb
 *
 */
public class QueueToStack {
	static Queue<Character> q1 = new LinkedList<Character>();
	static Queue<Character> q2 = new LinkedList<Character>();	
	
	public static void push(char value){
		if(q2.size() == 0){
			q1.offer(value);
		}else if(q1.size() == 0){
			q2.offer(value);
		}
	}
	
	public static char pop(){
		if(q1.size() == 1){
			return q1.poll();
		}else if(q2.size() == 1){
			return q2.poll();
		}else if(q2.size() == 0 && q1.size() != 0){
			while(q1.size()>1){
				char temp = q1.poll();
				q2.offer(temp);
			}
			return q1.poll();
		}else if(q1.size() == 0 && q2.size() != 0){
			while(q2.size()>1){
				char temp = q2.poll();
				q1.offer(temp);
			}
			return q2.poll();
		}else {
			return (Character) null;
		}
	}
	
	public static void main(String[] args) {
		push('a');
		push('b');
		push('c');
		
		char c1 = pop();
		System.out.println(c1);
		char c2 = pop();
		System.out.println(c2);
		char c3 = pop();
		System.out.println(c3);
		char c4 = pop();
		System.out.println(c4);
		
//		push('d');
//		char c3 = pop();
//		System.out.println(c3);
		
//		char c2 = pop();
//		System.out.println(c1 + " " + c2);
		
//		push('d');
//		char c3 = pop();
//		System.out.println(c3);

	}
	
}
