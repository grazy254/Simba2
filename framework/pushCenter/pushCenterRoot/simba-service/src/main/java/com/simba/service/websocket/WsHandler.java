package com.simba.service.websocket;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;

/**
 * Created by shuoGG on 2018/7/24
 */
public class WsHandler implements WebSocketHandler {

    private static final Log logger = LogFactory.getLog(WsHandler.class);

    private static final WsConnectionPool wsPool = WsConnectionPool.getInstance();

    private static final RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);

    /* Redis key */
    private static final String REDIS_KEY_ONLINE = "wsOnlineCount";
    private static final String REDIS_KEY_OFFLINE = "wsOfflineCount";


    private String getUserId(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        if (attributes != null) {
            return (String) attributes.get("userId");
        } else {
            logger.error("WebSocket: session中无userId");
            return null;
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String userId = getUserId(session);
        if (StringUtils.isNotEmpty(userId)) {
            wsPool.add(userId, session);
        }
        long newCount = redisUtil.getAutoId(REDIS_KEY_ONLINE);
        logger.info("Websocket: 用户" + userId + "连接创建成功, 当前在线人数:" + newCount);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        String content = (String) message.getPayload();
        String userId = getUserId(session);
        logger.info("Websocket: 收到来自用户" + userId + "消息:" + content);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        String userId = getUserId(session);
        logger.error("Websocket: 用户连接发生异常:" + userId, exception);
        redisUtil.getAutoId(REDIS_KEY_OFFLINE);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        String userId = getUserId(session);
        logger.info("Websocket: " + userId + "用户的连接关闭," + closeStatus);
        if (StringUtils.isNotEmpty(userId)) {
            wsPool.remove(userId);
        }
        redisUtil.getAutoId(REDIS_KEY_OFFLINE);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
