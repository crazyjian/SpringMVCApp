package com.jerry.myapp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jerry.myapp.dao.UserMapper;
import com.jerry.myapp.model.User;
import com.jerry.myapp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("user2Service")
	private UserService user2Service;
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}
	
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
	public void deleteById(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	public User findByUserName(String name) {
		return userMapper.selectByUserName(name);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insert(User user) {
		// TODO Auto-generated method stub
		
		userMapper.insert(user);
		user.setId(6);
		user2Service.insert2(user);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insert2(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		
	}

}
