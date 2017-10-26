package com.jerry.myapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate; 
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String isAuth(HttpServletRequest request,Model model,@ModelAttribute User user,
			@RequestParam(value = "check", required = false) String check,
			HttpSession session) {
		String username = request.getParameter("userName");  
	    String password = request.getParameter("password"); 
		 // 组装token，包括客户公司名称、简称、客户编号、用户名称；密码  
	    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	    if("yes".equals(check))
	    	token.setRememberMe(true); 
	    else
	    	token.setRememberMe(false); 
	    try {
	    logger.info("对用户[" + username + "]进行登录验证..验证开始"); 
		SecurityUtils.getSubject().login(token);
		logger.info("对用户[" + username + "]进行登录验证..验证通过");
	    }catch (UnknownAccountException ex) {
	    	model.addAttribute("msg", "用户不存在");
	        return "home";  
	    } catch (IncorrectCredentialsException ex) { 
	    	model.addAttribute("msg", "密码错误！");
	        return "home";  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        model.addAttribute("msg", "内部错误，请重试！");
	        return "home";  
	    }
	    User currentUser = userService.findByUserName(username);
	    session.setAttribute("user", currentUser);
		return "success";
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "home";
	}
	
}
