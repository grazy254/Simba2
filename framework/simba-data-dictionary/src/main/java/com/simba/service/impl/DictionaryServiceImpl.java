package com.simba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.cache.Redis;
import com.simba.dao.DictionaryDao;
import com.simba.dao.DictionaryTypeDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Dictionary;
import com.simba.model.DictionaryType;
import com.simba.service.DictionaryService;

/**
 * 字典 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	@Autowired
	private DictionaryTypeDao dictionaryTypeDao;

	@Resource
	private Redis redisUtil;

	@Override
	public void add(Dictionary dictionary) {
		dictionaryDao.add(dictionary);
		DictionaryType type = dictionaryTypeDao.get(dictionary.getTypeId());
		String key = "dictionary_" + type.getCode();
		redisUtil.remove(key);
	}

	@Override
	public void delete(Long id) {
		Dictionary dictionary = this.get(id);
		dictionaryDao.delete(id);
		DictionaryType type = dictionaryTypeDao.get(dictionary.getTypeId());
		String key = "dictionary_" + type.getCode();
		redisUtil.remove(key);
	}

	@Override
	@Transactional(readOnly = true)
	public Dictionary get(Long id) {
		return dictionaryDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> page(Pager page) {
		return dictionaryDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return dictionaryDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return dictionaryDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		dictionaryDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> listAll() {
		return dictionaryDao.listAll();
	}

	@Override
	public void update(Dictionary dictionary) {
		dictionaryDao.update(dictionary);
		DictionaryType type = dictionaryTypeDao.get(dictionary.getTypeId());
		String key = "dictionary_" + type.getCode();
		redisUtil.remove(key);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Dictionary getBy(String field, Object value) {
		return dictionaryDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Dictionary getByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Dictionary getByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> listBy(String field, Object value) {
		return dictionaryDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> listByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> listByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> pageBy(String field, Object value, Pager page) {
		return dictionaryDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return dictionaryDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dictionary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return dictionaryDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		dictionaryDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		dictionaryDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryDao.countByOr(field1, value1, field2, value2);
	}
}
