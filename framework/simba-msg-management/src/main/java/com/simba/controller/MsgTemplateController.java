package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.form.AliTemplateForm;
import com.simba.controller.form.JpushTemplateForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.MsgTemplate;
import com.simba.service.MsgTemplateService;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;

/**
 * 短信模板控制器
 *
 * @author caozj
 */
@Controller
@RequestMapping("/msgTemplate")
public class MsgTemplateController {

	@Autowired
	private MsgTemplateService templateService;

	@RequestMapping("/list")
	public String list() {
		return "msgTemplate/list";
	}

	@RequestMapping("/listJpush")
	public String listJpush() {
		return "msgTemplate/listJpush";
	}

	@RequestMapping("/listAli")
	public String listAli() {
		return "msgTemplate/listAli";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<MsgTemplate> list = templateService.page(pager);
		model.put("list", list);
		return "msgTemplate/table";
	}

	@RequestMapping("/getListAli")
	public String getListAli(Pager pager, ModelMap model) {
		List<MsgTemplate> list = templateService.page(pager);
		model.put("list", list);
		return "msgTemplate/tableAli";
	}

	@RequestMapping("/getListJpush")
	public String getListJpush(Pager pager, ModelMap model) {
		// 更新极光所有在审模板的审核状态
		try {
			templateService.updateJpushAllTemplatesStatus();
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
		List<MsgTemplate> list = templateService.page(pager);
		model.put("list", list);
		return "msgTemplate/tableJpush";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = templateService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "msgTemplate/add";
	}

	@RequestMapping("/toAddJpush")
	public String toAddJpush() {
		return "msgTemplate/addJpush";
	}

	@RequestMapping("/toAddAli")
	public String toAddAli() {
		return "msgTemplate/addAli";
	}

	@RequestMapping("/add")
	public String add(MsgTemplate template) {
		templateService.add(template);
		return "redirect:/msgTemplate/list";
	}

	@RequestMapping("/addAli")
	public String addAli(AliTemplateForm templateAli) {
		templateService.addAli(templateAli);
		return "redirect:/msgTemplate/listAli";
	}

	@RequestMapping("/addJpush")
	public String addJpush(JpushTemplateForm templatejpush) throws APIConnectionException, APIRequestException {
		templateService.addJpush(templatejpush);
		return "redirect:/msgTemplate/listJpush";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		MsgTemplate template = templateService.get(id);
		model.put("template", template);
		return "msgTemplate/update";
	}

	@RequestMapping("/toUpdateAli")
	public String toUpdateAli(Integer id, ModelMap model) {
		MsgTemplate template = templateService.get(id);
		model.put("template", template);
		return "msgTemplate/updateAli";
	}

	@RequestMapping("/toUpdateJpush")
	public String toUpdateJpush(Integer id, ModelMap model) {
		MsgTemplate template = templateService.get(id);
		model.put("template", template);
		return "msgTemplate/updateJpush";
	}

	@RequestMapping("/update")
	public String update(MsgTemplate template) {
		templateService.update(template);
		return "redirect:/msgTemplate/list";
	}

	@RequestMapping("/updateAli")
	public String updateAli(MsgTemplate template) {
		templateService.update(template);
		return "redirect:/msgTemplate/listAli";
	}

	@RequestMapping("/updateJpush")
	public String updateJpush(MsgTemplate template) {
		templateService.update(template);
		return "redirect:/msgTemplate/listJpush";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) throws APIConnectionException, APIRequestException {
		templateService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) throws APIConnectionException, APIRequestException {
		templateService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/jpushStatus")
	public String checkJpushStatus(int templateId) throws APIConnectionException, APIRequestException {
		// http://127.0.0.1:8888/template/jpushStatus?templateId=147240
		return templateService.checkStatus(templateId).getDescription();
	}

}
