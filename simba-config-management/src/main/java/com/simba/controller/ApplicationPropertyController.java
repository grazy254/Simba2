package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ApplicationProperty;
import com.simba.model.PropertyTemplate;
import com.simba.service.ApplicationPropertyService;
import com.simba.service.TemplateService;

/**
 * 应用配置表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/applicationProperty")
public class ApplicationPropertyController {

	@Autowired
	private ApplicationPropertyService applicationPropertyService;
	
	@Autowired
	private TemplateService templateService;
	
	private static final Log logger=LogFactory.getLog(ApplicationProperty.class);

	@RequestMapping("/list")
	public String list() {
		return "applicationProperty/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<ApplicationProperty> list = applicationPropertyService.page(pager);
		
		List<Map<String,Object>> newlist=new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", list.get(i).getId());
			map.put("name", list.get(i).getName());
			map.put("createTime", list.get(i).getCreateTime());
			
			map.put("template",templateService.getBy("id",list.get(i).getTemplateId()).getName());
			newlist.add(map);
		}
		
		model.put("list", newlist);
		
		return "applicationProperty/table";
	}
	
	@ResponseBody
	@RequestMapping("/getTemplate")
	public List<PropertyTemplate> getTemplate() {
		List<PropertyTemplate> templatelist=new ArrayList<PropertyTemplate>();
		List<PropertyTemplate> templatelist1=new ArrayList<PropertyTemplate>();
	
		PropertyTemplate tem=new PropertyTemplate();
		tem.setId(0);
		tem.setName("请选择类型");
		templatelist.add(tem);
		
		templatelist1= templateService.listAll();
		for(int i=0;i<templatelist1.size();i++){
			PropertyTemplate t=new PropertyTemplate();
			t.setId(templatelist1.get(i).getId());
			t.setName(templatelist1.get(i).getName());
			templatelist.add(t);
		}
		return templatelist;
		
	}
	
	@RequestMapping("/showDevProperty")
	public String showDevProperty(Long id, ModelMap model) {
		ApplicationProperty property = applicationPropertyService.get(id);
		model.put("property", property);
		return "applicationProperty/showDevProperty";
	}
	@RequestMapping("/showProdProperty")
	public String showProdProperty(Long id, ModelMap model) {
		ApplicationProperty property = applicationPropertyService.get(id);
		model.put("property", property);
		return "applicationProperty/showProdProperty";
	}
	@RequestMapping("/showTestProperty")
	public String showTestProperty(Long id, ModelMap model) {
		ApplicationProperty property = applicationPropertyService.get(id);
		model.put("property", property);
		return "applicationProperty/showTestProperty";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = applicationPropertyService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		List<PropertyTemplate> templateList=this.getTemplate();
		model.put("templateList", templateList);
		return "applicationProperty/add";
	}

	@RequestMapping("/add")
	public String add(ApplicationProperty applicationProperty) {
		applicationProperty.setCreateTime(new Date());
		applicationPropertyService.add(applicationProperty);
		return "redirect:/applicationProperty/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ApplicationProperty applicationProperty = applicationPropertyService.get(id);
		List<PropertyTemplate> templateList=this.getTemplate();
		List<Map<String, Object>> newtemplateList=new ArrayList<Map<String,Object>>();
		for(int i =0; i<templateList.size();i++){
			Map<String,Object> map=new HashMap<String ,Object>();
			map.put("id",templateList.get(i).getId());
			map.put("name",templateList.get(i).getName());
			if(templateList.get(i).getId()==applicationProperty.getTemplateId()){
				map.put("sel", "selected");
			}else{
				map.put("sel", "");
			}
			newtemplateList.add(map);
		}
		model.put("templateList", newtemplateList);
		model.put("applicationProperty", applicationProperty);
		return "applicationProperty/update";
	}
	@RequestMapping("/toUpdateDev")
	public String toUpdateDev(Long id, ModelMap model) {
		ApplicationProperty applicationProperty = applicationPropertyService.get(id);
		List<PropertyTemplate> templateList=this.getTemplate();
		List<Map<String, Object>> newtemplateList=new ArrayList<Map<String,Object>>();
		for(int i =0; i<templateList.size();i++){
			Map<String,Object> map=new HashMap<String ,Object>();
			map.put("id",templateList.get(i).getId());
			map.put("name",templateList.get(i).getName());
			if(templateList.get(i).getId()==applicationProperty.getTemplateId()){
				map.put("sel", "selected");
			}else{
				map.put("sel", "");
			}
			newtemplateList.add(map);
		}
		model.put("templateList", newtemplateList);
		model.put("applicationProperty", applicationProperty);
		return "applicationProperty/updateDev";
	}
	
	@RequestMapping("/toUpdateProd")
	public String toUpdateProd(Long id, ModelMap model) {
		ApplicationProperty applicationProperty = applicationPropertyService.get(id);
		List<PropertyTemplate> templateList=this.getTemplate();
		List<Map<String, Object>> newtemplateList=new ArrayList<Map<String,Object>>();
		for(int i =0; i<templateList.size();i++){
			Map<String,Object> map=new HashMap<String ,Object>();
			map.put("id",templateList.get(i).getId());
			map.put("name",templateList.get(i).getName());
			if(templateList.get(i).getId()==applicationProperty.getTemplateId()){
				map.put("sel", "selected");
			}else{
				map.put("sel", "");
			}
			newtemplateList.add(map);
		}
		model.put("templateList", newtemplateList);
		model.put("applicationProperty", applicationProperty);
		return "applicationProperty/updateProd";
	}
	@RequestMapping("/toUpdateTest")
	public String toUpdateTest(Long id, ModelMap model) {
		ApplicationProperty applicationProperty = applicationPropertyService.get(id);
		List<PropertyTemplate> templateList=this.getTemplate();
		List<Map<String, Object>> newtemplateList=new ArrayList<Map<String,Object>>();
		for(int i =0; i<templateList.size();i++){
			Map<String,Object> map=new HashMap<String ,Object>();
			map.put("id",templateList.get(i).getId());
			map.put("name",templateList.get(i).getName());
			if(templateList.get(i).getId()==applicationProperty.getTemplateId()){
				map.put("sel", "selected");
			}else{
				map.put("sel", "");
			}
			newtemplateList.add(map);
		}
		model.put("templateList", newtemplateList);
		model.put("applicationProperty", applicationProperty);
		return "applicationProperty/updateTest";
	}

	@RequestMapping("/update")
	public String update(ApplicationProperty applicationProperty) {
		ApplicationProperty pro=applicationPropertyService.get(applicationProperty.getId());
		pro.setDev(applicationProperty.getDev());
		pro.setProd(applicationProperty.getProd());
		pro.setTest(applicationProperty.getTest());
		pro.setCreateTime(new Date());
		
		applicationPropertyService.update(pro);
		return "redirect:/applicationProperty/list";
	}
	@RequestMapping("/updateDev")
	public String updateDev(ApplicationProperty applicationProperty) {
		ApplicationProperty pro=applicationPropertyService.get(applicationProperty.getId());
		pro.setDev(applicationProperty.getDev());
		pro.setCreateTime(new Date());
		
		applicationPropertyService.update(pro);
		return "redirect:/applicationProperty/list";
	}
	@RequestMapping("/updateTest")
	public String updateTest(ApplicationProperty applicationProperty) {
		ApplicationProperty pro=applicationPropertyService.get(applicationProperty.getId());
		pro.setTest(applicationProperty.getTest());
		pro.setCreateTime(new Date());
		
		applicationPropertyService.update(pro);
		return "redirect:/applicationProperty/list";
	}
	@RequestMapping("/updateProd")
	public String updateProd(ApplicationProperty applicationProperty) {
		ApplicationProperty pro=applicationPropertyService.get(applicationProperty.getId());
		pro.setProd(applicationProperty.getProd());
		pro.setCreateTime(new Date());
		
		applicationPropertyService.update(pro);
		return "redirect:/applicationProperty/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		applicationPropertyService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		applicationPropertyService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
	
	@RequestMapping("/auth")
	public String auth(long id) {
		ApplicationProperty property = applicationPropertyService.get(id);
		return "applicationProperty/auth";
	}

	

}
