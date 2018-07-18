package com.simba.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.freemarker.FreemarkerUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.DictionaryType;
import com.simba.model.form.SearchDictionaryTypeForm;
import com.simba.service.DictionaryService;
import com.simba.service.DictionaryTypeService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * 字典类型控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/dictionaryType")
public class DictionaryTypeController {

	private static final Log logger = LogFactory.getLog(DictionaryTypeController.class);

	@Autowired
	private DictionaryTypeService dictionaryTypeService;

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 导出sql脚本文件
	 * 
	 * @param response
	 * @throws TemplateException
	 * @throws IOException
	 * @throws ParseException
	 * @throws MalformedTemplateNameException
	 * @throws TemplateNotFoundException
	 */
	@RequestMapping("/exportSql")
	public void exportSql(HttpServletResponse response) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> param = new HashMap<>();
		param.put("types", dictionaryTypeService.listAll());
		param.put("dictionaries", dictionaryService.listAll());
		String sql = FreemarkerUtil.parseFile("dictionarysql.ftl", param);
		OutputStream out = null;
		InputStream in = null;
		String fileName = "dictionary.sql";
		try {
			logger.info("下载文件:" + fileName);
			out = response.getOutputStream();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			in = IOUtils.toInputStream(sql);
			IOUtils.copy(in, out);
		} catch (Exception e) {
			logger.error("下载文件:[" + fileName + "]出现异常", e);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}

	@RequestMapping("/list")
	public String list() {
		return "dictionaryType/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<DictionaryType> list = dictionaryTypeService.page(pager);
		model.put("list", list);
		return "dictionaryType/typeTable";
	}

	@RequestMapping("/doSearch")
	public String getList(Pager pager, SearchDictionaryTypeForm searchDictionaryTypeForm, ModelMap model) {
		List<DictionaryType> list = dictionaryTypeService.page(pager, searchDictionaryTypeForm);
		model.put("list", list);
		return "dictionaryType/typeTable";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(SearchDictionaryTypeForm searchDictionaryTypeForm) {
		Long count = dictionaryTypeService.count(searchDictionaryTypeForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "dictionaryType/add";
	}

	@RequestMapping("/add")
	public String add(DictionaryType dictionaryType) {
		dictionaryTypeService.add(dictionaryType);
		return "redirect:/dictionaryType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DictionaryType dictionaryType = dictionaryTypeService.get(id);
		model.put("dictionaryType", dictionaryType);
		return "dictionaryType/update";
	}

	@RequestMapping("/update")
	public String update(DictionaryType dictionaryType) {
		dictionaryTypeService.update(dictionaryType);
		return "redirect:/dictionaryType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		dictionaryTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		dictionaryTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
