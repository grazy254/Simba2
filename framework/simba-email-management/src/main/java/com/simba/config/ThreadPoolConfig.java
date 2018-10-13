package com.simba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by shuoGG on 2018/9/26
 */
@Configuration
public class ThreadPoolConfig {

	@Bean
	public ThreadPoolTaskExecutor emailThreadPool() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		threadPool.setCorePoolSize(40);
		threadPool.setMaxPoolSize(100);
		threadPool.setQueueCapacity(500);
		return threadPool;
	}
}
