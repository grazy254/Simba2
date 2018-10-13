package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.common.StringUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Fans;
import com.simba.model.Tag;
import com.simba.model.TagFans;
import com.simba.service.BlacklistService;
import com.simba.service.FansService;
import com.simba.service.TagFansService;
import com.simba.service.TagService;

/**
 * 标签控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@Autowired
	private FansService fansService;

	@Autowired
	private TagFansService tagFansService;

	@Autowired
	private BlacklistService blacklistService;

	@RequestMapping("/selectTag")
	public String selectTag(String domId, ModelMap model) {
		model.put("domId", domId);
		return "tag/selectTag";
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, ModelMap model) {
		List<Tag> list = tagService.page(pager);
		model.put("list", list);
		return "tag/selectTable";
	}

	/**
	 * 查看标签下的粉丝列表
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showFans")
	public String showFans(int id, ModelMap model) {
		model.put("id", id);
		return "tag/fans";
	}

	@ResponseBody
	@RequestMapping("/countFans")
	public JsonResult countFans(int tagId) {
		int total = tagFansService.countBy("tagId", tagId);
		return new JsonResult(total, "", 200);
	}

	@RequestMapping("/getFansList")
	public String getFansList(Pager pager, int tagId, ModelMap model) {
		List<TagFans> tagFansrl = tagFansService.pageBy("tagId", tagId, pager);
		List<Fans> list = new ArrayList<>(tagFansrl.size());
		tagFansrl.forEach((tagFans) -> {
			Fans fans = fansService.get(tagFans.getFansId());
			List<TagFans> tagFansList = tagFansService.listBy("fansId", tagFans.getFansId());
			List<String> tagNames = new ArrayList<>(tagFansList.size());
			tagFansList.forEach((TagFans rl) -> {
				String tagName = tagService.get(rl.getTagId()).getName();
				tagNames.add(tagName);
			});
			fans.setTagName(StringUtil.join(tagNames, ","));
			int count = blacklistService.countBy("fansId", fans.getId());
			boolean isBlack = false;
			if (count > 0) {
				isBlack = true;
			}
			fans.setBlack(isBlack);
			list.add(fans);
		});
		model.put("list", list);
		return "tag/fansTable";
	}

	@RequestMapping("/list")
	public String list() {
		return "tag/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<Tag> list = tagService.page(pager);
		model.put("list", list);
		return "tag/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = tagService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tag/add";
	}

	@RequestMapping("/add")
	public String add(Tag tag) {
		tagService.add(tag);
		return "redirect:/tag/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		Tag tag = tagService.get(id);
		model.put("tag", tag);
		return "tag/update";
	}

	@RequestMapping("/update")
	public String update(Tag tag) {
		tagService.updateName(tag);
		return "redirect:/tag/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		tagService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		tagService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	/**
	 * 批量清空标签下的粉丝
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/batchClearFans")
	public JsonResult batchClearFans(Integer[] id, ModelMap model) {
		tagService.batchClearFans(Arrays.asList(id));
		return new JsonResult();
	}

}
