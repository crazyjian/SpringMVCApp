package com.jerry.myapp.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.myapp.model.User;
import com.jerry.myapp.service.UserService;

public class SystemAuthorizingRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		
        //获取登录时输入的用户名  
        String loginName=(String) principals.fromRealm(getName()).iterator().next();  
        //到数据库查是否有此对象  
        User user=userService.findByUserName(loginName);  
        if(user!=null) {
        	//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
        	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(); 
        	info.addStringPermission("user:add");
        	info.addRole("admin");  
        	System.out.println("授权成功");
        	return info;
        }
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		   //UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;  
        //查出是否有此用户  
        User user=userService.findByUserName(token.getUsername());  
        if(user!=null){  
            //若存在，将此用户存放到登录认证info中  
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());  
        }  
        return null;
        
        
     /*   String username = (String)token.getPrincipal();  //得到用户名  
        String password = new String((char[])token.getCredentials()); //得到密码  
        if(!"zhang".equals(username)) {  
            throw new UnknownAccountException(); //如果用户名错误  
        }  
        if(!"123".equals(password)) {  
            throw new IncorrectCredentialsException(); //如果密码错误  
        }  
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
        return new SimpleAuthenticationInfo(username, password, getName()); */
	}

}
