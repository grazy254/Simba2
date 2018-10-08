package com.simba.controller.server.api;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
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
@RequestMapping("/server/api/realTimeMessage")
public class SendRealTimeMessageController {

	private static final Log logger = LogFactory.getLog(SendRealTimeMessageController.class);

	@Autowired
	private DistributedUtil distributedUtil;

	@Resource
	private TaskExecutor taskExecutor;

	/**
	 * 根据用户ID推送实时消息
	 * 
	 * @param userId
	 * @param content
	 * @param appid
	 * 
	 * @return
	 */
	@RequestMapping("/send")
	public JsonResult send(String userId, String content, String appid) {
		logger.info("接收到需要推送给用户[appid:" + appid + "][userId:" + userId + "]的内容:" + content);
		sendInCluster(userId, content, appid);
		return new JsonResult();
	}

	private void sendInCluster(String userId, String content, String appid) {
		UserIdMessageData data = new UserIdMessageData();
		data.setContent(content);
		data.setUserId(userId);
		data.setAppid(appid);
		distributedUtil.executeInCluster(new ClusterMessage(UserIdMessageClusterExecute.class.getCanonicalName(), data));
	}
}
