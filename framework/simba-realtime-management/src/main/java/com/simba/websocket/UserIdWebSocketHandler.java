package com.simba.websocket;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.util.OnlineUserUtil;

/**
 * 用户websocket连接处理类
 * 
 * @author caozhejun
 *
 */
public class UserIdWebSocketHandler implements WebSocketHandler {

	private static final Log logger = LogFactory.getLog(UserIdWebSocketHandler.class);

	private static final Set<String> onlineSet = Collections.synchronizedSet(new HashSet<>());

	private void addOnlineUser(String appid, String userId) throws UnknownHostException {
		String key = appid + "_" + userId;
		if (onlineSet.add(key)) {
			OnlineUserUtil onlineUserUtil = ApplicationContextUtil.getBean(OnlineUserUtil.class);
			onlineUserUtil.incrOnlineUser(appid);
		}
	}

	private void addOfflineUser(String appid, String userId) throws UnknownHostException {
		String key = appid + "_" + userId;
		if (onlineSet.contains(key)) {
			OnlineUserUtil onlineUserUtil = ApplicationContextUtil.getBean(OnlineUserUtil.class);
			onlineUserUtil.incrOfflineUser(appid);
			onlineSet.remove(key);
		}
	}

	private void set(String userId, String appid, WebSocketSession session) {
		session.getAttributes().put("userId", userId);
		session.getAttributes().put("appid", appid);
		logger.info("设置连接用户[sid:" + session.getId() + "][userId:" + userId + "][appid:" + appid + "]");
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

	private String getAppid(WebSocketSession session) {
		Map<String, Object> attributes = session.getAttributes();
		String appid = null;
		if (attributes == null) {
			logger.error("getAppid:没有session的attribute");
		} else {
			appid = (String) attributes.get("appid");
			logger.info("从session中获取appid[" + appid + "]");
		}
		logger.info("获取连接应用[" + session.getId() + "][" + appid + "]");
		return appid;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = getUserId(session);
		String appid = getAppid(session);
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(appid)) {
			UserIdConnectionPool.getInstance().add(userId, appid, session);
			logger.info("用户连接Session保存成功[userId:" + userId + "][appid:" + appid + "]");
			addOnlineUser(appid, userId);
		}
		logger.info("用户websocket连接成功sid:" + session.getId());
		logger.info("此服务器上连接的用户有******" + UserIdConnectionPool.getInstance().all().toString() + "******");
	}

	/**
	 * userId:1,appid:smarthome or userId:1
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		Object payload = message.getPayload();
		if (payload == null) {
			logger.error("收到用户websocket消息，但是内容为空");
			return;
		}
		String content = payload.toString();
		if (StringUtils.isEmpty(content)) {
			logger.error("收到用户websocket消息，但是内容为空");
			return;
		}
		logger.info("收到用户websocket消息:[" + content + "]");
		if (content.startsWith("userId:")) {
			String[] data = content.split(",");
			String userId = data[0].split(":")[1];
			String appid = null;
			if (data.length > 1) {
				appid = data[1].split(":")[1];
			} else {
				appid = "default";
			}
			UserIdConnectionPool.getInstance().add(userId, appid, session);
			logger.info("用户连接Session保存成功[userId:" + userId + "][appid:" + appid + "]");
			set(userId, appid, session);
			addOnlineUser(appid, userId);
		} else {
			logger.error("收到用户websocket消息，但是内容格式错误:[" + content + "]");
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		String userId = getUserId(session);
		String appid = getAppid(session);
		logger.error("用户websocket连接发生异常:[userId:" + userId + "][appid:" + appid + "]", exception);
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(appid)) {
			UserIdConnectionPool.getInstance().remove(userId, appid);
			logger.info("清空websocket连接[userId:" + userId + "][appid:" + appid + "]");
			addOfflineUser(appid, userId);
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		String userId = getUserId(session);
		String appid = getAppid(session);
		logger.info("用户websocket连接关闭:[userId:" + userId + "][appid:" + appid + "]," + closeStatus);
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(appid)) {
			UserIdConnectionPool.getInstance().remove(userId, appid);
			logger.info("清空websocket连接[userId:" + userId + "][appid:" + appid + "]");
			addOfflineUser(appid, userId);
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
