package com.simba.service;

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
    int increaseSendNum(int projectId, int increasement);

    int addShortMessage(MsgPostArgs msgPostArgs, Date sendDate, SendStatus sendStatus, MsgType platform, String messageId);

    boolean checkSecret(MsgPostArgs msgPostArgs);

    boolean checkExcess(int projectId);

    boolean checkIp(int projectId, String ip);

    String sendMsgWithCheck(List<String> mobileList, String tid, Map<String, String> values, MsgType platform, int projectId, HttpServletRequest request);

    ShortMessage resend(long id);
}
