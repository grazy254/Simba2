package com.simba.consumer;

import java.util.Date;

import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.simba.arg.EmailArgs;
import com.simba.consts.EmailConst;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.Email;
import com.simba.service.EmailService;
import com.simba.util.EmailUtil;

/**
 * rabbitmq的消费者
 * 
 * @author caozhejun
 *
 */
@Component
@RabbitListener(queues = EmailConst.QUEUE_EMAIL)
public class MessageReceiver {

	private static final Log logger = LogFactory.getLog(MessageReceiver.class);

	@Autowired
	@Qualifier("emailThreadPool")
	private ThreadPoolTaskExecutor threadPool;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private EmailService emailService;

	@RabbitHandler
	public void process(String recMsg) {
		logger.info("收到消息队列" + EmailConst.QUEUE_EMAIL + "的消息:" + recMsg);
		EmailArgs args;
		try {
			args = FastJsonUtil.toObject(recMsg, EmailArgs.class);
		} catch (Exception e) {
			logger.error("Email参数解析错误");
			return;
		}
		threadPool.execute(() -> {
			sendEmail(args);
		});
	}

	private void sendEmail(EmailArgs args) {
		boolean success = true;
		if (EmailConst.EMAIL_TYPE_TEXT.equals(args.getType())) {
			emailUtil.send(args.getToEmail(), args.getTitle(), args.getContent());
		} else if (EmailConst.EMAIL_TYPE_HTML.equals(args.getType())) {
			try {
				emailUtil.sendWithHtml(args.getToEmail(), args.getTitle(), args.getContent());
			} catch (MessagingException e) {
				logger.error("发送HTML格式邮件发生异常", e);
				success = false;
			}
		}
		if (success) {
			emailService.add(fromEmailArgs(args));
		}
	}

	private Email fromEmailArgs(EmailArgs args) {
		Email email = new Email();
		email.setAppid(args.getAppid());
		email.setContent(args.getContent());
		email.setTitle(args.getTitle());
		email.setToEmail(args.getToEmail());
		email.setType(args.getType());
		email.setCreateTime(new Date());
		return email;
	}

}
