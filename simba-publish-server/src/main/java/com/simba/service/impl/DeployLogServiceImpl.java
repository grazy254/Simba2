package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.DeployLogDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DeployLog;
import com.simba.service.DeployLogService;

/**
 * 部署日志 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DeployLogServiceImpl implements DeployLogService {

	@Autowired
	private DeployLogDao deployLogDao;

	@Override
	public void add(DeployLog deployLog) {
		deployLogDao.add(deployLog);
	}

	@Override
	public void delete(Long id) {
		deployLogDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DeployLog get(Long id) {
		return deployLogDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> page(Pager page) {
		return deployLogDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return deployLogDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return deployLogDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		deployLogDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> listAll() {
		return deployLogDao.listAll();
	}

	@Override
	public void update(DeployLog deployLog) {
		deployLogDao.update(deployLog);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public DeployLog getBy(String field, Object value) {
		return deployLogDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DeployLog getByAnd(String field1, Object value1, String field2, Object value2) {
		return deployLogDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DeployLog getByOr(String field1, Object value1, String field2, Object value2) {
		return deployLogDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> listBy(String field, Object value) {
		return deployLogDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> listByAnd(String field1, Object value1, String field2, Object value2) {
		return deployLogDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> listByOr(String field1, Object value1, String field2, Object value2) {
		return deployLogDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> pageBy(String field, Object value, Pager page) {
		return deployLogDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return deployLogDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeployLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return deployLogDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		deployLogDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		deployLogDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return deployLogDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return deployLogDao.countByOr(field1,value1,field2,value2);
	}
}
