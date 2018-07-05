package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simba.dao.PointDetailDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PointDetail;
import com.simba.service.PointDetailService;

/**
 * null Service实现类
 * 
 * @author lilei
 * 
 */
@Service
@Transactional
public class PointDetailServiceImpl implements PointDetailService {

	@Autowired
	private PointDetailDao pointDetailDao;

	
	@RequestMapping("/pointDetailList")
	public String pointDetailList() {
		return "pointDetail/list";
	}
	
	
	@Override
	public void add(PointDetail pointDetail) {
		//积分变动写入数据表
		pointDetail.setCreateTime(new Date());
		
		pointDetailDao.add(pointDetail);
	}

	@Override
	public void delete(Long id) {
		pointDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PointDetail get(Long id) {
		return pointDetailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> page(Pager page) {
		return pointDetailDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return pointDetailDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return pointDetailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		pointDetailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> listAll() {
		return pointDetailDao.listAll();
	}

	@Override
	public void update(PointDetail pointDetail) {
		pointDetailDao.update(pointDetail);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public PointDetail getBy(String field, Object value) {
		return pointDetailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public PointDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		return pointDetailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public PointDetail getByOr(String field1, Object value1, String field2, Object value2) {
		return pointDetailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> listBy(String field, Object value) {
		return pointDetailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		return pointDetailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		return pointDetailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> pageBy(String field, Object value, Pager page) {
		return pointDetailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return pointDetailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return pointDetailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		pointDetailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		pointDetailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return pointDetailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return pointDetailDao.countByOr(field1,value1,field2,value2);
	}
}
