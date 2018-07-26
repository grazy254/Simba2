package com.simba.service.sender.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.simba.jpush.app.util.JpushAppUtil;
import com.simba.consts.PushType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shuoGG on 2018/7/24
 */
@Component(PushType.JPUSH_NOTIFICATION)
public class SenderJpushNotification implements com.simba.service.sender.ISender {

    private static final Log logger = LogFactory.getLog(SenderJpushNotification.class);

    private final JpushAppUtil jpushAppUtil;

    @Autowired
    public SenderJpushNotification(JpushAppUtil jpushAppUtil) {
        this.jpushAppUtil = jpushAppUtil;
    }

    @Override
    public void send(Long userId, String content) {
        try {
            jpushAppUtil.sendNotification(String.valueOf(userId), content);
        } catch (APIConnectionException | APIRequestException e) {
            logger.error("极光推送API调用过程出错", e);
        }
    }
}
