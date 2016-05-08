package com.wjb.proxy.staticproxy;

import com.wjb.proxy.UserService;
import com.wjb.proxy.UserServiceImpl;

public class TestProxy {
	public static void main(String[] args) {
		UserService userService = new UserServiceProxy(new UserServiceImpl());
		userService.saveUser();
	}
}
