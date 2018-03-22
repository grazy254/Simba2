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
import com.simba.model.UploadNews;
import com.simba.model.form.UploadNewsSearchForm;
import com.simba.service.UploadNewsService;

/**
 * 上传图文控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/uploadNews")
public class UploadNewsController {

	@Autowired
	private UploadNewsService uploadNewsService;

	@RequestMapping("/select")
	public String select(String domId, ModelMap model) {
		model.put("domId", domId);
		return "uploadNews/select";
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, UploadNewsSearchForm searchForm, ModelMap model) {
		List<UploadNews> list = uploadNewsService.page(pager, searchForm);
		model.put("list", list);
		return "uploadNews/selectTable";
	}

	@RequestMapping("/list")
	public String list() {
		return "uploadNews/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, UploadNewsSearchForm searchForm, ModelMap model) {
		List<UploadNews> list = uploadNewsService.page(pager, searchForm);
		model.put("list", list);
		return "uploadNews/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(UploadNewsSearchForm searchForm) {
		int count = uploadNewsService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "uploadNews/add";
	}

	@RequestMapping("/add")
	public String add(UploadNews uploadNews) {
		uploadNewsService.add(uploadNews);
		return "redirect:/uploadNews/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		UploadNews uploadNews = uploadNewsService.get(id);
		model.put("uploadNews", uploadNews);
		return "uploadNews/update";
	}

	@RequestMapping("/update")
	public String update(UploadNews uploadNews) {
		uploadNewsService.update(uploadNews);
		return "redirect:/uploadNews/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		uploadNewsService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		uploadNewsService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
