package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.UrlDataDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UrlData;
import com.simba.service.UrlDataService;

/**
 *  Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UrlDataServiceImpl implements UrlDataService {

	@Autowired
	private UrlDataDao urlDataDao;

	@Override
	public void add(UrlData urlData) {
		urlDataDao.add(urlData);
	}

	@Override
	public void delete(Integer id) {
		urlDataDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UrlData get(Integer id) {
		return urlDataDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> page(Pager page) {
		return urlDataDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count(Integer projectId) {
		return urlDataDao.count(projectId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return urlDataDao.countBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> listAll() {
		return urlDataDao.listAll();
	}

	@Override
	public void update(UrlData urlData) {
		urlDataDao.update(urlData);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public UrlData getBy(String field, Object value) {
		return urlDataDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UrlData getByAnd(String field1, Object value1, String field2, Object value2) {
		return urlDataDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UrlData getByOr(String field1, Object value1, String field2, Object value2) {
		return urlDataDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> listBy(String field, Object value) {
		return urlDataDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> listByAnd(String field1, Object value1, String field2, Object value2) {
		return urlDataDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> listByOr(String field1, Object value1, String field2, Object value2) {
		return urlDataDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> pageBy(String field, Object value, Pager page) {
		return urlDataDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return urlDataDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UrlData> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return urlDataDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
