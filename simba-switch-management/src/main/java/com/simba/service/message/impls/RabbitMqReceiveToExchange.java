package com.simba.service.message.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;
import com.simba.rabbitmq.RabbitMQUtil;

/**
 * 将收到的数据发送到rabbitmq的交换器exchange中
 * 
 * @author caozhejun
 *
 */
@Service
public class RabbitMqReceiveToExchange implements ReceiveDealInterface {

	@Autowired
	private RabbitMQUtil rabbitMQUtil;

	@Override
	public Object deal(ReceiveMsg msg, ReceiveDealType type) {
		String message = msg.getMessage();
		String ext = type.getExt();
		rabbitMQUtil.sendMessageToExchange(ext, message);
		return null;
	}

}
