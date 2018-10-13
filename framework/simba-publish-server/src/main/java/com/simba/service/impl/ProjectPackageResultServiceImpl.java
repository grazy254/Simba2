package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ProjectPackageResultDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectPackageResult;
import com.simba.service.ProjectPackageResultService;

/**
 * 项目打包结果 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectPackageResultServiceImpl implements ProjectPackageResultService {

	@Autowired
	private ProjectPackageResultDao projectPackageResultDao;

	@Override
	public void add(ProjectPackageResult projectPackageResult) {
		projectPackageResultDao.add(projectPackageResult);
	}

	@Override
	public void delete(Integer id) {
		projectPackageResultDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectPackageResult get(Integer id) {
		return projectPackageResultDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> page(Pager page) {
		return projectPackageResultDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return projectPackageResultDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value){
		return projectPackageResultDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		projectPackageResultDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> listAll() {
		return projectPackageResultDao.listAll();
	}

	@Override
	public void update(ProjectPackageResult projectPackageResult) {
		projectPackageResultDao.update(projectPackageResult);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProjectPackageResult getBy(String field, Object value) {
		return projectPackageResultDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectPackageResult getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectPackageResultDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectPackageResult getByOr(String field1, Object value1, String field2, Object value2) {
		return projectPackageResultDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> listBy(String field, Object value) {
		return projectPackageResultDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectPackageResultDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectPackageResultDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> pageBy(String field, Object value, Pager page) {
		return projectPackageResultDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectPackageResultDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectPackageResult> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectPackageResultDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		projectPackageResultDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		projectPackageResultDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countByAnd(String field1, Object value1, String field2, Object value2){
		return projectPackageResultDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countByOr(String field1, Object value1, String field2, Object value2){
		return projectPackageResultDao.countByOr(field1,value1,field2,value2);
	}
}
