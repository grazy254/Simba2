package com.simba.service.impl;

import com.simba.exception.BussException;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.mobile.message.model.MsgType;
import com.simba.mobile.message.util.SendMsgUtil;
import com.simba.model.MsgProject;
import com.simba.model.MsgTemplate;
import com.simba.model.ShortMessage;
import com.simba.model.enums.SendStatus;
import com.simba.service.bean.MsgPostArgs;
import com.simba.service.bean.EntryPlatform;
import com.simba.service.*;
import com.simba.util.DayAmountUtil;
import com.simba.util.EmailUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by linshuo on 2017/12/6.
 */
@Service
@Transactional
public class SendMsgServiceImpl implements SendMsgService {

    private static final Log logger = LogFactory.getLog(SendMsgServiceImpl.class);

    @Autowired
    private MsgProjectService projectService;

    @Autowired
    private MsgTemplateService templateService;

    @Autowired
    private ShortMessageService shortMessageService;

    @Autowired
    private MsgBlacklistService blacklistService;

    @Autowired
    private DayAmountUtil dayAmountUtil;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private SendMsgUtil sendMsgUtil;

    @Value(value = "${project.alarm.email:false}")
    private boolean emailAlarmEnable;

    @Value(value = "${project.alarm.shortmsg:false}")
    private boolean shortmsgAlarmEnable;


    /**
     * 发送+记录
     *
     * @param mobile
     * @param selfTemplateId
     * @param params
     * @param projectId
     * @return
     */
    @Override
    public void sendSimply(String mobile, String selfTemplateId, Map<String, String> params, String projectId) {
        EntryPlatform platform = templateService.getOnePlatformTemplateId(selfTemplateId);
        if (platform == null) throw new BussException("模板Id有误");
        String platformTemplateId = platform.getTemplateId();
        MsgType platformType = platform.getPlatformType();
        String messageId = sendOneMessage(mobile, platformTemplateId, params, platformType, Integer.valueOf(projectId));
        if (!StringUtils.isEmpty(messageId)) {
            SendStatus sendStatus = SendStatus.SUCCESS;
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setValue(FastJsonUtil.toJson(params, false));
            shortMessage.setPlatform(platformType.getType());
            shortMessage.setSendDate(DateUtil.getTime());
            shortMessage.setStatus(sendStatus.getId());
            shortMessage.setProjectId(Integer.parseInt(projectId));
            shortMessage.setTemplateId(platformTemplateId);
            shortMessage.setMessageId(messageId);
            shortMessage.setMobile(mobile);
            shortMessageService.add(shortMessage);
        } else {
            throw new BussException("第三方短信接口无返回短信Id");
        }
    }

    /**
     * 只单纯的发送, 不做任何记录
     *
     * @param mobile
     * @param selfTemplateId
     * @param params
     */
    @Override
    public void sendPure(String mobile, String selfTemplateId, Map<String, String> params) {
        EntryPlatform platform = templateService.getOnePlatformTemplateId(selfTemplateId);
        if (platform == null) throw new BussException("模板Id有误");
        String platformTemplateId = platform.getTemplateId();
        MsgType platformType = platform.getPlatformType();
        sendMsgUtil.send(mobile, platformTemplateId, params, platformType);
    }

    /**
     * 校验+发送+记录
     *
     * @param msgPostArgs
     * @param ip
     * @return
     */
    @Override
    public void checkAndSend(MsgPostArgs msgPostArgs, String ip) {
        Map<String, String> values = FastJsonUtil.toObject(msgPostArgs.getValues(), Map.class);
        boolean isVerified = check(msgPostArgs.getMobile(), Integer.parseInt(msgPostArgs.getProjectId()), msgPostArgs.getTimeStamp(), msgPostArgs.getCipherText(), ip);
        if (isVerified) {
            sendSimply(msgPostArgs.getMobile(), msgPostArgs.getTemplateSelfId(), values, msgPostArgs.getProjectId());
        } else {
            throw new BussException("校验失败");
        }
    }

    /**
     * 短信重发
     *
     * @param msgId shortmessage中的id字段
     * @return
     */
    @Override
    public ShortMessage resend(long msgId) {
        ShortMessage shortMessage = shortMessageService.get(msgId);
        MsgType platform = MsgType.getByType(shortMessage.getPlatform());
        String fieldName = platform.getType().equals("jpush") ? "jpushTemplateId" : "aliTemplateId";
        MsgTemplate template = templateService.getBy(fieldName, shortMessage.getTemplateId());
        String realTemplateId = null;
        if (platform == MsgType.JPUSH) {
            realTemplateId = template.getJpushTemplateId();
        } else if (platform == MsgType.ALI) {
            realTemplateId = template.getAliTemplateId();
        }
        Map<String, String> values = FastJsonUtil.toObject(shortMessage.getValue(), Map.class);
        String newMessageId = sendMsgUtil.send(shortMessage.getMobile(), realTemplateId, values, platform);
        increaseSendNum(shortMessage.getProjectId(), 1);
        shortMessage.setMessageId(newMessageId);
        shortMessage.setStatus(SendStatus.UNKNOWN.getId());
        shortMessage.setSendDate(DateUtil.getTime());
        shortMessageService.update(shortMessage);
        logger.info("短信已重发,手机号为" + shortMessage.getMobile());
        return shortMessage;
    }


    /**
     * 校验MD5密文
     *
     * @param projectId
     * @param timeStamp
     * @param cipherText
     * @return
     */
    private boolean checkSecret(int projectId, long timeStamp, String cipherText) {
        String projectKey = projectService.getProjectKeyBySelfId(String.valueOf(projectId));
        String verifyMD5 = EncryptUtil.md5(projectKey + timeStamp);
        return verifyMD5.equals(cipherText);
    }

    /**
     * 用量检测, 是否超量
     *
     * @param projectId
     * @return
     */
    private boolean checkExcess(int projectId) {
        Integer sendNum = dayAmountUtil.getAmount(String.valueOf(projectId));
        // 发送量
        if (sendNum == null) return false;
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
    private boolean checkIp(int projectId, String ip) {
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
    private void increaseSendNum(int projectId, int increasement) {
        try {
            dayAmountUtil.incrAmount(String.valueOf(projectId), increasement);
        } catch (Exception e) {
            dayAmountUtil.clean();
            dayAmountUtil.setAmount(String.valueOf(projectId), 1);
            logger.warn(e);
        }
    }


    /**
     * 单纯的调短信接口,不操作数据库
     *
     * @param mobile
     * @param tid
     * @param values
     * @param platform
     * @param projectId
     * @return 极光或阿里返回的msgId
     */
    private String sendOneMessage(String mobile, String tid, Map<String, String> values, MsgType platform, int projectId) {
        // 发送短信
        String messageId = sendMsgUtil.send(mobile, tid, values, platform);
        increaseSendNum(projectId, 1);
        return messageId;
    }

    /**
     * 密文校验+ip校验+黑名单校验+超量校验
     *
     * @param mobile
     * @param projectId
     * @param timestamp
     * @param cipherText
     * @param ip
     * @return
     */
    private boolean check(String mobile, int projectId, long timestamp, String cipherText, String ip) {
        String projectName = projectService.get(projectId).getName();
        if (!checkSecret(projectId, timestamp, cipherText)) {
            logger.info(projectName + "项目密文校验错误!");
            return false;
        }
        if (!checkIp(projectId, ip)) { // ip校验
            logger.info(projectName + "项目IP" + ip + "不合法,无法发送短信!");
            return false;
        }
        if (blacklistService.inBlackList(mobile)) { // 有手机号是在黑名单里面
            logger.info("手机号" + mobile + "在黑名单中,无法发送短信!");
            return false;
        }
        boolean isExcess = checkExcess(projectId);
        if (isExcess) { // 短信超量
            logger.info(projectName + "项目今天的短信数量已用尽!");
            return false;
        }
        return true;
    }

}
