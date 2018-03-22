package com.simba.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.FastdfsException;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.git.GitUtil;
import com.simba.model.IOSVersion;
import com.simba.service.IOSVersionService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * IOS安装包版本管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/iOSVersion")
public class IOSVersionController {

	private static final Log logger = LogFactory.getLog(IOSVersionController.class);

	@Autowired
	private IOSVersionService iOSVersionService;

	@Value("${github.address}")
	private String githubAddress;

	@Value("${github.username}")
	private String githubUserName;

	@Value("${github.password}")
	private String githubPassword;

	@Value("${github.local.dir}")
	private String githubWorkDir;

	@PostConstruct
	private void init() throws InvalidRemoteException, TransportException, GitAPIException {
		if (StringUtils.isEmpty(githubAddress)) {
			return;
		}
		File workDir = new File(githubWorkDir);
		if (!workDir.exists()) {
			workDir.mkdirs();
		}
		File gitFile = new File(githubWorkDir + "/" + ".git");
		if (gitFile.exists()) {
			logger.info("github已经clone，无须再次clone");
		} else {
			GitUtil.clone(githubAddress, githubWorkDir);
			logger.info("github clone " + githubAddress + " to " + githubWorkDir + " 成功");
		}
	}

	@ResponseBody
	@RequestMapping("/publish")
	public JsonResult publish(int id) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, NoHeadException, NoMessageException,
			UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, AbortedByHookException, GitAPIException {
		iOSVersionService.publish(id);
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list() {
		return "iOSVersion/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<IOSVersion> list = iOSVersionService.page(pager);
		model.put("list", list);
		return "iOSVersion/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = iOSVersionService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "iOSVersion/add";
	}

	@RequestMapping("/add")
	public String add(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException {
		iOSVersionService.add(iOSVersion, ipaFile, fullImageFile, logFile);
		return "redirect:/iOSVersion/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		IOSVersion iOSVersion = iOSVersionService.get(id);
		model.put("iOSVersion", iOSVersion);
		return "iOSVersion/update";
	}

	@RequestMapping("/update")
	public String update(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException {
		iOSVersionService.update(iOSVersion, ipaFile, fullImageFile, logFile);
		return "redirect:/iOSVersion/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) throws IOException, FastdfsException {
		iOSVersionService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) throws IOException, FastdfsException {
		iOSVersionService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}