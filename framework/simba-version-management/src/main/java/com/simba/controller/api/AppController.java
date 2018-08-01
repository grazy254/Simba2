package com.simba.controller.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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

import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.FileVersion;
import com.simba.service.FileVersionService;

@Controller
@RequestMapping("/api/app")
public class AppController {

	private static final Log logger = LogFactory.getLog(AppController.class);

	@Autowired
	private FileVersionService fileVersionService;

	/**
	 * 获取最新版本信息
	 * 
	 * @param typeId
	 *            1: android 2: ios
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getVersionInfo")
	public Map<String, Object> getVersionInfo(int typeId, ModelMap model) {
		FileVersion version = fileVersionService.getNewest(typeId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("version", version.getVersion());
		resultMap.put("fileSize", version.getFileSize());
		resultMap.put("fileUrl", version.getFileUrl());
		resultMap.put("description", version.getDescription());
		resultMap.put("extProps", version.getExtProps());
		resultMap.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(version.getCreateTime()));
		return resultMap;
	}

	/**
	 * 下载最新版本
	 * 
	 * @param typeId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/download")
	public void download(int typeId, HttpServletResponse response) throws Exception {
		FileVersion version = fileVersionService.getNewest(typeId);
		String fileName = version.getFileUrl();
		long filesize = UploadUtil.getInstance().getUpload().size(fileName);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setHeader("Content-Length", String.valueOf(filesize));
		InputStream in = null;
		OutputStream out = null;
		try {
			in = UploadUtil.getInstance().getUpload().download(fileName);
			out = response.getOutputStream();
			IOUtils.copy(in, out);
		} catch (Exception e) {
			logger.error("下载最新文件异常:" + typeId, e);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}
