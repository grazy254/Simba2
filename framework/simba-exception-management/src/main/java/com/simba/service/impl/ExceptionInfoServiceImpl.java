package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ExceptionInfoDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ExceptionInfo;
import com.simba.model.form.ExceptionInfoSearchForm;
import com.simba.service.ExceptionInfoService;

/**
 * 异常信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ExceptionInfoServiceImpl implements ExceptionInfoService {

	@Autowired
	private ExceptionInfoDao exceptionInfoDao;

	@Override
	public void add(ExceptionInfo exceptionInfo) {
		exceptionInfoDao.add(exceptionInfo);
	}

	@Override
	public void delete(Long id) {
		exceptionInfoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ExceptionInfo get(Long id) {
		return exceptionInfoDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> page(Pager page) {
		return exceptionInfoDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return exceptionInfoDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return exceptionInfoDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		exceptionInfoDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> listAll() {
		return exceptionInfoDao.listAll();
	}

	@Override
	public void update(ExceptionInfo exceptionInfo) {
		exceptionInfoDao.update(exceptionInfo);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ExceptionInfo getBy(String field, Object value) {
		return exceptionInfoDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ExceptionInfo getByAnd(String field1, Object value1, String field2, Object value2) {
		return exceptionInfoDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ExceptionInfo getByOr(String field1, Object value1, String field2, Object value2) {
		return exceptionInfoDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> listBy(String field, Object value) {
		return exceptionInfoDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> listByAnd(String field1, Object value1, String field2, Object value2) {
		return exceptionInfoDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> listByOr(String field1, Object value1, String field2, Object value2) {
		return exceptionInfoDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> pageBy(String field, Object value, Pager page) {
		return exceptionInfoDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return exceptionInfoDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExceptionInfo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return exceptionInfoDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<ExceptionInfo> page(Pager pager, ExceptionInfoSearchForm searchForm) {
		return exceptionInfoDao.page(pager, searchForm);
	}

	@Override
	public Long count(ExceptionInfoSearchForm searchForm) {
		return exceptionInfoDao.count(searchForm);
	}

}
