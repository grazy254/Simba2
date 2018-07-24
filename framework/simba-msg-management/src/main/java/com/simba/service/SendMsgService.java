package com.simba.service;

import com.simba.model.ShortMessage;
import com.simba.service.bean.MsgPostArgs;

import java.util.Map;

/**
 * Created by linshuo on 2017/12/21.
 */
public interface SendMsgService {

    void sendSimply(String mobile, String selfTemplateId, Map<String, String> params, String projectId);

    void sendPure(String mobile, String selfTemplateId, Map<String, String> params);

    void checkAndSend(MsgPostArgs msgPostArgs, String ip);

    ShortMessage resend(long id);

}
