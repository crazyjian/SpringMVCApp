package com.jerry.myapp.service;

import java.util.List;

import com.jerry.myapp.model.User;

public interface UserService {

	public User findById(Integer id);
	
	public List<User> findAll();
	
	public void deleteById(Integer id);
	
	public User findByUserName(String name);
}
