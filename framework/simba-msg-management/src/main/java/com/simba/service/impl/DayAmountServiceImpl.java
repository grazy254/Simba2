package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.DayAmountDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DayAmount;
import com.simba.model.TotalDayAmountBean;
import com.simba.service.DayAmountService;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class DayAmountServiceImpl implements DayAmountService {

	@Autowired
	private DayAmountDao dayAmountDao;

	@Override
	public void add(DayAmount dayAmount) {
		dayAmountDao.add(dayAmount);
	}

	@Override
	public void delete(Long id) {
		dayAmountDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DayAmount get(Long id) {
		return dayAmountDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> page(Pager page) {
		return dayAmountDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return dayAmountDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return dayAmountDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		dayAmountDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> listAll() {
		return dayAmountDao.listAll();
	}

	@Override
	public void update(DayAmount dayAmount) {
		dayAmountDao.update(dayAmount);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DayAmount getBy(String field, Object value) {
		return dayAmountDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DayAmount getByAnd(String field1, Object value1, String field2, Object value2) {
		return dayAmountDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DayAmount getByOr(String field1, Object value1, String field2, Object value2) {
		return dayAmountDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> listBy(String field, Object value) {
		return dayAmountDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> listByAnd(String field1, Object value1, String field2, Object value2) {
		return dayAmountDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> listByOr(String field1, Object value1, String field2, Object value2) {
		return dayAmountDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> pageBy(String field, Object value, Pager page) {
		return dayAmountDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return dayAmountDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return dayAmountDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public DayAmount getLatest() {
		return dayAmountDao.getLatest();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TotalDayAmountBean> getSendAmountEachDay(Date startTime, Date endTime) {
		return dayAmountDao.getTotalAmountList(startTime, endTime);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DayAmount> getSendAmountEachDay(Date startTime, Date endTime, int projectId) {
		return dayAmountDao.getProjectAmountList(startTime, endTime, projectId);
	}

}
