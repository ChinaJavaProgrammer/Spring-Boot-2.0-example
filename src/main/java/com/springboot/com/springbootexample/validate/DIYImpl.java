package com.springboot.com.springbootexample.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.com.springbootexample.annotation.DIYValidate;

/**
 * 
* <p>Title: DIYImpl</p>  
* <p>Description: 实现自定义验证注解验证</p>  
* @author daihu  
* @date 2019年4月25日
 */
public class DIYImpl implements ConstraintValidator<DIYValidate, String> {
	DIYValidate diyValidate;
	String test;
	public void initialize(DIYValidate context) {
		this.diyValidate=context;
		test = context.must();
	}
	@Override
	public boolean isValid(String must, ConstraintValidatorContext context) {
		if(must==null) {
			return true;
		}
		return test.equals(must);
	}
}
