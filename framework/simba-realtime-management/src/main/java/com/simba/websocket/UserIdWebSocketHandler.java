package com.simba.websocket;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;

/**
 * 用户websocket连接处理类
 * 
 * @author caozhejun
 *
 */
public class UserIdWebSocketHandler implements WebSocketHandler {

	private static final Log logger = LogFactory.getLog(UserIdWebSocketHandler.class);

	private void setUserId(String userId, WebSocketSession session) {
		session.getAttributes().put("userId", userId);
		logger.info("设置连接用户[sid:" + session.getId() + "][userId:" + userId + "]");
	}

	private String getUserId(WebSocketSession session) {
		Map<String, Object> attributes = session.getAttributes();
		String userId = null;
		if (attributes == null) {
			logger.error("getUserId:没有session的attribute");
		} else {
			userId = (String) attributes.get("userId");
			logger.info("从session中获取userId[" + userId + "]");
		}
		logger.info("获取连接用户[" + session.getId() + "][" + userId + "]");
		return userId;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);
		String userId = getUserId(session);
		if (StringUtils.isNotEmpty(userId)) {
			UserIdConnectionPool.getInstance().add(userId, session);
			logger.info("用户连接Session保存成功[" + userId + "]");
		}
		logger.info("用户websocket连接成功sid:" + session.getId());
		// 连接断开后，统计当前在线用户+1
		redisUtil.getAutoId("onlineCount");
		logger.info("此服务器上连接的用户有******" + UserIdConnectionPool.getInstance().all().toString() + "******");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		Object payload = message.getPayload();
		if (payload == null) {
			logger.error("收到用户websocket消息，但是内容为空");
			return;
		}
		String content = payload.toString();
		logger.info("收到用户websocket消息:[" + content + "]");
		if (content.startsWith("userId:")) {
			String userId = content.split(":")[1];
			UserIdConnectionPool.getInstance().add(userId, session);
			logger.info("用户连接Session保存成功[" + userId + "]");
			setUserId(userId, session);
		} else {
			logger.error("收到用户websocket消息，但是内容格式错误:[" + content + "]");
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);
		String userId = getUserId(session);
		logger.error("用户websocket连接发生异常:" + userId, exception);
		if (StringUtils.isNotEmpty(userId)) {
			UserIdConnectionPool.getInstance().remove(userId);
			logger.info("清空websocket连接[userId:" + userId + "]");
		}
		// 连接断开后，统计当前离线用户+1
		redisUtil.getAutoId("offlineCount");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);
		String userId = getUserId(session);
		logger.info("用户websocket连接关闭:" + userId + "," + closeStatus);
		if (StringUtils.isNotEmpty(userId)) {
			UserIdConnectionPool.getInstance().remove(userId);
			logger.info("清空websocket连接[userId:" + userId + "]");
		}
		// 连接断开后，统计当前离线用户+1
		redisUtil.getAutoId("offlineCount");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
