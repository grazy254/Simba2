package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.FastdfsException;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.IOSVersionDao;
import com.simba.framework.util.freemarker.FreemarkerUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.git.GitUtil;
import com.simba.model.IOSVersion;
import com.simba.model.constant.ConstantData;
import com.simba.service.IOSVersionService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * IOS安装包版本管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class IOSVersionServiceImpl implements IOSVersionService {

	private static final Log logger = LogFactory.getLog(IOSVersionServiceImpl.class);

	@Autowired
	private IOSVersionDao iOSVersionDao;

	@Value("${github.address}")
	private String githubAddress;

	@Value("${github.username}")
	private String githubUserName;

	@Value("${github.password}")
	private String githubPassword;

	@Value("${github.local.dir}")
	private String githubWorkDir;

	@Override
	public void add(IOSVersion iOSVersion) {
		iOSVersionDao.add(iOSVersion);
	}

	@Override
	public void add(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException {
		String ipaFileUrl = UploadUtil.getInstance().getUpload().upload(ipaFile.getBytes(), ipaFile.getOriginalFilename(), "version_uploadIOSIpaFile");
		String fullImageFileUrl = UploadUtil.getInstance().getUpload().upload(fullImageFile.getBytes(), fullImageFile.getOriginalFilename(), "version_uploadIOSFullImageFile");
		String logFileUrl = UploadUtil.getInstance().getUpload().upload(logFile.getBytes(), logFile.getOriginalFilename(), "version_uploadIOSLogFile");
		double fileSize = (double) ipaFile.getSize() / 1024 / 1024;

		iOSVersion.setFileSize(fileSize);
		iOSVersion.setIpaFileUrl(ipaFileUrl);
		iOSVersion.setFullImageFileUrl(fullImageFileUrl);
		iOSVersion.setLogFileUrl(logFileUrl);

		iOSVersion.setCreateTime(new Date());
		this.add(iOSVersion);
	}

	@Override
	public void delete(Integer id) throws IOException, FastdfsException {
		IOSVersion iosVersion = this.get(id);
		iOSVersionDao.delete(id);
		UploadUtil.getInstance().getUpload().delete(iosVersion.getFullImageFileUrl());
		UploadUtil.getInstance().getUpload().delete(iosVersion.getIpaFileUrl());
		UploadUtil.getInstance().getUpload().delete(iosVersion.getLogFileUrl());
	}

	@Override
	@Transactional(readOnly = true)
	public IOSVersion get(Integer id) {
		return iOSVersionDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> page(Pager page) {
		return iOSVersionDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return iOSVersionDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return iOSVersionDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		iOSVersionDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> listAll() {
		return iOSVersionDao.listAll();
	}

	@Override
	public void update(IOSVersion iOSVersion) {
		iOSVersionDao.update(iOSVersion);
	}

	@Override
	public void batchDelete(List<Integer> idList) throws IOException, FastdfsException {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public IOSVersion getBy(String field, Object value) {
		return iOSVersionDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public IOSVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		return iOSVersionDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public IOSVersion getByOr(String field1, Object value1, String field2, Object value2) {
		return iOSVersionDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> listBy(String field, Object value) {
		return iOSVersionDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		return iOSVersionDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		return iOSVersionDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> pageBy(String field, Object value, Pager page) {
		return iOSVersionDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return iOSVersionDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IOSVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return iOSVersionDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void update(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException {
		if (ipaFile != null && ipaFile.getSize() > 0) {
			String ipaFileUrl = UploadUtil.getInstance().getUpload().upload(ipaFile.getBytes(), ipaFile.getOriginalFilename(), "version_uploadIOSIpaFile");
			double fileSize = (double) ipaFile.getSize() / 1024 / 1024;
			UploadUtil.getInstance().getUpload().delete(iOSVersion.getIpaFileUrl());
			iOSVersion.setFileSize(fileSize);
			iOSVersion.setIpaFileUrl(ipaFileUrl);
		}
		if (fullImageFile != null && fullImageFile.getSize() > 0) {
			String fullImageFileUrl = UploadUtil.getInstance().getUpload().upload(fullImageFile.getBytes(), fullImageFile.getOriginalFilename(), "version_uploadIOSFullImageFile");
			UploadUtil.getInstance().getUpload().delete(iOSVersion.getFullImageFileUrl());
			iOSVersion.setFullImageFileUrl(fullImageFileUrl);
		}
		if (logFile != null && logFile.getSize() > 0) {
			String logFileUrl = UploadUtil.getInstance().getUpload().upload(logFile.getBytes(), logFile.getOriginalFilename(), "version_uploadIOSLogFile");
			UploadUtil.getInstance().getUpload().delete(iOSVersion.getLogFileUrl());
			iOSVersion.setLogFileUrl(logFileUrl);
		}
		iOSVersion.setCreateTime(new Date());
		this.update(iOSVersion);
	}

	@Override
	public void publish(int id) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, NoHeadException, NoMessageException,
			UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, AbortedByHookException, GitAPIException {
		IOSVersion iosVersion = this.get(id);
		Map<String, Object> params = new HashMap<>();
		String ipa = iosVersion.getIpaFileUrl();
		String fullImage = iosVersion.getFullImageFileUrl();
		String logoImage = iosVersion.getLogFileUrl();
		String identifier = iosVersion.getIdentifer();
		String version = iosVersion.getVersion();
		String title = iosVersion.getTitle();
		params.put("ipa", ipa);
		params.put("fullImage", fullImage);
		params.put("logoImage", logoImage);
		params.put("identifier", identifier);
		params.put("ipaVersion", version);
		params.put("title", title);
		String content = FreemarkerUtil.parseFile("plist.ftl", params);
		FileUtils.write(new File(githubWorkDir + "/" + "ios.plist"), content, ConstantData.DEFAULT_CHARSET);
		GitUtil.commitAndPush(githubWorkDir, iosVersion.toString(), githubUserName, githubPassword);
		logger.info("提交github成功");
	}

	@Override
	public IOSVersion getNewestVersion() {
		return iOSVersionDao.getNewestVersion();
	}

}
