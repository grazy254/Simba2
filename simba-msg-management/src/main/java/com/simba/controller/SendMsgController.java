package com.simba.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.mobile.message.model.MsgType;
import com.simba.model.enums.SendStatus;
import com.simba.model.other.MsgPostArgs;
import com.simba.service.MsgTemplateService;
import com.simba.service.DO.EntryPlatform;
import com.simba.service.impl.SendMsgServiceImpl;

/**
 * Created by linshuo on 2017/12/5.
 */
@Controller
@RequestMapping("sendMsg")
public class SendMsgController {

	@Autowired
	private MsgTemplateService templateService;

	@Autowired
	private SendMsgServiceImpl sendMsgService;

	@RequestMapping("/send")
	@ResponseBody
	public JsonResult send(HttpServletRequest request, MsgPostArgs msgPostArgs) {
		JsonResult result = new JsonResult();
		String messageId = null;
		SendStatus sendStatus = null;
		// 获取任意一个有效的平台+对应平台的真实模板Id
		EntryPlatform platform = templateService.getOnePlatformTemplateId(msgPostArgs.getTemplateSelfId());
		if (platform == null) {
			result.setCode(JsonResult.failCode);
			result.setMsg("模板Id有误");
			return result;
		}
		String platformTemplateId = platform.getTemplateId();
		MsgType platformType = platform.getPlaformType();
		// 校验密文
		if (sendMsgService.checkSecret(msgPostArgs)) {
			Map<String, String> values = FastJsonUtil.toObject(msgPostArgs.getValues(), Map.class);
			List<String> mobileList = FastJsonUtil.toObject(msgPostArgs.getMobileList(), List.class);
			messageId = sendMsgService.sendMsgWithCheck(mobileList, platformTemplateId, values, platformType, Integer.valueOf(msgPostArgs.getProjectId()), request);
			if (StringUtils.isEmpty(messageId)) { // 校验不通过
				result.setCode(JsonResult.failCode);
				result.setMsg("短信发送失败");
				sendStatus = SendStatus.FAIL;
				// 将短信的信息保存起来
				sendMsgService.addShortMessage(msgPostArgs, DateUtil.getTime(), sendStatus, platformType, "");
			} else { // 校验通过
				if (messageId.equals(SendMsgServiceImpl.MULTI_SEND_ID)) { // 群发没有返回MsgId,
																			// 所以只能直接置为发送成功
					sendStatus = SendStatus.SUCCESS;
				} else {
					sendStatus = SendStatus.UNKNOWN;
				}
				result.setCode(JsonResult.successCode);
				// 将短信的信息保存起来
				sendMsgService.addShortMessage(msgPostArgs, DateUtil.getTime(), sendStatus, platformType, messageId);
			}
		} else {
			// 校验不通过
			result.setCode(JsonResult.failCode);
			result.setMsg("检验失败");
			return result;
		}
		return result;
	}

}
