package com.wjb.proxy.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler{
	private Object target = null;
	
	/*���԰Ѹ÷����ŵ����棬��Ҫ���ã��÷���������ɶ�̬����*/
	public Object getProxy(Object obj){
		this.target = obj;//��������ҵ�����		
		/*�÷�������һ��ָ���ӿڵĴ�����ʵ�����ýӿڿ��Խ���������ָ�ɵ�ָ���ĵ��ô������*/
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {	
		System.out.println("Before");
		Object result = method.invoke(target, args);//ͨ�����������ʵҵ������ҵ�񷽷������ҷ���
		System.out.println("After");
		return null;
	}
	
}
