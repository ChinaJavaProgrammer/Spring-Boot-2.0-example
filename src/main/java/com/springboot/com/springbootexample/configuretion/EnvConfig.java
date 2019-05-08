package com.springboot.com.springbootexample.configuretion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 
* <p>Title: EnvConfig</p>  
* <p>Description: Environment是一个通用的读取应用程序运行时的环境变量的类，可以读取application.properties、
* 				 命令行输入参数、系统属性、操作系统环境变量等。可以通过Spring 容器自动注入比如在Spring管理的Bean中，
* 				Environment是Spring Boot中最早初始化的一个类，因此可以用在Spring应用的任何地方
* </p>  
* @author daihu  
* @date 2019年5月7日
 */
@Configuration
public class EnvConfig {
	
	
	@Autowired
	Environment environment;
	
	/**
	 * 读取server.port，来之application.properties
	 * @return
	 */
	public int getServerPort() {
		return environment.getProperty("server.port", Integer.class);
	}
	
	/**
	 * 读取设置的环境变量（不区分大小写）
	 * @return
	 */
	public String getJavaHome() {
		return environment.getProperty("JAVA_HOME");
	}
	/**
	 * 获取程序运行的目录，如果在IDE中运行，就是工作目录，user.dir是系统属性
	 * @return
	 */
	public String getUserDir() {
		return environment.getProperty("user.dir");
	}
	
	/**
	 * 执行程序的用户的home目录，user.home是系统属性
	 * @return
	 */
	public String getUserHome() {
		return environment.getProperty("user.home");
	}
}
