package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.SmartGroupDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SmartGroup;
import com.simba.service.SmartGroupService;

/**
 * 分组表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class SmartGroupServiceImpl implements SmartGroupService {

	@Autowired
	private SmartGroupDao smartGroupDao;

	@Override
	public void add(SmartGroup smartGroup) {
		smartGroup.setCreateTime(new Date());
		smartGroup.setType(0);
		smartGroup.setStatus(0);
		smartGroupDao.add(smartGroup);
	}

	@Override
	public void delete(Long id) {
		smartGroupDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartGroup get(Long id) {
		return smartGroupDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> page(Pager page) {
		return smartGroupDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return smartGroupDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return smartGroupDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		smartGroupDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> listAll() {
		return smartGroupDao.listAll();
	}

	@Override
	public void update(SmartGroup smartGroup) {
		smartGroup.setCreateTime(new Date());
		smartGroupDao.update(smartGroup);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public SmartGroup getBy(String field, Object value) {
		return smartGroupDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartGroup getByAnd(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartGroup getByOr(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> listBy(String field, Object value) {
		return smartGroupDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> listByAnd(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> listByOr(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> pageBy(String field, Object value, Pager page) {
		return smartGroupDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return smartGroupDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return smartGroupDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		smartGroupDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		smartGroupDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return smartGroupDao.countByOr(field1, value1, field2, value2);
	}
}
