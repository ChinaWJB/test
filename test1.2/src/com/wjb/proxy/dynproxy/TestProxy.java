package com.wjb.proxy.dynproxy;

import com.wjb.proxy.UserService;
import com.wjb.proxy.UserServiceImpl;

public class TestProxy {

	public static void main(String[] args) {
		
//		ServiceProxy sp = new ServiceProxy();
//		UserService service = (UserService)sp.getProxy(new UserServiceImpl());
		
		/*只能针对接口的实现类，利用这种动态代理*/
		UserService service = (UserService)new ServiceProxy().getProxy(new UserServiceImpl());
		
		service.saveUser();
	}
}
