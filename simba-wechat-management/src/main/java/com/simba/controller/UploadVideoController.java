package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.UploadVideo;
import com.simba.model.form.UploadVideoSearchForm;
import com.simba.service.UploadVideoService;

/**
 * 上传视频控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/uploadVideo")
public class UploadVideoController {

	@Autowired
	private UploadVideoService uploadVideoService;

	@RequestMapping("/select")
	public String select(String domId, ModelMap model) {
		model.put("domId", domId);
		return "uploadVideo/select";
	}
	
	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, UploadVideoSearchForm searchForm, ModelMap model) {
		List<UploadVideo> list = uploadVideoService.page(pager, searchForm);
		model.put("list", list);
		return "uploadVideo/selectTable";
	}

	@RequestMapping("/list")
	public String list() {
		return "uploadVideo/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, UploadVideoSearchForm searchForm, ModelMap model) {
		List<UploadVideo> list = uploadVideoService.page(pager, searchForm);
		model.put("list", list);
		return "uploadVideo/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(UploadVideoSearchForm searchForm) {
		int count = uploadVideoService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "uploadVideo/add";
	}

	@RequestMapping("/add")
	public String add(UploadVideo uploadVideo) {
		uploadVideoService.add(uploadVideo);
		return "redirect:/uploadVideo/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		UploadVideo uploadVideo = uploadVideoService.get(id);
		model.put("uploadVideo", uploadVideo);
		return "uploadVideo/update";
	}

	@RequestMapping("/update")
	public String update(UploadVideo uploadVideo) {
		uploadVideoService.update(uploadVideo);
		return "redirect:/uploadVideo/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		uploadVideoService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		uploadVideoService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
