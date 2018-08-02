package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.FAQ;
import com.simba.model.FAQType;
import com.simba.model.form.FAQSearchForm;
import com.simba.service.FAQService;
import com.simba.service.FAQTypeService;

/**
 * 常见问题管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fAQ")
public class FAQController {

	@Autowired
	private FAQService fAQService;

	@Autowired
	private FAQTypeService fAQTypeService;

	@RequestMapping("/insertFAQ")
	public String insertFAQ(FAQ fAQ,ModelMap model) {
		List<FAQType> typeList=this.getType();
		model.put("typeList", typeList);
		fAQService.insertFAQ(fAQ);
		return "fAQ/list";
	}
	
	@ResponseBody
	@RequestMapping("/getType")
	public List<FAQType> getType() {
		List<FAQType> typeList=new ArrayList<FAQType>();
		List<FAQType> typeList1=new ArrayList<FAQType>();
	
		FAQType fAQType=new FAQType();
		fAQType.setId(0);
		fAQType.setType("请选择类型");
		typeList.add(fAQType);
		
		typeList1= fAQTypeService.listAll();
		for(int i=0;i<typeList1.size();i++){
			FAQType f=new FAQType();
			f.setId(typeList1.get(i).getId());
			f.setType(typeList1.get(i).getType());
			typeList.add(f);
		}
		return typeList;
	}
	
	// new add end !!
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<FAQType> typeList=this.getType();
		model.put("typeList", typeList);
		return "fAQ/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, FAQSearchForm searchForm,ModelMap model) {
		List<FAQ> list = fAQService.page(pager,searchForm);
		List <Map<String,Object>> lists=new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			String type=fAQTypeService.get(list.get(i).getType()).getType();
			Map<String,Object> map=new HashMap<>();
			map.put("id",String.valueOf(list.get(i).getId()));
			map.put("title",list.get(i).getTitle());
			map.put("text",list.get(i).getText());
			map.put("createTime",String.valueOf(list.get(i).getCreateTime()));
			map.put("type",type);
			lists.add(map);
		}
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		model.put("list", lists);
		return "fAQ/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = fAQService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		return "fAQ/add";
	}

	@RequestMapping("/add")
	public String add(FAQ fAQ,ModelMap model) {
		List<FAQType> typeList=this.getType();
		model.put("typeList", typeList);
		fAQService.add(fAQ);
		return "redirect:/fAQ/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		FAQ fAQ = fAQService.get(id);
		model.put("fAQ", fAQ);
		List<FAQType> typeList=this.getType();
		model.put("typeList", typeList);
		return "fAQ/update";
	}

	@RequestMapping("/update")
	public String update(FAQ fAQ,ModelMap model) {
		List<FAQType> typeList=this.getType();
		model.put("typeList", typeList);
		
		fAQService.update(fAQ);
		return "redirect:/fAQ/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fAQService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fAQService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
