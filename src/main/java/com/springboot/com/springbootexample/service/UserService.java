package com.springboot.com.springbootexample.service;

import com.springboot.com.springbootexample.entity.User;

public interface UserService {

	 User findUser(Long id);
	 
	 Long insertUser(User user);
	 
	 User findUserByNamed(Long id);
}
