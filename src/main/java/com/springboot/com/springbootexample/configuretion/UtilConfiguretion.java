package com.springboot.com.springbootexample.configuretion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.com.springbootexample.util.CommonsUtils;

/**
 * 
* <p>Title: UtilConfiguretion</p>  
* <p>Description: 配置类</p>  
* @author daihu  
* @date 2019年4月23日
 */
@Configuration  
public class UtilConfiguretion {
	
	
	
	/**
	 * 通过Spring的Bean注解注入对象
	 * @return
	 */
	@Bean("commonsUtils")
	public CommonsUtils commonsUtils() {
		return new CommonsUtils();
	}
}
