package com.jerry.myapp.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/redis")
public class RedisController {
	
	@Autowired
	private RedisTemplate<String, Object>  redisTemplate;
	
	@RequestMapping("test")
	public String Test() {
		//redisTemplate.opsForValue().set("name", "redis");
	/*	redisTemplate.opsForList().leftPush("list", "1");
		redisTemplate.opsForList().leftPush("list", "3");
		redisTemplate.opsForList().leftPush("list", "2");
		redisTemplate.opsForList().leftPush("list", "4");
		redisTemplate.opsForList().leftPush("list", "8");*/
		redisTemplate.opsForList().leftPushAll("list", new String[]{"2","53","9"});
		System.out.println(redisTemplate.opsForList().range("list",1,3));
		return "redisTest";
	}

}
