package com.simba.controller;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Notify;
import com.simba.model.SmartUser;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.NotifyService;
import com.simba.service.SmartUserService;
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

    @Autowired
    private SmartUserService smartUserService;

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
        if (smartUserIds[0] == -1) {
            notifyService.sendNotify2AllUser(title, content, type);
        } else {
            notifyService.sendNotify(title, content, smartUserIds, type);
        }
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

    @RequestMapping("/toSendNotify2User")
    public String toSendNotify2User() {
        return "notify/listUser";
    }

    @RequestMapping("/toSendNotify")
    public String toSendNotify(String smartUserIds, ModelMap model) {
        model.put("smartUserIds", smartUserIds);
        return "notify/sendNotify";
    }

    @RequestMapping("/getUserList")
    public String getList(Pager pager, SmartUserSearchForm searchForm, ModelMap model) {
        List<SmartUser> list = smartUserService.page(pager, searchForm);
        model.put("list", list);
        return "notify/userTable";
    }

    @ResponseBody
    @RequestMapping("/userCount")
    public JsonResult userCount(SmartUserSearchForm searchForm) {
        Long count = smartUserService.count(searchForm);
        return new JsonResult(count, "", 200);
    }

}
