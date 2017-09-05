package com.jerry.myapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jerry.myapp.common.UserFactoryBean;
import com.jerry.myapp.model.User;
import com.jerry.myapp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		logger.info("登录用户主页");
		return "home";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String isLogin(User User) {
		
		return "success";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE ,produces="application/json;charset=UTF-8")
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
