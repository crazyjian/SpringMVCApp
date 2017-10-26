package com.jerry.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jerry.myapp.dao.UserMapper;
import com.jerry.myapp.model.User;
import com.jerry.myapp.service.UserService;

@Service("user2Service")
public class User2ServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
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
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		int j = 1/0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insert2(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		int j = 1/0;
	}

}
