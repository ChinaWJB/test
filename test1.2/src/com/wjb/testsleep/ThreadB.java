package com.wjb.testsleep;

public class ThreadB extends Thread{
	@Override
	public void run(){
		try{
			synchronized (this) {
				System.out.println(" b run begin timer= " + System.currentTimeMillis());
				Thread.sleep(4000);
				System.out.println(" b run end timer= " + System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	synchronized public void bService(){
		System.out.println("¥Ú”°¡ÀbServicre timer= " + System.currentTimeMillis());
	}
}
