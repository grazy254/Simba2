package com.simba.callback;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.simba.model.ShortMessage;
import com.simba.model.enums.SendStatus;
import com.simba.msg.interfaces.DealAliMsgCallback;
import com.simba.msg.model.SmsReport;
import com.simba.msg.model.SmsUp;
import com.simba.service.ShortMessageService;

/**
 * Created by linshuo on 2017/12/19.
 */
@Component
@Transactional
public class CallBackDealAliImpl implements DealAliMsgCallback {

	private static final Log logger = LogFactory.getLog(CallBackDealAliImpl.class);

	@Autowired
	private ShortMessageService shortMessageService;

	@Override
	public void dealReport(SmsReport smsReport) {
		boolean sendStatus = smsReport.isSuccess();
		ShortMessage shortMessage = shortMessageService.getBy("messageId", smsReport.getOut_id());
		if (sendStatus) {
			logger.info("收到阿里的短信回调," + smsReport.getOut_id() + "短信发送成功!");
			shortMessage.setStatus(SendStatus.SUCCESS.getId());
		} else {
			shortMessage.setStatus(SendStatus.FAIL.getId());
			logger.info("阿里短信错误代码:" + smsReport.getErr_code() + ":" + smsReport.getErr_msg());
		}
		shortMessageService.update(shortMessage);
	}

	@Override
	public void dealUp(SmsUp smsUp) {

	}
}
