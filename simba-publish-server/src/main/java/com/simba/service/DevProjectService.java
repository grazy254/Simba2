package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.tmatesoft.svn.core.SVNException;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DevProject;

/**
 * 项目 Service
 * 
 * @author caozj
 * 
 */
public interface DevProjectService {

	void add(DevProject devProject);

	void update(DevProject devProject);

	void delete(Integer id);

	List<DevProject> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	Integer countByAnd(String field1, Object value1, String field2, Object value2);

	Integer countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<DevProject> page(Pager page);

	DevProject get(Integer id);

	void batchDelete(List<Integer> idList);

	DevProject getBy(String field, Object value);

	DevProject getByAnd(String field1, Object value1, String field2, Object value2);

	DevProject getByOr(String field1, Object value1, String field2, Object value2);

	List<DevProject> listBy(String field, Object value);

	List<DevProject> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DevProject> listByOr(String field1, Object value1, String field2, Object value2);

	List<DevProject> pageBy(String field, Object value, Pager page);

	List<DevProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DevProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void add(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException;

	void update(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException;

	/**
	 * 打包发布
	 * 
	 * @param id
	 */
	void publishAll(int id) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException;

	/**
	 * 打包发布到指定的服务器
	 * 
	 * @param projectId
	 * @param serverIds
	 */
	void publish(int projectId, String[] serverIds) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException;

	/**
	 * 重新初始化库
	 * 
	 * @param id
	 */
	void refreshCode(int id) throws InvalidRemoteException, TransportException, GitAPIException, SVNException;

	void copy(Integer id) throws InvalidRemoteException, TransportException, GitAPIException, SVNException;

}
