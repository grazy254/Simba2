package com.simba.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	private Map<String, Map<String, WebSocketSession>> sessionMap;

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
		Map<String, WebSocketSession> userSessions = sessionMap.get(key);
		if (userSessions == null) {
			userSessions = new HashMap<>();
		}
		userSessions.put(session.getId(), session);
		sessionMap.put(key, userSessions);
	}

	private String buildKey(String userId, String appid) {
		String key = appid + "_" + userId;
		return key;
	}

	public void remove(String userId, String appid, WebSocketSession session) {
		String key = buildKey(userId, appid);
		Map<String, WebSocketSession> userSessions = sessionMap.get(key);
		if (userSessions != null) {
			userSessions.remove(session.getId());
			sessionMap.put(key, userSessions);
		}
	}

	public List<WebSocketSession> get(String userId, String appid) {
		String key = buildKey(userId, appid);
		Map<String, WebSocketSession> userSessions = sessionMap.get(key);
		List<WebSocketSession> sessions = new ArrayList<>();
		if (userSessions != null) {
			sessions.addAll(userSessions.values());
		}
		return sessions;
	}

	public Set<String> all() {
		return sessionMap.keySet();
	}
}
