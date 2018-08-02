package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.OpinionFeedbackDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OpinionFeedback;
import com.simba.model.form.OpinionFeedbackSearchForm;
import com.simba.service.OpinionFeedbackService;

/**
 * 意见反馈管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class OpinionFeedbackServiceImpl implements OpinionFeedbackService {

	@Autowired
	private OpinionFeedbackDao opinionFeedbackDao;

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> page(Pager page, OpinionFeedbackSearchForm searchForm) {
		return opinionFeedbackDao.page(page, searchForm);
	}

	@Override
	public void add(OpinionFeedback opinionFeedback) {
		opinionFeedback.setCreateTime(new Date());
		opinionFeedbackDao.add(opinionFeedback);
	}

	@Override
	public void delete(Integer id) {
		opinionFeedbackDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public OpinionFeedback get(Integer id) {
		return opinionFeedbackDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> page(Pager page) {
		return opinionFeedbackDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return opinionFeedbackDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return opinionFeedbackDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		opinionFeedbackDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> listAll() {
		return opinionFeedbackDao.listAll();
	}

	@Override
	public void update(OpinionFeedback opinionFeedback) {
		opinionFeedback.setCreateTime(new Date());
		opinionFeedbackDao.update(opinionFeedback);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public OpinionFeedback getBy(String field, Object value) {
		return opinionFeedbackDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public OpinionFeedback getByAnd(String field1, Object value1, String field2, Object value2) {
		return opinionFeedbackDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public OpinionFeedback getByOr(String field1, Object value1, String field2, Object value2) {
		return opinionFeedbackDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> listBy(String field, Object value) {
		return opinionFeedbackDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> listByAnd(String field1, Object value1, String field2, Object value2) {
		return opinionFeedbackDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> listByOr(String field1, Object value1, String field2, Object value2) {
		return opinionFeedbackDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> pageBy(String field, Object value, Pager page) {
		return opinionFeedbackDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return opinionFeedbackDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpinionFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return opinionFeedbackDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public Integer count(OpinionFeedbackSearchForm searchForm) {
		return opinionFeedbackDao.count(searchForm);
	}

}
