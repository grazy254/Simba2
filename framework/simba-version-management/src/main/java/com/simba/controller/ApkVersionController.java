package com.simba.controller;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ApkVersion;
import com.simba.service.ApkVersionService;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * apk管理控制器
 *
 * @author caozj
 */
@Controller
@RequestMapping("/apkVersion")
public class ApkVersionController {

    @Autowired
    private ApkVersionService apkVersionService;

    @RequestMapping("/list")
    public String list() {
        return "apkVersion/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        List<ApkVersion> list = apkVersionService.page(pager);
        model.put("list", list);
        return "apkVersion/table";
    }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count() {
        Integer count = apkVersionService.count();
        return new JsonResult(count, "", 200);
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "apkVersion/add";
    }

    @RequestMapping("/add")
    public String add(ApkVersion apkVersion, MultipartFile file) throws Exception {
        apkVersionService.add(apkVersion, file);
        return "redirect:/apkVersion/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, ModelMap model) {
        ApkVersion apkVersion = apkVersionService.get(id);
        model.put("apkVersion", apkVersion);
        return "apkVersion/update";
    }

    @RequestMapping("/update")
    public String update(ApkVersion apkVersion, MultipartFile file) throws Exception {
        apkVersionService.update(apkVersion, file);
        return "redirect:/apkVersion/list";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(Integer id, ModelMap model) throws IOException, FastdfsException {
        apkVersionService.delete(id);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/batchDelete")
    public JsonResult batchDelete(Integer[] id, ModelMap model) throws IOException, FastdfsException {
        apkVersionService.batchDelete(Arrays.asList(id));
        return new JsonResult();
    }


}
