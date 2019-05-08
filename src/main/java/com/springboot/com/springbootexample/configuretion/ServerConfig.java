package com.springboot.com.springbootexample.configuretion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * 
* <p>Title: ServerConfig</p>  
* <p>Description: @ConfigurationProperties 通常情况下，将一组同样类型的配置属性映射为一个类更为方便，比如服务器配置，在
* 				application.properties中写成如下配置
* 				server.port=9090
* 				server.context-path=/config
*              以上属性都与Web服务器的配置相关都有server前缀，因此可以使用@ConfigurationProperties来获取这一组的实现
*              在处理@ConfigurationProperties注解的类的时候，自动会将“-”或者"_"去掉，转化为Java的命名规范如将context-path转换为contextPath
*              建议使用ConfigurationProperties而不是@Value
* </p>  
* @author daihu  
* @date 2019年5月7日
 */
@Configuration
@ConfigurationProperties("server")
public class ServerConfig {
	private int port;
	
	private String contextPath;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	
}
