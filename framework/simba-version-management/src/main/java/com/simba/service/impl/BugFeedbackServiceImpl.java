package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.BugFeedbackDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.BugFeedback;
import com.simba.model.form.BugFeedbackSearchForm;
import com.simba.service.BugFeedbackService;

/**
 * bug反馈管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class BugFeedbackServiceImpl implements BugFeedbackService {

	@Autowired
	private BugFeedbackDao bugFeedbackDao;

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> page(Pager page, BugFeedbackSearchForm searchForm) {
		return bugFeedbackDao.page(page, searchForm);
	}

	@Override
	public void add(BugFeedback bugFeedback) {
		bugFeedback.setCreateTime(new Date());
		bugFeedbackDao.add(bugFeedback);
	}

	@Override
	public void delete(Integer id) {
		bugFeedbackDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public BugFeedback get(Integer id) {
		return bugFeedbackDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> page(Pager page) {
		return bugFeedbackDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return bugFeedbackDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return bugFeedbackDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		bugFeedbackDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> listAll() {
		return bugFeedbackDao.listAll();
	}

	@Override
	public void update(BugFeedback bugFeedback) {
		bugFeedback.setCreateTime(new Date());
		bugFeedbackDao.update(bugFeedback);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public BugFeedback getBy(String field, Object value) {
		return bugFeedbackDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public BugFeedback getByAnd(String field1, Object value1, String field2, Object value2) {
		return bugFeedbackDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public BugFeedback getByOr(String field1, Object value1, String field2, Object value2) {
		return bugFeedbackDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> listBy(String field, Object value) {
		return bugFeedbackDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> listByAnd(String field1, Object value1, String field2, Object value2) {
		return bugFeedbackDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> listByOr(String field1, Object value1, String field2, Object value2) {
		return bugFeedbackDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> pageBy(String field, Object value, Pager page) {
		return bugFeedbackDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return bugFeedbackDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BugFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return bugFeedbackDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public Integer count(BugFeedbackSearchForm searchForm) {
		return bugFeedbackDao.count(searchForm);
	}

}
