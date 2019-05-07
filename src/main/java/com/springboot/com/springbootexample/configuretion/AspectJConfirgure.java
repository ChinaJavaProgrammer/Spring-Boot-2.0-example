package com.springboot.com.springbootexample.configuretion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.springboot.com.springbootexample.annotation.PowerAspect;

/**
 * 
* <p>Title: AspectJConfirgure</p>  
* <p>Description:AOP的使用 </p>  
* @author daihu  
* @date 2019年4月18日
 */
@Configuration
@Aspect //表明这是一个Aspect的配置类
public class AspectJConfirgure {
	
	@Around("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(aspect)")
	public Object simpleAspect(final ProceedingJoinPoint joinPoint,PowerAspect aspect) throws Throwable {
			
		if(aspect.value().equals("test")) {
			return null;
		}else {
			Object o = joinPoint.proceed();
			return o;
		}
	
	}
}
