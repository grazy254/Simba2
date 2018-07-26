package com.simba.consumer;

import com.simba.arg.PushArg;
import com.simba.consts.GlobalValue;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.PushMessage;
import com.simba.service.PushMessageService;
import com.simba.service.sender.ISender;
import com.simba.exceptions.PushTypeException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shuoGG on 2018/7/20
 */
@Component
@RabbitListener(queues = GlobalValue.QUEUE_NAME)
public class MessageReceiver {
    private static final Log logger = LogFactory.getLog(MessageReceiver.class);

    @Autowired
    private PushMessageService pushMessageService;

    @RabbitHandler
    public void process(String recMsg) {
        logger.info("收到消息队列msgCenterS的消息:" + recMsg);
        if (StringUtils.isEmpty(recMsg)) return;
        PushArg pushArg = FastJsonUtil.toObject(recMsg, PushArg.class);
        ISender sender = (ISender) ApplicationContextUtil.getBean(pushArg.getPushType());
        if (sender == null) throw new PushTypeException("无效type" + pushArg.getPushType());
        /* 发送 */
        sender.send(Long.parseLong(pushArg.getToUserId()), pushArg.getContent());
        /* 记录 */
        PushMessage pm = new PushMessage();
        pm.setPushType(pushArg.getPushType());
        pm.setContent(pushArg.getContent());
        pm.setCreateTime(new Date());
        String toUserId = pushArg.getToUserId();
        pm.setToUserId(StringUtils.isEmpty(toUserId) ? -1 : Long.parseLong(toUserId));
        String fromUserId = pushArg.getToUserId();
        pm.setFromUserId(StringUtils.isEmpty(toUserId) ? -1 : Long.parseLong(fromUserId));
        pushMessageService.add(pm);
    }

}
