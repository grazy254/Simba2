package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.WxMenuDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.WxMenu;
import com.simba.service.WxMenuService;

/**
 * 微信菜单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class WxMenuServiceImpl implements WxMenuService {

	@Autowired
	private WxMenuDao wxMenuDao;

	@Override
	public void add(WxMenu wxMenu) {
		wxMenuDao.add(wxMenu);
	}

	@Override
	public void delete(Integer id) {
		if (wxMenuDao.countBy("parentID", id) > 0) {
			throw new RuntimeException("此记录下有子记录，不能删除，请先删除子记录");
		}
		wxMenuDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public WxMenu get(Integer id) {
		return wxMenuDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> page(Pager page) {
		return wxMenuDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return wxMenuDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return wxMenuDao.countBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> listAll() {
		return wxMenuDao.listAll();
	}

	@Override
	public void update(WxMenu wxMenu) {
		wxMenuDao.update(wxMenu);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public WxMenu getBy(String field, Object value) {
		return wxMenuDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public WxMenu getByAnd(String field1, Object value1, String field2, Object value2) {
		return wxMenuDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public WxMenu getByOr(String field1, Object value1, String field2, Object value2) {
		return wxMenuDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> listBy(String field, Object value) {
		return wxMenuDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> listByAnd(String field1, Object value1, String field2, Object value2) {
		return wxMenuDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> listByOr(String field1, Object value1, String field2, Object value2) {
		return wxMenuDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> pageBy(String field, Object value, Pager page) {
		return wxMenuDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return wxMenuDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WxMenu> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return wxMenuDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
