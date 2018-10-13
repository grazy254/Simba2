package com.simba.controller.server.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.ReceiveMsg;
import com.simba.service.ReceiveMsgService;

/**
 * 用来接收转发请求的Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/server/api/switch")
public class SwitchController {

	private static final Log logger = LogFactory.getLog(SwitchController.class);

	@Autowired
	private ReceiveMsgService receiveMsgServe;

	/**
	 * 接受消息，然后根据类型转发
	 * 
	 * @param msg
	 * @return
	 */
	@RequestMapping("/receive")
	public JsonResult receive(ReceiveMsg msg) {
		logger.info("接收到需要转发到消息:" + msg.toString());
		Object result = receiveMsgServe.add(msg);
		return new JsonResult(result);
	}

}
