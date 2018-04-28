package com.simba.service;

import com.simba.framework.util.json.JsonResult;
import com.simba.mobile.message.model.MsgType;
import com.simba.model.ShortMessage;
import com.simba.model.enums.SendStatus;
import com.simba.model.other.MsgPostArgs;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by linshuo on 2017/12/21.
 */
public interface SendMsgService {

    void sendSimply(String mobile, String selfTemplateId, Map<String, String> params, String projectId);

    void checkAndSend(MsgPostArgs msgPostArgs, String ip);

    ShortMessage resend(long id);

}
