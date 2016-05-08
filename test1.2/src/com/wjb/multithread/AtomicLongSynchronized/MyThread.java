package com.wjb.multithread.AtomicLongSynchronized;

public class MyThread extends Thread{
	private MyService2 myService;
	public MyThread(MyService2 myService){
		super();
		this.myService = myService;
	}
	
	@Override
	public void run(){
		myService.addNum();
	}
}
