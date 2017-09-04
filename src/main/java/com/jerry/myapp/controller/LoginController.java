package com.jerry.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	public void login() {
		System.out.println("登录成功！");
	}
	
	public static void main(String args[]) {
		HashSet hs = new HashSet();
		hs.add(1);
		System.out.println(hs.add(2));
		HashMap hm = new HashMap();
		hm.put("a", 1);
		hm.put("a", 2);
		System.out.println(hm.get("a"));
	}
}
