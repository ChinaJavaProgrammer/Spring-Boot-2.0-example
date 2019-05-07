package com.springboot.com.springbootexample.serviceImpl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.com.springbootexample.annotation.PowerAspect;
import com.springboot.com.springbootexample.dao.UserDao;
import com.springboot.com.springbootexample.dao.UserDaoNamed;
import com.springboot.com.springbootexample.entity.User;
import com.springboot.com.springbootexample.service.UserService;
import com.sun.xml.internal.ws.developer.Serialization;

/**
 * @Transactional声明式事务管理
* <p>Title: UserServiceImpl</p>  
* <p>Description: </p>  
* @author daihu  
* @date 2019年5月5日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private UserDaoNamed userDaoNamed;
	
	@PostConstruct
	public void init() {
		System.out.println("bean 正在被初始化 ："+this);
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("bean 在销毁之前进行的操作 ："+this);
	}


	@Override
	public User findUser(Long id) {
		return userdao.getUser(id);
	}


	@Override
	public Long insertUser(User user) {
		return userdao.inserUser(user);
	}


	@Override
	public User findUserByNamed(Long id) {
		return userDaoNamed.getUser(id);
	}
}
