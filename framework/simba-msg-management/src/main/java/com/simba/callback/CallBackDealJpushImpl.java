package com.simba.callback;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.jpush.msg.interfaces.CallbackDealInterface;
import com.simba.jpush.msg.model.ReceiveMsg;
import com.simba.jpush.msg.model.SendResult;
import com.simba.jpush.msg.model.TemplateAuditResult;
import com.simba.model.MsgTemplate;
import com.simba.model.ShortMessage;
import com.simba.model.enums.AuditStatus;
import com.simba.model.enums.SendStatus;
import com.simba.service.MsgTemplateService;
import com.simba.service.ShortMessageService;

/**
 * Created by linshuo on 2017/12/19. 极光短信的回调实现
 */
@Component
public class CallBackDealJpushImpl implements CallbackDealInterface {

	/* 审核通过 */
	private static final int APPROVAL = 1;
	/* 审核未通过 */
	private static final int UNAPPROVAL = 2;
	/* 发送成功 */
	private static final int SEND_OK = 4001;

	private static final Log logger = LogFactory.getLog(CallBackDealJpushImpl.class);

	@Autowired
	private ShortMessageService shortMessageService;

	@Autowired
	private MsgTemplateService templateService;

	@Override
	public void sendResult(SendResult sendResult) {
		int sendStatus = sendResult.getStatus();
		List<ShortMessage> msgList = shortMessageService.listBy("messageId", sendResult.getMsgId());
		if (msgList.size() == 0) {
			return;
		}
		ShortMessage shortMessage = msgList.get(0);
		if (sendStatus == SEND_OK) {
			shortMessage.setStatus(SendStatus.SUCCESS.getId());
			logger.info("收到极光的短信回调," + sendResult.getMsgId() + "短信发送成功!");
		} else {
			shortMessage.setStatus(SendStatus.FAIL.getId());
			logger.info("收到极光的短信回调,短信发送失败," + SendStatus.JPUSH_STATUS.get(sendStatus));
		}
		shortMessageService.update(shortMessage);
	}

	@Override
	public void receiveMsg(ReceiveMsg receiveMsg) {

	}

	@Override
	public void templateAuditResult(TemplateAuditResult templateAuditResult) {
		MsgTemplate template = templateService.getBy("jpushTemplateId", templateAuditResult.getTempId());
		int auditStatus = templateAuditResult.getStatus();
		if (auditStatus == APPROVAL) {
			logger.info("收到极光的短信模板审核回调," + templateAuditResult.getTempId() + "审核通过!");
			template.setStatusJpush(AuditStatus.APPROVAL.getId());
		} else if (auditStatus == UNAPPROVAL) {
			logger.info("收到极光的短信模板审核回调," + templateAuditResult.getTempId() + "审核不通过!");
			template.setStatusJpush(AuditStatus.UNAPPROVAL.getId());
		}
		templateService.update(template);
	}
}
