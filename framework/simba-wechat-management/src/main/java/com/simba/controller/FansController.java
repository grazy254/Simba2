package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.simba.model.form.FansSearchForm;
import com.simba.service.BlacklistService;
import com.simba.service.FansService;
import com.simba.service.TagFansService;
import com.simba.service.TagService;

/**
 * 粉丝控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fans")
public class FansController {

	@Autowired
	private FansService fansService;

	@Autowired
	private TagFansService tagFansService;

	@Autowired
	private TagService tagService;

	@Autowired
	private BlacklistService blacklistService;

	@ResponseBody
	@RequestMapping("/getFanses")
	public JsonResult getFanses(String[] openids) {
		List<Map<String, Object>> list = new ArrayList<>(openids.length);
		for (String openid : openids) {
			if (StringUtils.isEmpty(openid)) {
				continue;
			}
			Fans fans = fansService.getBy("openid", openid);
			Map<String, Object> map = new HashMap<>(2);
			map.put("openid", fans.getOpenid());
			map.put("nickname", fans.getNickname());
			list.add(map);
		}
		return new JsonResult(list);
	}

	/**
	 * 选择粉丝列表
	 * 
	 * @return
	 */
	@RequestMapping("/selectedFanses")
	public String selectedFanses() {
		return "fans/selectedFanses";
	}

	@RequestMapping("/getSelectFansesList")
	public String getSelectFansesList(Pager pager, FansSearchForm searchForm, ModelMap model) {
		List<Fans> list = fansService.page(pager, searchForm);
		list.forEach((fans) -> {
			List<TagFans> tagFansList = tagFansService.listBy("fansId", fans.getId());
			List<String> tagNames = new ArrayList<>(tagFansList.size());
			tagFansList.forEach((TagFans tagFans) -> {
				String tagName = tagService.get(tagFans.getTagId()).getName();
				tagNames.add(tagName);
			});
			fans.setTagName(StringUtil.join(tagNames, ","));
			int count = blacklistService.countBy("fansId", fans.getId());
			boolean isBlack = false;
			if (count > 0) {
				isBlack = true;
			}
			fans.setBlack(isBlack);
		});
		model.put("list", list);
		return "fans/selectFansesTable";
	}

	/**
	 * 选择粉丝
	 * 
	 * @param domId
	 *            要返回openid结果的dom元素ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectFans")
	public String selectFans(String domId, ModelMap model) {
		model.put("domId", domId);
		return "fans/selectFans";
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, FansSearchForm searchForm, ModelMap model) {
		List<Fans> list = fansService.page(pager, searchForm);
		list.forEach((fans) -> {
			List<TagFans> tagFansList = tagFansService.listBy("fansId", fans.getId());
			List<String> tagNames = new ArrayList<>(tagFansList.size());
			tagFansList.forEach((TagFans tagFans) -> {
				String tagName = tagService.get(tagFans.getTagId()).getName();
				tagNames.add(tagName);
			});
			fans.setTagName(StringUtil.join(tagNames, ","));
			int count = blacklistService.countBy("fansId", fans.getId());
			boolean isBlack = false;
			if (count > 0) {
				isBlack = true;
			}
			fans.setBlack(isBlack);
		});
		model.put("list", list);
		return "fans/selectTable";
	}

	/**
	 * 进入设置标签页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toSetTag")
	public String toSetTag(int id, ModelMap model) {
		List<TagFans> tagFansList = tagFansService.listBy("fansId", id);
		List<Tag> allTagList = tagService.listAll();
		model.put("allTagList", allTagList);
		model.put("tagFansList", tagFansList);
		model.put("fansId", id);
		return "fans/toSetTag";
	}

	/**
	 * 进入批量设置标签页面
	 * 
	 * @param ids
	 * @param model
	 * @return
	 */
	@RequestMapping("/toBatchSetTag")
	public String toBatchSetTag(String ids, ModelMap model) {
		List<Tag> allTagList = tagService.listAll();
		model.put("allTagList", allTagList);
		model.put("tagFansList", new ArrayList<TagFans>(0));
		model.put("fansId", ids);
		return "fans/toSetTag";
	}

	/**
	 * 设置标签
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/setTag")
	public JsonResult setTag(Integer[] tagIds, String fansId) {
		String[] ids = fansId.split(",");
		List<Integer> tagIdList = Arrays.asList(tagIds);
		for (String id : ids) {
			if (StringUtils.isNotEmpty(id)) {
				fansService.setTag(NumberUtils.toInt(id), tagIdList);
			}
		}
		return new JsonResult();
	}

	/**
	 * 清空标签
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/clearTag")
	public JsonResult clearTag(int id) {
		fansService.clearTag(id);
		return new JsonResult();
	}

	/**
	 * 批量清空标签
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/batchClearTag")
	public JsonResult batchClearTag(Integer[] ids) {
		for (int id : ids) {
			fansService.clearTag(id);
		}
		return new JsonResult();
	}

	/**
	 * 进入设置备注页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdateRemark")
	public String toUpdateRemark(int id, ModelMap model) {
		Fans fans = fansService.get(id);
		model.put("fans", fans);
		return "fans/toUpdateRemark";
	}

	/**
	 * 设置备注
	 * 
	 * @param id
	 * @param remark
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRemark")
	public JsonResult updateRemark(int id, String remark) {
		fansService.updateRemark(id, remark);
		return new JsonResult();
	}

	/**
	 * 从微信服务器同步粉丝数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/syncFromWx")
	public JsonResult syncFromWx() {
		fansService.syncFromWx();
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list() {
		return "fans/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, FansSearchForm searchForm, ModelMap model) {
		List<Fans> list = fansService.page(pager, searchForm);
		list.forEach((fans) -> {
			List<TagFans> tagFansList = tagFansService.listBy("fansId", fans.getId());
			List<String> tagNames = new ArrayList<>(tagFansList.size());
			tagFansList.forEach((TagFans tagFans) -> {
				String tagName = tagService.get(tagFans.getTagId()).getName();
				tagNames.add(tagName);
			});
			fans.setTagName(StringUtil.join(tagNames, ","));
			int count = blacklistService.countBy("fansId", fans.getId());
			boolean isBlack = false;
			if (count > 0) {
				isBlack = true;
			}
			fans.setBlack(isBlack);
		});
		model.put("list", list);
		return "fans/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(FansSearchForm searchForm) {
		int count = fansService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "fans/add";
	}

	@RequestMapping("/add")
	public String add(Fans fans) {
		fansService.add(fans);
		return "redirect:/fans/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		Fans fans = fansService.get(id);
		model.put("fans", fans);
		return "fans/update";
	}

	@RequestMapping("/update")
	public String update(Fans fans) {
		fansService.update(fans);
		return "redirect:/fans/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		fansService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fansService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchBlack")
	public JsonResult batchBlack(Integer[] id) {
		fansService.batchBlack(Arrays.asList(id));
		return new JsonResult();
	}

}
