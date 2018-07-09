package com.simba.controller.user;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.ReceiveMsg;
import com.simba.model.constant.ConstantData;
import com.simba.service.ReceiveMsgService;

/**
 * 接收设备消息的controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/user/receiveMessage")
public class ReceiveUserMsgController {

	private static final Log logger = LogFactory.getLog(ReceiveUserMsgController.class);

	@Autowired
	private ReceiveMsgService service;

	/**
	 * 接收设备消息
	 * 
	 * @param msg
	 * @return
	 */
	@RequestMapping("/receive")
	public JsonResult receive(ReceiveMsg msg, HttpServletRequest request) {
		if (StringUtils.isEmpty(msg.getMessage())) {
			InputStream in = null;
			try {
				in = request.getInputStream();
				String json = IOUtils.toString(in, ConstantData.DEFAULT_CHARSET);
				logger.info("*********************接收到Erlang服务器发来的消息From Body:" + json + "**********");
				msg.setMessage(json);
			} catch (Exception e) {
				logger.error("处理接收到的Erlang服务器信息异常", e);
			} finally {
				IOUtils.closeQuietly(in);
			}
		}
		Object result = service.add(msg);
		return new JsonResult(result);
	}

}