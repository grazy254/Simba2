package com.simba.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.service.SendMsgService;

/**
 * 短信工具
 */
@Component
public class ShortMessageUtil {

	private final SendMsgService sendMsgService;

	@Autowired
	public ShortMessageUtil(SendMsgService sendMsgService) {
		this.sendMsgService = sendMsgService;
	}

	/**
	 * 发送短信 (不做校验)
	 *
	 * @param mobile
	 * @param selfTemplateId
	 * @param params
	 * @param projectId
	 */
	public void sendSimply(String mobile, String selfTemplateId, Map<String, String> params, String projectId) {
		sendMsgService.sendSimply(mobile, selfTemplateId, params, projectId);
	}

	/**
	 * 最单纯的发送, 不做任何记录操作
	 *
	 * @param mobile
	 * @param selfTemplateId
	 * @param params
	 */
	public void sendPure(String mobile, String selfTemplateId, Map<String, String> params) {
		sendMsgService.sendPure(mobile, selfTemplateId, params);
	}
}
