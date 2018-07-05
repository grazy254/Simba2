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

	public void add(String userId, WebSocketSession session) {
		sessionMap.put(userId, session);
	}

	public void remove(String userId) {
		sessionMap.remove(userId);
	}

	public WebSocketSession get(String userId) {
		return sessionMap.get(userId);
	}

	public Set<String> all() {
		return sessionMap.keySet();
	}
}
