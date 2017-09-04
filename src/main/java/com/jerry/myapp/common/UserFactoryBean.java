package com.jerry.myapp.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.jerry.myapp.model.User;

@Component
public class UserFactoryBean implements FactoryBean<User>,InitializingBean {
	
	private String beanName = "UserFactoryBean";

	@Override
	public User getObject() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(1);
		user.setUserName("jerry");
		return user;
	}

	@Override
	public Class<User> getObjectType() {
		// TODO Auto-generated method stub
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行afterPropertiesSet方法");
		
	}
	
	 public void init() {    
	        System.out.println("init-method is called");    
	 }   

}
