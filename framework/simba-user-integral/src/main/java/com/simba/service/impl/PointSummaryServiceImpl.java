package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simba.dao.PointSummaryDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PointSummary;
import com.simba.service.PointSummaryService;

/**
 * null Service实现类
 * 
 * @author lilei
 * 
 */
@Service
@Transactional
public class PointSummaryServiceImpl implements PointSummaryService {

	@Autowired
	private PointSummaryDao pointSummaryDao;

	@RequestMapping("/pointSummaryList")
	public String pointSummaryList() {
		return "pointSummary/list";
	}
	
	
	@Override
	public void add(PointSummary pointSummary) {
		pointSummaryDao.add(pointSummary);
	}

	@Override
	public void delete(Long id) {
		pointSummaryDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PointSummary get(Long id) {
		return pointSummaryDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> page(Pager page) {
		return pointSummaryDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return pointSummaryDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return pointSummaryDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		pointSummaryDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> listAll() {
		return pointSummaryDao.listAll();
	}

	@Override
	public void update(PointSummary pointSummary) {
		pointSummaryDao.update(pointSummary);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public PointSummary getBy(String field, Object value) {
		return pointSummaryDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public PointSummary getByAnd(String field1, Object value1, String field2, Object value2) {
		return pointSummaryDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public PointSummary getByOr(String field1, Object value1, String field2, Object value2) {
		return pointSummaryDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> listBy(String field, Object value) {
		return pointSummaryDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> listByAnd(String field1, Object value1, String field2, Object value2) {
		return pointSummaryDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> listByOr(String field1, Object value1, String field2, Object value2) {
		return pointSummaryDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> pageBy(String field, Object value, Pager page) {
		return pointSummaryDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return pointSummaryDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointSummary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return pointSummaryDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		pointSummaryDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		pointSummaryDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return pointSummaryDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return pointSummaryDao.countByOr(field1,value1,field2,value2);
	}
}
