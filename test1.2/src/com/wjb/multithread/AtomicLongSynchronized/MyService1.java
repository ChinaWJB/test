package com.wjb.multithread.AtomicLongSynchronized;

import java.util.concurrent.atomic.AtomicLong;

public class MyService1 {
	public static AtomicLong aiRef = new AtomicLong();
	public void addNum(){
		System.out.println(Thread.currentThread().getName() + "����100֮���ֵ�ǣ� "
				+ aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}
}
