package com.simba.service.impl;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.mobile.message.model.MsgType;
import com.simba.mobile.message.util.SendMsgUtil;
import com.simba.model.MsgProject;
import com.simba.model.ShortMessage;
import com.simba.model.MsgTemplate;
import com.simba.model.enums.SendStatus;
import com.simba.service.*;
import com.simba.model.other.MsgPostArgs;
import com.simba.util.EmailUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by linshuo on 2017/12/6.
 */
@Service
@Transactional
public class SendMsgServiceImpl implements SendMsgService {

    private static final Log logger = LogFactory.getLog(SendMsgServiceImpl.class);

    @Autowired
    MsgProjectService projectService;

    @Autowired
    MsgTemplateService templateService;

    @Autowired
    ShortMessageService shortMessageService;

    @Autowired
    MsgBlacklistService blacklistService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    SendMsgUtil sendMsgUtil;

    @Value(value = "${msg.rediskey.dayAmount}")
    private String MSG_DAY_AMOUNT_REDISKEY;

    @Value(value = "${msg.rediskey.msgArgs}")
    private String MSG_ID_ARGS_MAP;

    @Value(value = "${project.alarm.email}")
    private boolean emailAlarmEnable;

    @Value(value = "${project.alarm.shortmsg}")
    private boolean shortmsgAlarmEnable;

    private static final int RESEND_LIMIT_TIMES = 3;

    /**
     * 群发没有返回MessageId,这里MULTI_SEND_ID是群发的标识
     */
    public static final String MULTI_SEND_ID = "MULTI_SEND_ID";

    /**
     * 持久化短信
     *
     * @param msgPostArgs
     * @param sendDate
     * @param sendStatus
     * @param platform
     * @param messageId
     * @return
     */
    @Override
    public int addShortMessage(MsgPostArgs msgPostArgs, Date sendDate, SendStatus sendStatus, MsgType platform, String messageId) {
        ShortMessage shortMessage = new ShortMessage();
        List<String> mobileList = FastJsonUtil.toObject(msgPostArgs.getMobileList(),List.class);
        shortMessage.setValue(msgPostArgs.getValues());
        shortMessage.setPlatform(platform.getType());
        shortMessage.setSendDate(sendDate);
        shortMessage.setStatus(sendStatus.getId());
        shortMessage.setProjectId(Integer.valueOf(msgPostArgs.getProjectId()));
        shortMessage.setTemplateId(msgPostArgs.getTemplateSelfId());
        shortMessage.setMessageId(messageId);
        mobileList.forEach(moblieNo -> {
            shortMessage.setMobile(moblieNo);
            shortMessageService.add(shortMessage);
        });
        return 0;
    }

    /**
     * 校验MD5密文
     *
     * @param msgPostArgs
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public boolean checkSecret(MsgPostArgs msgPostArgs) {
        String projectKey = projectService.getProjectKeyBySelfId(msgPostArgs.getProjectId());
        String verifyMD5 = EncryptUtil.md5(projectKey + msgPostArgs.getTimeStamp());
        String cipherText = msgPostArgs.getCipherText();
        if (verifyMD5 == null) {
            return false;
        } else {
            return verifyMD5.equals(cipherText);
        }
    }

    /**
     * 用量检测, 是否超量
     *
     * @param projectId
     * @return
     */
    @Override
    public boolean checkExcess(int projectId) {
        // <K, V> --> <ProjectId, SendAmount>
        Map<Integer, Integer> msgAmountMap = (Map<Integer, Integer>) redisUtil.get(MSG_DAY_AMOUNT_REDISKEY);
        // 发送量
        if (msgAmountMap.get(projectId) == null) {
            msgAmountMap.put(projectId, 0);
        }
        Integer sendNum = msgAmountMap.get(projectId);
        MsgProject project = projectService.listBy("id", projectId).get(0);
        int threholdNum = (int) (project.getLimitNum() * project.getThreshold());
        // 短信超量
        if (sendNum >= project.getLimitNum()) {
            return true;
        }
        // 过警告值
        if (sendNum > threholdNum) {
            if (emailAlarmEnable) {
                emailUtil.send(project.getEmail(), "短信用量警告", "今日短信数量即将用尽");
            }
            if (shortmsgAlarmEnable) {
                // 发送短信给项目的手机号
            }
        }
        return false;
    }

    /**
     * 校验ip是否合法
     *
     * @param projectId
     * @param ip
     * @return true:合法 false:不合法
     */
    @Override
    public boolean checkIp(int projectId, String ip) {
        MsgProject project = projectService.get(projectId);
        String ipStr = project.getIp();
        String[] ipList = ipStr.split(",");
        for (String s : ipList) {
            if (ip.equals(s.trim()))
                return true;
        }
        return false;
    }


    /**
     * 项目的发送量++ (Redis)
     *
     * @param projectId
     * @return
     */
    @Override
    public int increaseSendNum(int projectId, int increasement) {
        int sendAmount = 0;
        Map<Integer, Integer> msgAmountMap = (Map<Integer, Integer>) redisUtil.get(MSG_DAY_AMOUNT_REDISKEY);
        if (msgAmountMap.get(projectId) == null) {
            sendAmount = 1;
            msgAmountMap.put(projectId, sendAmount);
        } else {
            sendAmount = msgAmountMap.get(projectId);
            sendAmount += increasement;
            msgAmountMap.put(projectId, sendAmount);
        }
        redisUtil.set(MSG_DAY_AMOUNT_REDISKEY, msgAmountMap);
        return sendAmount;
    }


    /**
     * 自带检测的发送, 包括了黑名单,用量检测,ip检测
     *
     * @param mobileList
     * @param tid
     * @param values
     * @param platform
     * @param projectId
     * @return
     */
    @Override
    public String sendMsgWithCheck(List<String> mobileList, String tid, Map<String, String> values, MsgType platform, int projectId, HttpServletRequest request) {
        String projectName = projectService.get(projectId).getName();
        if (!checkIp(projectId, request.getRemoteAddr())) { // ip校验
            logger.info(projectName + "项目IP" + request.getRemoteAddr() + "不合法,无法发送短信!");
            return null;
        }
        List<String> blackMobiles = blacklistService.filterBlacklist(mobileList);
        if (blackMobiles.size() > 0) { // 有手机号是在黑名单里面
            logger.info("手机号" + blackMobiles + "在黑名单中,无法发送短信!");
            return null;
        }
        boolean isExcess = checkExcess(projectId);
        if (isExcess) { // 短信超量
            logger.info(projectName + "项目今天的短信数量已用尽!");
            return null;
        }
        // 发送短信
        String messageId = "";
        if (mobileList.size() > 1) {
            sendMsgUtil.send(mobileList, tid, values, platform);
            increaseSendNum(projectId, 1); // 群发算一条
            messageId = MULTI_SEND_ID;
        } else {
            messageId = sendMsgUtil.send(mobileList.get(0), tid, values, platform);
            increaseSendNum(projectId, 1);
//            messageId = RandomUtil.randomNumWithTimeMillis(0); // 测试用
        }
        return messageId;
    }

    /** 短信重发
     * @param id shortmessage中的id字段
     * @return
     */
    @Override
    public ShortMessage resend(long id) {
        ShortMessage shortMessage = shortMessageService.get(id);
        MsgType platform = MsgType.getByType(shortMessage.getPlatform());
        MsgTemplate template = templateService.getBy("selfId", shortMessage.getTemplateId());
        String realTemplateId = null;
        if (platform == MsgType.JPUSH) {
            realTemplateId = template.getJpushTemplateId();
        } else if (platform == MsgType.ALI) {
            realTemplateId = template.getAliTemplateId();
        }
        Map<String, String> values = FastJsonUtil.toObject(shortMessage.getValue(), Map.class);
        String newMessageId = sendMsgUtil.send(shortMessage.getMobile(), realTemplateId, values, platform);
        increaseSendNum(shortMessage.getProjectId(), 1);
//        String newMessageId = RandomUtil.randomNumWithTimeMillis(0); // 测试用
        shortMessage.setMessageId(newMessageId);
        shortMessage.setStatus(SendStatus.UNKNOWN.getId());
        shortMessage.setSendDate(DateUtil.getTime());
        shortMessageService.update(shortMessage);
        logger.info("短信已重发,手机号为"+shortMessage.getMobile());
        return shortMessage;
    }

}
