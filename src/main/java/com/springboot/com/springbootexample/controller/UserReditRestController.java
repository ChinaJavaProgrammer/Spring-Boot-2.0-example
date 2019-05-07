package com.springboot.com.springbootexample.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.com.springbootexample.annotation.PowerAspect;
import com.springboot.com.springbootexample.service.UserService;
import com.springboot.com.springbootexample.util.CommonsUtils;

/**
 * 
* <p>Title: UserReditRestController</p>  
* <p>Description: 添加REST支持</p>  
* @author daihu  
* @date 2019年4月18日
 */
@RestController
public class UserReditRestController {
	
	private @Autowired CommonsUtils commonsUtils;
	
	private @Resource UserService userService;
	@RequestMapping("/usercredit/{id}/{name}")
	@PowerAspect("test")  //自定义注解和Spring的AOP配合使用可做权限拦截
	public Integer getCreditLevel(@PathVariable String id,@PathVariable String name) {
		commonsUtils.test();
		System.out.println(name);
		return Integer.parseInt(id);
	}
}
