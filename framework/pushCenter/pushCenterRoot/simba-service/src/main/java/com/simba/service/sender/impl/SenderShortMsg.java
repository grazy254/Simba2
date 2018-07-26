package com.simba.service.sender.impl;

import com.simba.arg.ShortMsgArg;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.service.SmartUserService;
import com.simba.util.ShortMessageUtil;
import com.simba.consts.PushType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shuoGG on 2018/7/24
 */
@Component(PushType.SHORT_MESSAGE)
public class SenderShortMsg implements com.simba.service.sender.ISender {

    @Autowired
    private ShortMessageUtil shortMessageUtil;

    @Autowired
    private SmartUserService smartUserService;

    @Override
    public void send(Long userId, String content) {
        ShortMsgArg sma = FastJsonUtil.toObject(content, ShortMsgArg.class);
        shortMessageUtil.sendPure(smartUserService.get(userId).getTelNo(), sma.getSelfTemplateId(), sma.getParams());
    }

}
