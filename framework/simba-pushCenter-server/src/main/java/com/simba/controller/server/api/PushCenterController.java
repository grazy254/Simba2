package com.simba.controller.server.api;

import com.simba.arg.EmailArg;
import com.simba.arg.PushArg;
import com.simba.arg.ShortMsgArg;
import com.simba.consts.GlobalValue;
import com.simba.consts.PushType;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by shuoGG on 2018/8/15
 */
@Controller
@ResponseBody
@RequestMapping("/server/api/pushCenter")
public class PushCenterController {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @RequestMapping("sendEmail")
    public JsonResult sendEmail(Long userId, String title, String content) {
        EmailArg arg = new EmailArg();
        arg.setContent(content);
        arg.setSubject(title);
        PushArg pushArg = new PushArg(PushType.EMAIL, "", String.valueOf(userId), FastJsonUtil.toJson(arg));
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
        return new JsonResult();
    }

    @RequestMapping("sendJpushNotification")
    public JsonResult sendJpushNotification(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.JPUSH_NOTIFICATION, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
        return new JsonResult();
    }

    @RequestMapping("sendJpushMessage")
    public JsonResult sendJpushMessage(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.JPUSH_MESSAGE, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
        return new JsonResult();
    }

    @RequestMapping("sendShortMessage")
    public JsonResult sendShortMessage(Long userId, String selfTemplateId, Map<String, String> params) {
        ShortMsgArg arg = new ShortMsgArg();
        arg.setSelfTemplateId(selfTemplateId);
        arg.setParams(params);
        PushArg pushArg = new PushArg(PushType.SHORT_MESSAGE, "", String.valueOf(userId), FastJsonUtil.toJson(arg));
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
        return new JsonResult();
    }

    @RequestMapping("sendWebsocket")
    public JsonResult sendWebsocket(Long userId, String content) {
        PushArg pushArg = new PushArg(PushType.WEBSOCKET, "", String.valueOf(userId), content);
        rabbitMqTemplate.convertAndSend(GlobalValue.QUEUE_NAME, FastJsonUtil.toJson(pushArg));
        return new JsonResult();
    }
}
