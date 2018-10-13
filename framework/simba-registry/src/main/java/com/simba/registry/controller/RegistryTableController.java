package com.simba.registry.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
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
import com.simba.model.constant.ConstantData;
import com.simba.registry.model.RegistryTable;
import com.simba.registry.model.RegistryType;
import com.simba.registry.service.RegistryTableService;
import com.simba.registry.service.RegistryTypeService;

import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * 注册表 Controller
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/registryTable")
public class RegistryTableController {

	private static final Log logger = LogFactory.getLog(RegistryTableController.class);

	@Autowired
	private RegistryTableService registryTableService;

	@Autowired
	private RegistryTypeService registryTypeService;

	@RequestMapping("/list")
	public String list(Integer typeID, ModelMap model) {
		String typeName = "注册类型树";
		if (typeID == null) {
			typeID = ConstantData.TREE_ROOT_ID;
		}
		if (typeID != ConstantData.TREE_ROOT_ID) {
			typeName = registryTypeService.get(typeID).getText();
		}
		model.put("typeID", typeID);
		model.put("typeName", typeName);
		return "registryTable/list";
	}

	@RequestMapping("/getList")
	public String getList(int typeID, Pager pager, ModelMap model) {
		model.put("list", registryTableService.pageBy("typeID", typeID, pager));
		return "registryTable/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(int typeID) {
		int count = registryTableService.countBy("typeID", typeID);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(int typeID, ModelMap model) {
		String typeName = "注册类型树";
		if (typeID != ConstantData.TREE_ROOT_ID) {
			typeName = registryTypeService.get(typeID).getText();
		}
		model.put("typeID", typeID);
		model.put("typeName", typeName);
		return "registryTable/add";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		RegistryTable registryTable = registryTableService.get(id);
		String typeName = "注册类型树";
		if (registryTable.getTypeID() != ConstantData.TREE_ROOT_ID) {
			typeName = registryTypeService.get(registryTable.getTypeID()).getText();
		}
		model.put("registryTable", registryTable);
		model.put("typeName", typeName);
		return "registryTable/update";
	}

	@RequestMapping("/add")
	public String add(RegistryTable registryTable, ModelMap model) {
		registryTableService.add(registryTable);
		return "redirect:/registryTable/list?typeID=" + registryTable.getTypeID();
	}

	@RequestMapping("/update")
	public String update(RegistryTable registryTable, ModelMap model) {
		registryTableService.update(registryTable);
		return "redirect:/registryTable/list?typeID=" + registryTable.getTypeID();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] ids, ModelMap model) {
		List<Integer> idList = Arrays.asList(ids);
		registryTableService.batchDelete(idList);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		registryTableService.delete(id);
		return new JsonResult();
	}

	/**
	 * 导出sql脚本
	 * 
	 * @param response
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping("/exportSql")
	public void exportSql(HttpServletResponse response) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<RegistryTable> allTable = registryTableService.listAll();
		List<RegistryType> allType = registryTypeService.listAll();
		Map<String, Object> param = new HashMap<>();
		param.put("allTable", allTable);
		param.put("allType", allType);
		String sql = FreemarkerUtil.parseFile("registrysql.ftl", param);
		OutputStream out = null;
		InputStream in = null;
		String fileName = "registry.sql";
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

}
