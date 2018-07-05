package com.simba.msg.util;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

/**
 * 使用阿里云的消息服务发送手机短信的工具类(阿里云推出最新的短信服务，所以不再推荐使用此服务方式发送手机短信)
 * 
 * @author caozhejun
 *
 */
@Component
public class AliMessageService {

	private static final Log logger = LogFactory.getLog(AliMessageService.class);

	@Value("${aliyun.accessKeyId}")
	private String accessId;

	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;

	@Value("${aliyun.mns.endPoint}")
	private String endPoint;

	@Value("${aliyun.mns.top}")
	private String top;

	@Value("${aliyun.mns.sign}")
	private String sign;

	private CloudTopic topic;

	private MNSClient client;

	private boolean enabled = false;

	public boolean isEnabled() {
		return enabled;
	}

	@PostConstruct
	private void init() {
		if (StringUtils.isEmpty(accessId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(endPoint)) {
			return;
		}
		CloudAccount account = new CloudAccount(accessId, accessKeySecret, endPoint);
		client = account.getMNSClient();
		topic = client.getTopicRef(top);
		enabled = true;
	}

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNo
	 *            接收短信的手机号
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 */
	public void send(String mobileNo, String code, Map<String, String> params) {
		RawTopicMessage msg = new RawTopicMessage();
		msg.setMessageBody("sms-message");
		/**
		 * Step 3. 生成SMS消息属性
		 */
		MessageAttributes messageAttributes = new MessageAttributes();
		BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
		// 3.1 设置发送短信的签名（SMSSignName）
		batchSmsAttributes.setFreeSignName(sign);
		// 3.2 设置发送短信使用的模板（SMSTempateCode）
		batchSmsAttributes.setTemplateCode(code);
		// 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
		BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
		if (params != null && params.size() > 0) {
			params.forEach((key, value) -> {
				smsReceiverParams.setParam(key, value);
			});
		}
		// 3.4 增加接收短信的号码
		batchSmsAttributes.addSmsReceiver(mobileNo, smsReceiverParams);
		messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
		/**
		 * Step 4. 发布SMS消息
		 */
		TopicMessage ret = topic.publishMessage(msg, messageAttributes);
		logger.info("发送手机短信，返回消息ID" + ret.getMessageId());
	}

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNoList
	 *            接收短信的手机号列表
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 */
	public void send(List<String> mobileNoList, String code, Map<String, String> params) {
		RawTopicMessage msg = new RawTopicMessage();
		msg.setMessageBody("sms-message");
		/**
		 * Step 3. 生成SMS消息属性
		 */
		MessageAttributes messageAttributes = new MessageAttributes();
		BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
		// 3.1 设置发送短信的签名（SMSSignName）
		batchSmsAttributes.setFreeSignName(sign);
		// 3.2 设置发送短信使用的模板（SMSTempateCode）
		batchSmsAttributes.setTemplateCode(code);
		// 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
		BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
		if (params != null && params.size() > 0) {
			params.forEach((key, value) -> {
				smsReceiverParams.setParam(key, value);
			});
		}
		// 3.4 增加接收短信的号码
		mobileNoList.forEach((mobileNo) -> {
			batchSmsAttributes.addSmsReceiver(mobileNo, smsReceiverParams);
		});
		messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
		/**
		 * Step 4. 发布SMS消息
		 */
		TopicMessage ret = topic.publishMessage(msg, messageAttributes);
		logger.info("发送手机短信，返回消息ID" + ret.getMessageId());
	}

	@PreDestroy
	private void close() {
		client.close();
	}
}
