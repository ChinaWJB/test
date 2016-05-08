package com.wjb.proxy.staticproxy;

import com.wjb.proxy.UserService;

/**
 * ��̬������
 * �������Ϊ��������ǶԽӿڵ�ʵ�������һ�ΰ�װ
 * @author wjb
 *
 */
public class UserServiceProxy implements UserService{
	private UserService userService;
	
	public UserServiceProxy(UserService userService){
		this.userService = userService;
	}
	
	public void open(){
		System.out.println("1:�����ݿ�����");
	}
	
	public void close(){
		System.out.println("3:�ر����ݿ�����");
	}
	
	@Override
	public void saveUser() {
		this.open();
		userService.saveUser();
		this.close();		
	}

}
