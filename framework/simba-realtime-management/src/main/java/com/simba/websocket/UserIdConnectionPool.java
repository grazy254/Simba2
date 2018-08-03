package com.simba.websocket;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

/**
 * 用户websocket连接Session对象池
 * 
 * @author caozhejun
 *
 */
public class UserIdConnectionPool {

	private Map<String, WebSocketSession> sessionMap;

	private UserIdConnectionPool() {
		init();
	}

	private void init() {
		sessionMap = new HashMap<>();
	}

	private static final class UserIdConnectionPoolHolder {
		private static final UserIdConnectionPool instance = new UserIdConnectionPool();
	}

	public static UserIdConnectionPool getInstance() {
		return UserIdConnectionPoolHolder.instance;
	}

	public void add(String userId, String appid, WebSocketSession session) {
		String key = buildKey(userId, appid);
		sessionMap.put(key, session);
	}

	private String buildKey(String userId, String appid) {
		String key = appid + "_" + userId;
		return key;
	}

	public void remove(String userId, String appid) {
		String key = buildKey(userId, appid);
		sessionMap.remove(key);
	}

	public WebSocketSession get(String userId, String appid) {
		String key = buildKey(userId, appid);
		return sessionMap.get(key);
	}

	public Set<String> all() {
		return sessionMap.keySet();
	}
}
