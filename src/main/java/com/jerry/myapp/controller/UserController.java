package com.jerry.myapp.controller;

import java.lang.reflect.Proxy;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jerry.myapp.model.User;
import com.jerry.myapp.proxy.MyInvocationHandler;
import com.jerry.myapp.service.UserService;
import com.jerry.myapp.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/")
	public String user(Model model) {
		List<User> list = userService.findAll();
		for(User user : list) {
			logger.info("用户姓名："+user.getRealName());
		}
		model.addAttribute("userList", list);
		User user = userService.findById(1);
		user.setRealName("service1");
		userService.update(user);
		return "user";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object deleteById(@PathVariable("id") int id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userService.deleteById(id);
			jsonObject.put("msg", "删除人员信息成功");
		}catch(Exception e) {
			jsonObject.put("msg", "删除人员信息失败");
		}
		return jsonObject;
	}
	
}
