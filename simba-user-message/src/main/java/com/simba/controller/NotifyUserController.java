package com.simba.controller;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.NotifyUser;
import com.simba.service.NotifyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 通知表和用户表的关联控制器
 *
 * @author linshuo
 */
@Controller
@RequestMapping("/notifyUser")
public class NotifyUserController {

    @Autowired
    private NotifyUserService notifyUserService;

    @RequestMapping("/list")
    public String list() {
        return "notifyUser/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        List<NotifyUser> list = notifyUserService.page(pager);
        model.put("list", list);
        return "notifyUser/table";
    }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count() {
        Long count = notifyUserService.count();
        return new JsonResult(count, "", 200);
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "notifyUser/add";
    }

    @RequestMapping("/add")
    public String add(NotifyUser notifyUser) {
        notifyUserService.add(notifyUser);
        return "redirect:/notifyUser/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Long id, ModelMap model) {
        NotifyUser notifyUser = notifyUserService.get(id);
        model.put("notifyUser", notifyUser);
        return "notifyUser/update";
    }

    @RequestMapping("/update")
    public String update(NotifyUser notifyUser) {
        notifyUserService.update(notifyUser);
        return "redirect:/notifyUser/list";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Long id, ModelMap model) {
        notifyUserService.delete(id);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/batchDelete")
    public JsonResult batchDelete(Long[] id, ModelMap model) {
        notifyUserService.batchDelete(Arrays.asList(id));
        return new JsonResult();
    }

}
