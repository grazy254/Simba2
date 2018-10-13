package com.simba.controller.server.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.service.bean.MsgPostArgs;
import com.simba.service.impl.SendMsgServiceImpl;

/**
 * Created by linshuo on 2017/12/5.
 */
@RestController
@RequestMapping("/server/api/sendMsg")
public class SendMsgController {

	@Autowired
	private SendMsgServiceImpl sendMsgService;

	@RequestMapping("/send")
	public JsonResult send(HttpServletRequest request, MsgPostArgs msgPostArgs) {
		sendMsgService.checkAndSend(msgPostArgs, request.getRemoteAddr());
		return new JsonResult("发送成功");
	}

}
