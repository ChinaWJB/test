package com.wjb.proxy.staticproxy;

import com.wjb.proxy.UserService;

/**
 * 静态代理类
 * 可以理解为，代理就是对接口的实现类进行一次包装
 * @author wjb
 *
 */
public class UserServiceProxy implements UserService{
	private UserService userService;
	
	public UserServiceProxy(UserService userService){
		this.userService = userService;
	}
	
	public void open(){
		System.out.println("1:打开数据库连接");
	}
	
	public void close(){
		System.out.println("3:关闭数据库连接");
	}
	
	@Override
	public void saveUser() {
		this.open();
		userService.saveUser();
		this.close();		
	}

}
