package com.simba.service.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuoGG on 2018/7/24
 */
public class WsConnectionPool {
    private Map<String, WebSocketSession> sessionMap;

    private WsConnectionPool() {
        sessionMap = new HashMap<>();
    }

    private static final class WsConnectPoolHolder {
        private static final WsConnectionPool instance = new WsConnectionPool();
    }

    public static WsConnectionPool getInstance() {
        return WsConnectPoolHolder.instance;
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
