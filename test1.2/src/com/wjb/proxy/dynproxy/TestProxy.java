package com.wjb.proxy.dynproxy;

import com.wjb.proxy.UserService;
import com.wjb.proxy.UserServiceImpl;

public class TestProxy {

	public static void main(String[] args) {
		
//		ServiceProxy sp = new ServiceProxy();
//		UserService service = (UserService)sp.getProxy(new UserServiceImpl());
		
		/*ֻ����Խӿڵ�ʵ���࣬�������ֶ�̬����*/
		UserService service = (UserService)new ServiceProxy().getProxy(new UserServiceImpl());
		
		service.saveUser();
	}
}
