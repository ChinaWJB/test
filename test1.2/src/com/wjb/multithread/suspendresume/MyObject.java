package com.wjb.multithread.suspendresume;

public class MyObject {
	private String username = "1";
	private String password = "11";
	public void setValue(String u, String p){
		this.username = u;
		System.out.println(u);
		System.out.println(p);
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("Õ£÷πaœﬂ≥Ã");
			System.out.println(u);
			System.out.println(p);
			Thread.currentThread().suspend();	
			System.out.println("after suspend");
			System.out.println(u);
			System.out.println(p);
		}
		this.password = p;
		System.out.println(u);
		System.out.println(p);
	}
	public void printUsernamePassword(){
		System.out.println(username + " " +password);
	}
}
