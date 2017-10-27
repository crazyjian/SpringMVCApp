package com.jerry.myapp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
		int i = 1/0;
	}

}
