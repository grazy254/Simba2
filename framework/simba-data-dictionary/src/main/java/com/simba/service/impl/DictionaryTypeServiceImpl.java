package com.simba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.cache.Redis;
import com.simba.dao.DictionaryDao;
import com.simba.dao.DictionaryTypeDao;
import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Dictionary;
import com.simba.model.DictionaryType;
import com.simba.model.form.SearchDictionaryTypeForm;
import com.simba.service.DictionaryTypeService;

/**
 * 字典类型 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DictionaryTypeServiceImpl implements DictionaryTypeService {

	@Autowired
	private DictionaryTypeDao dictionaryTypeDao;

	@Autowired
	private DictionaryDao dictionaryDao;

	@Resource
	private Redis redisUtil;

	@Override
	public void add(DictionaryType dictionaryType) {
		dictionaryTypeDao.add(dictionaryType);
	}

	@Override
	public void delete(Long id) {
		DictionaryType type = this.get(id);
		dictionaryTypeDao.delete(id);
		dictionaryDao.deleteBy("typeId", id);
		String key = "dictionary_" + type.getCode();
		redisUtil.remove(key);
	}

	@Override
	@Transactional(readOnly = true)
	public DictionaryType get(Long id) {
		return dictionaryTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> page(Pager page) {
		return dictionaryTypeDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> page(Pager page, SearchDictionaryTypeForm searchDictionaryTypeForm) {
		return dictionaryTypeDao.page(page, searchDictionaryTypeForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return dictionaryTypeDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(SearchDictionaryTypeForm searchDictionaryTypeForm) {
		return dictionaryTypeDao.count(searchDictionaryTypeForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return dictionaryTypeDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		dictionaryTypeDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> listAll() {
		return dictionaryTypeDao.listAll();
	}

	@Override
	public void update(DictionaryType dictionaryType) {
		DictionaryType type = this.get(dictionaryType.getId());
		dictionaryTypeDao.update(dictionaryType);
		if (!type.getCode().equals(dictionaryType.getCode())) {
			String key = "dictionary_" + type.getCode();
			redisUtil.remove(key);
		}
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DictionaryType getBy(String field, Object value) {
		return dictionaryTypeDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DictionaryType getByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DictionaryType getByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> listBy(String field, Object value) {
		return dictionaryTypeDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> listByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> listByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> pageBy(String field, Object value, Pager page) {
		return dictionaryTypeDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return dictionaryTypeDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DictionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return dictionaryTypeDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		dictionaryTypeDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		dictionaryTypeDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return dictionaryTypeDao.countByOr(field1, value1, field2, value2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dictionary> listByCode(String code) {
		String key = "dictionary_" + code;
		List<Dictionary> list = (List<Dictionary>) redisUtil.get(key);
		if (list != null) {
			return list;
		}
		DictionaryType type = dictionaryTypeDao.getBy("code", code);
		if (type == null) {
			throw new BussException("编码不存在");
		}
		list = dictionaryDao.listBy("typeId", type.getId());
		redisUtil.set(key, list);
		return list;
	}
}
