package com.springboot.com.springbootexample.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
* <p>Title: PowerAspect</p>  
* <p>Description: 自定义注解通过Spring的AOP进行操作</p>  
* @author daihu  
* @date 2019年4月23日
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PowerAspect {

	
	String value() default "";
}
