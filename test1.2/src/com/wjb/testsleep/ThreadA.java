package com.wjb.testsleep;

public class ThreadA extends Thread{
	private ThreadB b;
	public ThreadA(ThreadB b){
		super();
		this.b = b;
	}
	@Override
	public void run(){
		try{
			synchronized (b){
				b.start();	
				Thread.sleep(5000);
				//Thread.sleep(6000);//²»ÊÍ·ÅËø
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
