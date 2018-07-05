package com.simba.controller;

import com.simba.controller.vo.NotifyVo;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Notify;
import com.simba.model.NotifyUser;
import com.simba.model.SmartUser;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.NotifyService;
import com.simba.service.NotifyUserService;
import com.simba.service.SmartUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.LinkedList;
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
    private NotifyUserService notifyUserService;

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
    public JsonResult pullNotify(Long sessUserId, int status) {
        List<Notify> notifyList = notifyService.pullNotify(sessUserId, status);
        return new JsonResult(toNotifyVoList(notifyList, sessUserId));
    }


    @ResponseBody
    @RequestMapping("/pullAllNotify")
    public JsonResult pullAllNotify(Long sessUserId) {
        List<Notify> notifyList = notifyService.pullNotify(sessUserId);
        return new JsonResult(toNotifyVoList(notifyList, sessUserId));
    }

    @ResponseBody
    @RequestMapping("/setNotifyRead")
    public JsonResult setNotifyRead(Long sessUserId, Long notifyId) {
        notifyService.setNotifyRead(sessUserId, notifyId);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/setNotifiesRead")
    public JsonResult setNotifiesRead(Long sessUserId, Long[] notifyIds) {
        for (Long notifyId : notifyIds) {
            notifyService.setNotifyRead(sessUserId, notifyId);
        }
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

    @RequestMapping("/toListReceiver")
    public String toListReceiver(Long notifyId, ModelMap model) {
        model.put("notifyId", notifyId);
        return "notify/listReceiver";
    }

    @RequestMapping("/listReceiver")
    public String listReceiver(Long notifyId, Pager pager, ModelMap model) {
        model.put("list", notifyService.listReceiver(notifyId, pager));
        return "notify/receiverTable";
    }

    @ResponseBody
    @RequestMapping("/receiverCount")
    public JsonResult receiverCount(Long notifyId) {
        int count = notifyUserService.listBy("notifyId", notifyId).size();
        return new JsonResult(count, "", 200);
    }


    private List<NotifyVo> toNotifyVoList(List<Notify> notifyList, Long sessUserId) {
        List<NotifyVo> notifyVoList = new LinkedList<>();
        for (Notify notify : notifyList) {
            int status = notifyUserService.getByAnd("notifyId", notify.getId(), "smartUserId", sessUserId).getStatus();
            NotifyVo notifyVo = new NotifyVo(notify.getId(), notify.getTitle(), notify.getContent(), notify.getType(), status, notify.getCreateTime());
            notifyVoList.add(notifyVo);
        }
        return notifyVoList;
    }

}
