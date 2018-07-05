package com.simba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.exception.BussException;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.common.UUIDUtil;
import com.simba.framework.util.file.FileUtils;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ProjectVersion;
import com.simba.service.ProjectVersionService;

/**
 * 项目版本控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/projectVersion")
public class ProjectVersionController {

	private static final Log logger = LogFactory.getLog(ProjectVersionController.class);

	@Autowired
	private ProjectVersionService projectVersionService;

	@RequestMapping("/list")
	public String list() {
		return "projectVersion/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<ProjectVersion> list = projectVersionService.page(pager);
		model.put("list", list);
		return "projectVersion/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = projectVersionService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "projectVersion/add";
	}

	@RequestMapping("/add")
	public String add(ProjectVersion projectVersion, MultipartFile file) throws IllegalStateException, IOException {
		checkFile(file);
		String filePath = SystemUtil.getUserDir() + "/" + UUIDUtil.get() + "_" + projectVersion.getVersionNo() + ".zip";
		file.transferTo(new File(filePath));
		projectVersion.setCreateTime(new Date());
		projectVersion.setFilePath(filePath);
		projectVersionService.add(projectVersion);
		return "redirect:/projectVersion/list";
	}

	private void checkFile(MultipartFile file) {
		if (file == null || file.getSize() == 0) {
			throw new BussException("文件不能为空");
		}
		checkExt(file);
	}

	private void checkExt(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String ext = FileUtils.getFileExt(fileName);
		if (!"zip".equalsIgnoreCase(ext)) {
			throw new BussException("文件只能是zip格式");
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		ProjectVersion projectVersion = projectVersionService.get(id);
		model.put("projectVersion", projectVersion);
		return "projectVersion/update";
	}

	@RequestMapping("/update")
	public String update(ProjectVersion projectVersion, MultipartFile file) throws IllegalStateException, IOException {
		if (file != null && file.getSize() > 0) {
			checkExt(file);
			String filePath = SystemUtil.getUserDir() + "/" + UUIDUtil.get() + "_" + projectVersion.getVersionNo() + ".zip";
			file.transferTo(new File(filePath));
			projectVersion.setFilePath(filePath);
		}
		projectVersion.setCreateTime(new Date());
		projectVersionService.update(projectVersion);
		return "redirect:/projectVersion/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		projectVersionService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectVersionService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/download")
	public void download(int id, HttpServletResponse response) {
		ProjectVersion projectVersion = projectVersionService.get(id);
		String filePath = projectVersion.getFilePath();
		String fileName = "simba_" + projectVersion.getVersionNo() + ".zip";
		OutputStream out = null;
		InputStream in = null;
		try {
			logger.info("下载文件:" + filePath);
			out = response.getOutputStream();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			in = new FileInputStream(filePath);
			IOUtils.copy(in, out);
		} catch (Exception e) {
			logger.error("下载文件:[" + filePath + "]出现异常", e);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}

}
