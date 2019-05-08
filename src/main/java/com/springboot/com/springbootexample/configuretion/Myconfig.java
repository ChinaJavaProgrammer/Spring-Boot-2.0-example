package com.springboot.com.springbootexample.configuretion;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.system.JavaVersion;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.springboot.com.springbootexample.util.CommonsUtils;

/**
 * 
* <p>Title: Myconfig</p>  
* <p>Description:Spring Boot的自动装配Spring提供了 @Configuration用来配置多个Bean
* 								@ConditionalOnBean(DataSource.class)表示当上下文存在DataSource时才会实例化一个Bean
* 								@ConditionalOnMissingBean(DataSource.class)表示上下文不存在DataSource对象时才会实例化一个Bean
* 								@ConditionalOnClass(DataSource.class)Class条件装配是按照某一个类是否存在Classpath中来决定是否要配置Bean
* 								试用与ElastSearch，使用Jest驱动，因此配置生效的前提条件是classpath有JestClient.class类
* 								@ConditionalOnProperty(name="message.center.enabled",havingValue="true",matchIfMissing=true)环境装配
* 								根据name来读取SpringBoot的Environment的变量包含的熟悉，根据其值与havingValue的值作比较是否生效
*								 matchIfMissing=true为true意味着即使没有包含这个值也生效
*								@ConditionalOnExpression 其他条件的装配 当表达式为true时生效
*								@ConditionalOnJava(range=Range.EQUAL_OR_NEWER,value=JavaVersion.EIGHT)其他条件的装配 当java的版本为多少是生效
*	  联合多个条件
* </p>  
* @author daihu  
* @date 2019年5月7日
 */
//@ConditionalOnBean(DataSource.class)
//@ConditionalOnMissingBean(DataSource.class)
//@ConditionalOnClass(DataSource.class)
//@ConditionalOnProperty(name="message.center.enabled",havingValue="true",matchIfMissing=true)
//@ConditionalOnExpression
//@ConditionalOnJava(range=Range.EQUAL_OR_NEWER,value=JavaVersion.EIGHT)
@Configuration
public class Myconfig {
	
	
	/**
	 * 如果填写name属性则默认注册Bean的名称为方法名
	 * @return
	 */
	@Bean(name="commonsUtils")
	public CommonsUtils getCommonsUtils() {
		return new CommonsUtils();
	}
}
