package com.simba.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rabbitmq工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class RabbitMQUtil {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	/**
	 * 发送消息到队列中
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void sendMessage(String queueName, String message) {
		rabbitTemplate.convertAndSend(queueName, message);
	}

	/**
	 * 发送消息到交换器中(交换器可以绑定多个队列)
	 * 
	 * @param exchangeName
	 *            交换器名称
	 * @param message
	 *            消息内容
	 */
	public void sendMessageToExchange(String exchangeName, String message) {
		rabbitTemplate.convertAndSend(exchangeName, null, message);
	}

}
