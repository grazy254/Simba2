package com.simba.websocket.distributed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.simba.framework.distributed.ClusterExecute;
import com.simba.model.RealTimeMessage;
import com.simba.service.RealTimeMessageService;
import com.simba.websocket.UserIdConnectionPool;

/**
 * 用户实时推送消息的集群处理类
 * 
 * @author caozhejun
 *
 */
@Component
public class UserIdMessageClusterExecute implements ClusterExecute {

	private static final Log logger = LogFactory.getLog(UserIdMessageClusterExecute.class);

	@Autowired
	RealTimeMessageService realTimeMessageService;

	@Override
	public void execute(Object data) {
		if (!(data instanceof UserIdMessageData)) {
			throw new RuntimeException("类型错误：" + data.getClass().getCanonicalName());
		}
		logger.info("接收到集群处理消息:" + data.toString());
		logger.info("此服务器上连接的用户有******" + UserIdConnectionPool.getInstance().all().toString() + "******");
		UserIdMessageData messageData = (UserIdMessageData) data;
		String userId = messageData.getUserId();
		String content = messageData.getContent();
		String appid = messageData.getAppid();
		WebSocketSession session = UserIdConnectionPool.getInstance().get(userId, appid);
		if (session != null && session.isOpen()) {
			try {
				TextMessage text = new TextMessage(content);
				session.sendMessage(text);
				logger.info("接收到需要推送给用户[appid:" + appid + "][userId:" + userId + "]的内容:" + content + "[成功]");
				// 写入记录表中
				RealTimeMessage realTimeMessage = new RealTimeMessage();
				realTimeMessage.setUserId(Integer.valueOf(userId));
				realTimeMessage.setAppid(appid);
				realTimeMessage.setMessage(content);
				realTimeMessageService.add(realTimeMessage);
			} catch (Exception e) {
				logger.error("接收到需要推送给用户[appid:" + appid + "][userId:" + userId + "]的内容:" + content + "[异常]", e);
			}
		} else {
			logger.info("此服务器上连接的用户有******" + UserIdConnectionPool.getInstance().all().toString() + "******，没有用户:" + userId);
		}
	}

}
