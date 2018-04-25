package com.simba.controller;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.other.MsgPostArgs;
import com.simba.service.impl.SendMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linshuo on 2017/12/5.
 */
@Controller
@RequestMapping("/sendMsg")
public class SendMsgController {

    @Autowired
    private SendMsgServiceImpl sendMsgService;

    @RequestMapping("/send")
    @ResponseBody
    public JsonResult send(HttpServletRequest request, MsgPostArgs msgPostArgs) {
        return sendMsgService.checkAndSend(msgPostArgs, request.getRemoteAddr());
    }

}
