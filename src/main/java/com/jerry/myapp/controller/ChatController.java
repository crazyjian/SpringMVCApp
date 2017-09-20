package com.jerry.myapp.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="chat")
public class ChatController {
	
	private static String prefix = "chat/";
	
	/**
	 * 长轮询ajax方式
	 * @return
	 */
	@RequestMapping(value = "/chatPage")
	public String chatPage() {
		return prefix+"chatPage";
	}
	
	/**
	 * 长轮询iframe方式
	 * @return
	 */
	@RequestMapping(value = "/chatPage1")
	public String chatPage1() {
		return prefix+"chatPage1";
	}
	
	/**
	 * 长连接ajax方式
	 * @return
	 */
	@RequestMapping(value = "/chatPage2")
	public String chatPage2() {
		return prefix+"chatPage2";
	}
	
	@RequestMapping(value = "/chat")
	public void chat(Integer count, long timed, HttpServletResponse response) throws Exception {
		 PrintWriter writer = response.getWriter();
	     
	     Random rand = new Random();
	     // 死循环 查询有无数据变化
	     while (true) {
	         Thread.sleep(300); // 休眠300毫秒，模拟处理业务等
	         int i = rand.nextInt(100); // 产生一个0-100之间的随机数
	         if (i > 20 && i < 56) { // 如果随机数在20-56之间就视为有效数据，模拟数据发生变化
	             long responseTime = System.currentTimeMillis();
	             // 返回数据信息，请求时间、返回数据时间、耗时
	             writer.print("count: " + count +", result: " + i + ", response time: " + responseTime + ", request time: " + timed + ", use time: " + (responseTime - timed));
	             break; // 跳出循环，返回数据
	         } else { // 模拟没有数据变化，将休眠 hold住连接
	             Thread.sleep(1300);
	         }
	     }
	}
	
}
