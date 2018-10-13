package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.IOSVersion;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * IOS安装包版本管理 Service
 * 
 * @author caozj
 * 
 */
public interface IOSVersionService {

	void add(IOSVersion iOSVersion);

	void add(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException;

	void update(IOSVersion iOSVersion);

	void delete(Integer id) throws IOException, FastdfsException;

	List<IOSVersion> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<IOSVersion> page(Pager page);

	IOSVersion get(Integer id);

	void batchDelete(List<Integer> idList) throws IOException, FastdfsException;

	IOSVersion getBy(String field, Object value);

	IOSVersion getByAnd(String field1, Object value1, String field2, Object value2);

	IOSVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> listBy(String field, Object value);

	List<IOSVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> pageBy(String field, Object value, Pager page);

	List<IOSVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<IOSVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	/**
	 * 获取最新的版本
	 * 
	 * @param typeId
	 * @return
	 */
	IOSVersion getNewestVersionByTpeId(int typeId);

	void update(IOSVersion iOSVersion, MultipartFile ipaFile, MultipartFile fullImageFile, MultipartFile logFile) throws IOException, FastdfsException;

	/**
	 * 将iso安装包App的plist文件发布到github上
	 * 
	 * @param id
	 */
	void publish(int id) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, NoHeadException, NoMessageException, UnmergedPathsException,
			ConcurrentRefUpdateException, WrongRepositoryStateException, AbortedByHookException, GitAPIException;

}
