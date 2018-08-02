package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.FAQDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FAQ;
import com.simba.model.form.FAQSearchForm;
import com.simba.service.FAQService;

/**
 * 常见问题管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class FAQServiceImpl implements FAQService {

	@Autowired
	private FAQDao fAQDao;

	@Override
	public void add(FAQ fAQ) {
		fAQ.setCreateTime(new Date());
		fAQDao.add(fAQ);
	}

	@Override
	public void delete(Integer id) {
		fAQDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQ get(Integer id) {
		return fAQDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> page(Pager page) {
		return fAQDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> page(Pager page, FAQSearchForm searchForm) {
		return fAQDao.page(page, searchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return fAQDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return fAQDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		fAQDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> listAll() {
		return fAQDao.listAll();
	}

	@Override
	public void update(FAQ fAQ) {
		fAQ.setCreateTime(new Date());
		fAQDao.update(fAQ);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FAQ getBy(String field, Object value) {
		return fAQDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQ getByAnd(String field1, Object value1, String field2, Object value2) {
		return fAQDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQ getByOr(String field1, Object value1, String field2, Object value2) {
		return fAQDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> listBy(String field, Object value) {
		return fAQDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> listByAnd(String field1, Object value1, String field2, Object value2) {
		return fAQDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> listByOr(String field1, Object value1, String field2, Object value2) {
		return fAQDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> pageBy(String field, Object value, Pager page) {
		return fAQDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return fAQDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQ> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return fAQDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public Integer count(FAQSearchForm searchForm) {
		return fAQDao.count(searchForm);
	}

}
