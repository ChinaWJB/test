package com.wjb.proxy.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler{
	private Object target = null;
	
	/*可以把该方法放到外面，主要作用：用反射机制生成动态代理*/
	public Object getProxy(Object obj){
		this.target = obj;//保存真是业务对象		
		/*该方法返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序*/
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {	
		System.out.println("Before");
		Object result = method.invoke(target, args);//通过反射调用真实业务对象的业务方法，并且返回
		System.out.println("After");
		return null;
	}
	
}
