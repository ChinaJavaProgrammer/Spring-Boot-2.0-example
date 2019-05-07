package com.springboot.com.springbootexample.configuretion;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 
* <p>Title: DataSourceConfig</p>  
* <p>Description:配置数据源 </p>  
* @author daihu  
* @date 2019年5月5日
 */
@Configuration
public class DataSourceConfig {
	
	@Bean("dataSource")
	public DataSource dataSource(Environment evn) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(evn.getProperty("spring.datasource.url"));
		ds.setUsername(evn.getProperty("spring.datasource.username"));
		ds.setPassword(evn.getProperty("spring.datasource.password"));
		ds.setDriverClassName(evn.getProperty("spring.datasource.driver-class-name"));
		return ds;
	}
}
