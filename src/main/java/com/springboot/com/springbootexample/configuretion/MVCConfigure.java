package com.springboot.com.springbootexample.configuretion;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.com.springbootexample.interceptor.SessionInterceptor;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;


/**
 * 
* <p>Title: MVCConfigure</p>  
* <p>Description: 拦截器的配置</p>  
* @author daihu  
* @date 2019年4月28日
 */
@Configuration
public class MVCConfigure implements WebMvcConfigurer {
	
	
	/**
	 * 拦截器
	 */
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/interceptor/**");
	}
	
	/**
	 * 跨域访问配置
	 */
	public void addCorsMappings(CorsRegistry registry) {
		//表明允许http://114.115.210.183来的POST或者GET方法访问所有的接口
		registry.addMapping("/**").allowedOrigins("http://114.115.210.183").allowedMethods("POST","GET");
	}
	
	/**
	 * URL到视图的映射可以不需要使用@RequestMapping来映射url直接在此方法中添加特殊的映射
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		//表示对testAddViewControllers.html的请求设置返回的视图为index.html
		registry.addViewController("/testAddViewControllers.html").setViewName("/index.html");
		//表示所有以.do结尾的请求都重定向到testAddViewControllers.html请求上去
		registry.addRedirectViewController("/**/*.do", "/testAddViewControllers.html");
	}
	
	/**
	 * 格式化将字符串转换成日期类型将Http请求映射到Controller方法的参数上，
	 * Spring会自动进行类型转化。对于日期类型的参数，Spring默认并没有配置如何将字符串转化为日期类型。
	 * 为了支持可按照指定格式转化为日期对象，需要添加一个DateFormat类：
	 */
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}

}
