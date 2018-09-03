package com.simba.controller.api;

import com.simba.framework.util.json.JsonResult;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.ApkVersion;
import com.simba.service.ApkVersionService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * create by shuoGG
 *
 * Android apk 文件Api
 */
@Controller
@RequestMapping("/api/apk")
public class ApkController {

	private static final Log logger = LogFactory.getLog(ApkController.class);

	@Autowired
	private ApkVersionService apkVersionService;

	/**
	 * 获取最新版本信息
	 * 
	 * @param typeId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getVersionInfo")
	public JsonResult getVersionInfo(int typeId, ModelMap model) {
		ApkVersion version = apkVersionService.getNewest(typeId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("version", version.getVersion());
		resultMap.put("versionName", version.getVersionName());
		resultMap.put("fileSize", version.getFileSize());
		resultMap.put("fileUrl", version.getFileUrl());
		resultMap.put("description", version.getDescription());
		resultMap.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(version.getCreateTime()));
		return new JsonResult(resultMap);
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
		ApkVersion version = apkVersionService.getNewest(typeId);
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
