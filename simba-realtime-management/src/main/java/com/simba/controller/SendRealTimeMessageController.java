package com.simba.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.distributed.ClusterMessage;
import com.simba.framework.distributed.DistributedUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.websocket.distributed.UserIdMessageClusterExecute;
import com.simba.websocket.distributed.UserIdMessageData;

/**
 * 发送实时信息推送Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/sendRealTimeMessage")
public class SendRealTimeMessageController {

	private static final Log logger = LogFactory.getLog(SendRealTimeMessageController.class);

	@Autowired
	private DistributedUtil distributedUtil;

	/**
	 * 根据用户ID推送实时消息
	 * 
	 * @param userId
	 * @param content
	 * @return
	 */
	@RequestMapping("/sendByUserId")
	public JsonResult sendByUserId(String userId, String content) {
		logger.info("接收到需要推送给用户[" + userId + "]的内容:" + content);
		UserIdMessageData data = new UserIdMessageData();
		data.setContent(content);
		data.setUserId(userId);
		distributedUtil.executeInCluster(new ClusterMessage(UserIdMessageClusterExecute.class.getCanonicalName(), data));
		return new JsonResult();
	}
}
