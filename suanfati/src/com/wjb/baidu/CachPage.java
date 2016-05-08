package com.wjb.baidu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 一个存放不同网页的数组，用整型数组代替；一个缓存大小用整型数代替；
 * 网页往缓存中放，如果缓存中已有该网页则不往缓存中加（即同一个网页在缓存中只允许有一个），
 * 如果缓存已满，并且缓存中没有要加入的网页，则将在缓存中存放时间最长的网页删除。
 * 求每次网页往缓存中添加时，缓存中没有该网页，的次数。
 * 例：
 * 		{1,2,1,3,1,2}，和缓存大小为2，则这个次数为5。
 * @author wjb
 *
 */
public class CachPage {
	/*
	 * 利用队列和Map实现缓存的功能，
	 * 队列用于先进先出，即按照在缓存中的停留时间来pull出最先进入的
	 * Map用于遍历看网页是否已经存在于缓存中，并且，Map中存的网页数量是，指定的缓存大小的数量，所以要跟着队列增加和减少。
	 * 
	 */
	static Queue<Integer> q = new LinkedList<Integer>();
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	static int count = 0;
	
	public static int Test(int cache, int[] page){
		return Test1(cache, page, 0);
	}
	
	/**
	 * index用户遍历网页数组中的每一个网页，遍历一次后，自加1
	 * @param cache
	 * @param page
	 * @param index
	 * @return
	 */
	public static int Test1(int cache, int[] page, int index){
		int value = count;
		if(index != page.length){
			if(cache != 0 && (map.get(page[index]) == null)){
				q.offer(page[index]);
				map.put(page[index], 1);
				cache--;
				index++;
				count++;
				value = Test1(cache, page, index);
			}else if(cache == 0 && (map.get(page[index]) == null)){
				map.remove(q.peek());
				q.poll();				
				q.offer(page[index]);
				map.put(page[index], 1);
				index++;
				count++;
				value = Test1(0, page, index);
			}else if(cache != 0 && (map.get(page[index]) != null)){
				index++;
				value = Test1(cache, page, index);
			}else if(cache == 0 && (map.get(page[index]) != null)){
				index++;
				value = Test1(cache, page, index);
			}else{
				return value;
			}
		}else{
			return value;
		}
		return value;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,1,3,1,2};
		int value = Test(2, num);
		System.out.println(value);
	}
}
