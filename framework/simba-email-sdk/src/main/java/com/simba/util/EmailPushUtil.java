package com.simba.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.simba.arg.EmailArgs;
import com.simba.consts.EmailConst;
import com.simba.framework.util.json.FastJsonUtil;

/**
 * Created by shuoGG on 2018/9/26
 */
@Component
public class EmailPushUtil {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${spring.application.name:simba}")
	private String appName;

	/**
	 * 发送邮件(MQ)
	 *
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param toEmail
	 *            目的
	 */
	public void send(String title, String content, String toEmail) {
		EmailArgs args = buildEmailArgs(title, content, toEmail, EmailConst.EMAIL_TYPE_TEXT);
		send(args);
	}

	public void send(String title, String content, String toEmail, String type) {
		EmailArgs args = buildEmailArgs(title, content, toEmail, type);
		send(args);
	}

	private EmailArgs buildEmailArgs(String title, String content, String toEmail, String type) {
		EmailArgs args = new EmailArgs();
		args.setAppid(appName);
		args.setTitle(title);
		args.setContent(content);
		args.setToEmail(toEmail);
		args.setType(type);
		return args;
	}

	public void send(EmailArgs args) {
		rabbitTemplate.convertAndSend(EmailConst.QUEUE_EMAIL, FastJsonUtil.toJson(args));
	}

}
