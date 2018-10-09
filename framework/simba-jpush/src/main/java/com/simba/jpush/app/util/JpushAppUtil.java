package com.simba.jpush.app.util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.PlatformNotification;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;

/**
 * jpush推送App工具类
 *
 * @author caozhejun
 */
@Component
public class JpushAppUtil {

    private static final Log logger = LogFactory.getLog(JpushAppUtil.class);

    @Value("${jpush.key}")
    private String key;

    @Value("${jpush.secret}")
    private String secret;

    @Value("${jpush.isAppProduct:true}")
    private boolean isAppProduct;

    private JPushClient client;

    private boolean enabled = false;

    public JPushClient getClient() {
        return client;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @PostConstruct
    private void init() {
        if (StringUtils.isEmpty(secret) || StringUtils.isEmpty(key)) {
            return;
        }
        client = new JPushClient(secret, key, null, ClientConfig.getInstance());
        enabled = true;
    }

    @PreDestroy
    private void destroy() {
        if (client != null) {
            client.close();
        }
    }

    /**
     * 使用别名列表发送极光推送通知
     *
     * @param users
     * @param content
     * @throws APIRequestException
     * @throws APIConnectionException
     */
    public PushResult sendNotification(List<String> users, String content) throws APIConnectionException, APIRequestException {
        Notification no = Notification.newBuilder().setAlert(content).addPlatformNotification(IosNotification.newBuilder().setSound("default").build()).build();
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.alias(users)).build())
                .setNotification(no).setOptions(Options.newBuilder().setApnsProduction(isAppProduct).build()).build();
        return sendPush(payload);
    }


    /**
     * 使用别名发送极光推送通知
     *
     * @param user
     * @param content
     */
    public PushResult sendNotification(String user, String content) throws APIConnectionException, APIRequestException {
        Notification no = Notification.newBuilder().setAlert(content).addPlatformNotification(IosNotification.newBuilder().setSound("default").build()).build();
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(user)).setNotification(no)
                .setOptions(Options.newBuilder().setApnsProduction(isAppProduct).build()).build();
        return sendPush(payload);
    }

    /**
     * 发送极光推送通知给所有用户
     *
     * @param content
     */
    public PushResult sendNotificationAll(String content) throws APIConnectionException, APIRequestException {
        Notification no = Notification.newBuilder().setAlert(content).addPlatformNotification(IosNotification.newBuilder().setSound("default").build()).build();
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.all()).setNotification(no)
                .setOptions(Options.newBuilder().setApnsProduction(isAppProduct).build()).build();
        return sendPush(payload);
    }


    /**
     * 使用别名发送极光推送消息
     *
     * @param user
     * @param content
     */
    public PushResult sendMessage(String user, String content) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(user))
                .setMessage(Message.newBuilder().setMsgContent(content).build())
                .build();
        return sendPush(payload);
    }

    /**
     * 使用别名列表发送极光推送消息
     *
     * @param users
     * @param content
     * @throws APIRequestException
     * @throws APIConnectionException
     */
    public PushResult sendMessage(List<String> users, String content) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.alias(users)).build())
                .setMessage(Message.newBuilder().setMsgContent(content).build())
                .build();
        return sendPush(payload);
    }

    private PushResult sendPush(PushPayload payload) throws APIConnectionException, APIRequestException {
        PushResult result = client.sendPush(payload);
        logger.info("发送极光推送返回结果:" + result.toString());
        return result;
    }
}