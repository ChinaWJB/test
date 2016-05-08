package com.wjb.baidu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 只需要队列，队列有自己的Iterator，用Iterator遍历队列中的元素
 * 
 * Queue<Integer> q = new LinkedList<Integer>();
 * 
 * @author wjb
 *
 */
public class CachPage2 {
	
	static Queue<Integer> q = new LinkedList<Integer>();
	static int count = 0;	//存放满足条件的网页数
	
	public static int test(int cache, int[] page){
		return test1(q,cache, page, 0);
	}
	
	public static int test1(Queue<Integer> queue, int cache, int[] page, int index){
		int temp = 0;
		Iterator<Integer> it = queue.iterator();
		/*
		 * 缓存没有满，网页数组中的网页还没有遍历完
		 */
		if(cache != 0 && index != page.length){
			/*
			 * 遍历队列，查看队列中是否已经存在传来的网页
			 */
			while(it.hasNext()){
				if(it.next() == page[index]){
					temp = 1;
					break;
				}
			}
			/*
			 * 队列中没有该网页
			 */
			if(temp != 1){
				count++;
				queue.offer(page[index]);
				cache--;
				index++;
				test1(queue, cache, page, index);
			}else{	//队列中已有该网页
				index++;
				test1(queue, cache, page, index);
			}
		}
		/*
		 * 缓存已满，网页数组中的网页没有遍历完
		 */
		else if(cache == 0 && index != page.length){
			/*
			 * 遍历队列，查看队列中是否已经存在传来的网页
			 */
			while(it.hasNext()){
				if(it.next() == page[index]){
					temp = 1;
					break;
				}
			}
			/*
			 * 队列中没有该网页
			 */
			if(temp != 1){
				count++;
				queue.poll();
				queue.offer(page[index]);
				index++;
				test1(queue, 0, page, index);
			}else{	//队列中已有该网页
				index++;
				test1(queue, cache, page, index);
			}
		}
		/*
		 * 网页数组已经遍历完了，不管缓存队列是否已满，最终都返回count
		 */
		return count;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		int value = test(2, num);
		System.out.println(value);
	}
}
