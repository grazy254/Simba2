package com.simba.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.model.IOSVersion;
import com.simba.service.IOSVersionService;

/**
 * ios版本管理相关Controller
 * 
 * @author caozhejun
 *
 */
@Controller
@RequestMapping("/user/ios")
public class IosController {

	@Value("${ios.plist.url}")
	private String iosUrl;

	@Autowired
	private IOSVersionService iOSVersionService;

	/**
	 * 进入ios下载安装包界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/download")
	public String download(ModelMap model) {
		IOSVersion version = iOSVersionService.getNewestVersion();
		model.put("url", iosUrl);
		model.put("fileSize", version.getFileSize());
		model.put("fileName", version.getTitle());
		return "iosDownload";
	}

	/**
	 * 获取ios版本的最新安装包信息
	 * 
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getVersionInfo")
	public Map<String, Object> getVersionInfo(ModelMap model) {
		IOSVersion version = iOSVersionService.getNewestVersion();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("version", version.getVersion());
		resultMap.put("verdescription", version.getDescription());
		return resultMap;
	}

}
