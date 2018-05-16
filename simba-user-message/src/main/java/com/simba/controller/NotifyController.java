package com.simba.controller;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Notify;
import com.simba.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * 通知表控制器
 *
 * @author linshuo
 */
@Controller
@RequestMapping("/notify")
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    @RequestMapping("/list")
    public String list() {
        return "notify/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        List<Notify> list = notifyService.page(pager);
        model.put("list", list);
        return "notify/table";
    }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count(HttpSession session) {
        System.out.println(session.getAttribute("sessUser"));
        Long count = notifyService.count();
        return new JsonResult(count, "", 200);
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "notify/add";
    }

    @RequestMapping("/add")
    public String add(Notify notify) {
        notifyService.add(notify);
        return "redirect:/notify/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Long id, ModelMap model) {
        Notify notify = notifyService.get(id);
        model.put("notify", notify);
        return "notify/update";
    }

    @RequestMapping("/update")
    public String update(Notify notify) {
        notifyService.update(notify);
        return "redirect:/notify/list";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Long id, ModelMap model) {
        notifyService.delete(id);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/batchDelete")
    public JsonResult batchDelete(Long[] id, ModelMap model) {
        notifyService.batchDelete(Arrays.asList(id));
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/sendNotify")
    public JsonResult sendNotify(String title, String content, Long smartUserId, int type) {
        notifyService.sendNotify(title, content, new Long[]{smartUserId}, type);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/sendNotifies")
    public JsonResult sendNotifies(String title, String content, Long[] smartUserIds, int type) {
        notifyService.sendNotify(title, content, smartUserIds, type);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/pullNotify")
    public JsonResult pullNotify(Long smartUserId, int status) {
        return new JsonResult(notifyService.pullNotify(smartUserId, status));
    }

    @ResponseBody
    @RequestMapping("/pullAllNotify")
    public JsonResult pullAllNotify(Long smartUserId) {
        return new JsonResult(notifyService.pullNotify(smartUserId));
    }

    @ResponseBody
    @RequestMapping("/setNotifyRead")
    public JsonResult setNotifyRead(Long smartUserId, Long notifyId) {
        notifyService.setNotifyRead(smartUserId, notifyId);
        return new JsonResult();
    }

}
