package com.jerry.myapp.job;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TestJob2 {
	
	public void doSomething() {
		 System.out.println("TestJob2当前时间为："+new Date());
	}

}
