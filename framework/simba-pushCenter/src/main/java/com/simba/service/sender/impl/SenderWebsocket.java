package com.simba.service.sender.impl;

import com.simba.consts.PushType;
import com.simba.service.sender.ISender;
import com.simba.service.websocket.WsConnectionPool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by shuoGG on 2018/7/24
 */
@Component(PushType.WEBSOCKET)
public class SenderWebsocket implements ISender {

    private static final Log logger = LogFactory.getLog(SenderWebsocket.class);

    @Override
    public void send(Long userId, String content) {
        WsConnectionPool pool = WsConnectionPool.getInstance();
        WebSocketSession session = pool.get(String.valueOf(userId));
        if (session != null && session.isOpen()) {
            TextMessage text = new TextMessage(content);
            try {
                session.sendMessage(text);
            } catch (IOException e) {
                logger.error("ws推送IO错误", e);
            }
        } else {
            logger.warn("用户" + userId + "ws连接未打开");
        }
    }
}
