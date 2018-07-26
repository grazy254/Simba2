package com.simba.util;

import com.simba.arg.EmailArg;
import com.simba.arg.PushArg;
import com.simba.arg.ShortMsgArg;
import com.simba.consts.GlobalValue;
import com.simba.consts.PushType;
import com.simba.framework.util.json.FastJsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 推送工具
 */
@Component
public class PushCenterUtil {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    public void sendEmail(Long userId, String title, String content) {
        EmailArg arg = new EmailArg();
        arg.setContent(content);
        arg.setSubject(title);
        PushArg pushArg = new PushArg(PushType.EMAIL, "", String.valueOf(userId), FastJsonUtil.toJson(arg));
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
    }

    public void sendJpushNotification(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.JPUSH_NOTIFICATION, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
    }

    public void sendJpushMessage(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.JPUSH_MESSAGE, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
    }

    public void sendShortMessage(Long userId, String selfTemplateId, Map<String, String> params) {
        ShortMsgArg arg = new ShortMsgArg();
        arg.setSelfTemplateId(selfTemplateId);
        arg.setParams(params);
        PushArg pushArg = new PushArg(PushType.SHORT_MESSAGE, "", String.valueOf(userId), FastJsonUtil.toJson(arg));
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
    }

    public void sendWebsocket(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.WEBSOCKET, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
    }

}
