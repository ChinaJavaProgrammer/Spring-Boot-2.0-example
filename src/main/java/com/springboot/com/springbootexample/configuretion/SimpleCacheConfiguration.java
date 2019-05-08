package com.springboot.com.springbootexample.configuretion;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.autoconfigure.cache.CacheCondition;

/**
 * 
* <p>Title: SimpleCacheConfiguration</p>  
* <p>Description:  联合多个条件以Spring Boot Cache为例（支持多种缓存实现，如SimpleCache，可以使用HashMap实现
* 					还可以是分布式的Redis实现方式。无论哪种实现方式，只需要配置好CacheManager--缓存的抽象管理类
* 					。对应于SimpleCache，是ConcurrentMapCacheManager实现；对应于Redis缓存，是RedisCacheManager的实现
* 					以下类是SimpleCacheCoonfiguration的自动装配
* 					如果需要扩展自己的装配可实现Condition接口来实现
* ）</p>  
* @author daihu  
* @date 2019年5月7日
 */
@Configuration
@ConditionalOnMissingBean(CacheManager.class)
//@Conditional(CacheCondition.class)
public class SimpleCacheConfiguration {
	
	@Bean
	public ConcurrentMapCacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
		//忽略其他配置代码
		return cacheManager;
	}
}
