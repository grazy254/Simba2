package com.simba.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.simba.framework.distributed.ClusterMessage;
import com.simba.framework.distributed.DistributedUtil;
import com.simba.framework.util.common.ThreadUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.RealTimeMessage;
import com.simba.service.RealTimeMessageService;
import com.simba.websocket.UserIdConnectionPool;
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

	@Autowired
	private RealTimeMessageService realTimeMessageService;

	@Resource
	private TaskExecutor taskExecutor;

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
		WebSocketSession session = UserIdConnectionPool.getInstance().get(userId);
		if (session != null && session.isOpen()) {
			try {
				TextMessage text = new TextMessage(content);
				session.sendMessage(text);
				logger.info("发送websocket消息给用户[" + userId + "][" + content + "]成功");
				// 写入记录表中
				RealTimeMessage realTimeMessage = new RealTimeMessage();
				realTimeMessage.setUserId(Integer.valueOf(userId));
				realTimeMessage.setMessage(content);
				realTimeMessageService.add(realTimeMessage);
			} catch (Exception e) {
				logger.error("发送websocket消息给用户[" + userId + "][" + content + "]发送异常", e);
				logger.info("=================================重新推送一次消息给用户=======================");
				taskExecutor.execute(() -> {
					ThreadUtil.sleep(500);
					UserIdMessageData data = new UserIdMessageData();
					data.setContent(content);
					data.setUserId(userId);
					distributedUtil.executeInCluster(new ClusterMessage(UserIdMessageClusterExecute.class.getCanonicalName(), data));
				});
			}
		} else {
			UserIdMessageData data = new UserIdMessageData();
			data.setContent(content);
			data.setUserId(userId);
			distributedUtil.executeInCluster(new ClusterMessage(UserIdMessageClusterExecute.class.getCanonicalName(), data));
		}
		return new JsonResult();
	}
}
