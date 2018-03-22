package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.TagFansDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TagFans;
import com.simba.service.TagFansService;

/**
 *  Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TagFansServiceImpl implements TagFansService {

	@Autowired
	private TagFansDao tagFansDao;

	@Override
	public void add(TagFans tagFans) {
		tagFansDao.add(tagFans);
	}

	@Override
	public void delete(Integer id) {
		tagFansDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TagFans get(Integer id) {
		return tagFansDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> page(Pager page) {
		return tagFansDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return tagFansDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return tagFansDao.countBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> listAll() {
		return tagFansDao.listAll();
	}

	@Override
	public void update(TagFans tagFans) {
		tagFansDao.update(tagFans);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TagFans getBy(String field, Object value) {
		return tagFansDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TagFans getByAnd(String field1, Object value1, String field2, Object value2) {
		return tagFansDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TagFans getByOr(String field1, Object value1, String field2, Object value2) {
		return tagFansDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> listBy(String field, Object value) {
		return tagFansDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tagFansDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> listByOr(String field1, Object value1, String field2, Object value2) {
		return tagFansDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> pageBy(String field, Object value, Pager page) {
		return tagFansDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tagFansDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagFans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tagFansDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
