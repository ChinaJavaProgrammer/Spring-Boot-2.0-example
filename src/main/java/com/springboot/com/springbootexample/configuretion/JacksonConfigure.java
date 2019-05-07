package com.springboot.com.springbootexample.configuretion;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
* <p>Title: JacksonConfigure</p>  
* <p>Description:自定义Jackson 通过此配置当序列化JSON的时候不会按照默认配置而是按照自定义配置序列化</p>  
* @author daihu  
* @date 2019年4月29日
 */
@Configuration
public class JacksonConfigure {
	
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return mapper;
	}
}
