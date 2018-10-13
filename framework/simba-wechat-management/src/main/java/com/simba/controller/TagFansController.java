package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.TagFans;
import com.simba.service.TagFansService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tagFans")
public class TagFansController {

	@Autowired
	private TagFansService tagFansService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TagFans> list() {
		List<TagFans> list = tagFansService.listAll();
		return list;
	}

	/**
	 * 新增
	 * 
	 * @param tagFans
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TagFans tagFans) {
		tagFansService.add(tagFans);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TagFans tagFans) {
		tagFansService.update(tagFans);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		tagFansService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		tagFansService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
