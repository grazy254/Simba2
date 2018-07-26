package com.simba.controller;

import com.simba.util.PushCenterUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuoGG on 2018/7/20
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Autowired
    private PushCenterUtil pushCenterUtil;

    @RequestMapping("send")
    @ResponseBody
    public String sendMessage(String message) {
        rabbitMqTemplate.convertAndSend("msgCenterS", message);
        return "ok";
    }

    @RequestMapping("email")
    @ResponseBody
    public String email() {
        pushCenterUtil.sendEmail(1L, "消息中心", "Thank you for your register!!!");
        return "OK";
    }

    @RequestMapping("shortmsg")
    @ResponseBody
    public String shortmsg() {
        Map<String, String> map = new HashMap<>();
        map.put("code", "666777");
        pushCenterUtil.sendShortMessage(1L, "app", map);
        return "OK";
    }
}
