package com.simba.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simba.consts.EmailConst;

/**
 * Created by shuoGG on 2018/9/25
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Queue emailQueue() {
		return new Queue(EmailConst.QUEUE_EMAIL);
	}

}
