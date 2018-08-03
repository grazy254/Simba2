package com.simba.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.FAQ;
import com.simba.model.form.FAQSearchForm;
import com.simba.service.FAQService;
import com.simba.service.FAQTypeService;

/**
 * 常见问题管理控制器
 * 
 * @author caozj
 * 
 */
@RestController
@RequestMapping("/api/fAQ")
public class FAQApiController {

	@Autowired
	private FAQTypeService fAQTypeService;

	@Autowired
	private FAQService fAQService;

	/**
	 * 列出所有的常见问题
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public JsonResult list() {
		return new JsonResult(fAQService.listAll());
	}

	/**
	 * 分页获取常用问题列表
	 * 
	 * @param pager
	 * @param searchForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/getList")
	public JsonResult getList(Pager pager, FAQSearchForm searchForm, ModelMap model) {
		List<FAQ> list = fAQService.page(pager, searchForm);
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			String type = fAQTypeService.get(list.get(i).getType()).getType();
			Map<String, Object> map = new HashMap<>();
			map.put("id", String.valueOf(list.get(i).getId()));
			map.put("title", list.get(i).getTitle());
			map.put("text", list.get(i).getText());
			map.put("createTime", String.valueOf(list.get(i).getCreateTime()));
			map.put("type", type);
			lists.add(map);
		}
		return new JsonResult(lists);
	}

}
