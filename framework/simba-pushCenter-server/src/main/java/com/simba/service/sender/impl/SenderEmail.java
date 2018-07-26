package com.simba.service.sender.impl;

import com.simba.arg.EmailArg;
import com.simba.consts.PushType;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.SmartUser;
import com.simba.service.SmartUserService;
import com.simba.service.sender.ISender;
import com.simba.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shuoGG on 2018/7/24
 */
@Component(PushType.EMAIL)
public class SenderEmail implements ISender {

    @Autowired
    private SmartUserService smartUserService;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public void send(Long userId, String content) {
        SmartUser smartUser = smartUserService.get(userId);
        try {
            EmailArg emailArg = FastJsonUtil.toObject(content, EmailArg.class);
            if (emailArg == null) throw new RuntimeException("非标准格式");
            emailUtil.send(smartUser.getEmail(), emailArg.getSubject(), emailArg.getContent());
        } catch (Exception e) {
            emailUtil.send(smartUser.getEmail(), "无标题", content);
        }
    }

}
