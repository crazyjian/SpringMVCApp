package com.jerry.myapp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method
		System.out.println("---------调用代理类开始---------");
		Object result = method.invoke(target, args);
		System.out.println("---------调用代理类结束---------");
		return result;
	}
	
	public Object getProxy() {  
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),   
                target.getClass().getInterfaces(), this);  
    }  

}
