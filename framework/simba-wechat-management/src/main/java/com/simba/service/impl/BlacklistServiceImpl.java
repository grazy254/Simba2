package com.simba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.BlacklistDao;
import com.simba.dao.FansDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Blacklist;
import com.simba.model.Fans;
import com.simba.service.BlacklistService;
import com.simba.util.send.UserWxUtil;

/**
 * 黑名单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class BlacklistServiceImpl implements BlacklistService {

	@Autowired
	private BlacklistDao blacklistDao;

	@Autowired
	private FansDao fansDao;

	@Autowired
	private UserWxUtil userWxUtil;

	@Override
	public void add(Blacklist blacklist) {
		blacklistDao.add(blacklist);
	}

	@Override
	public void delete(Integer id) {
		Blacklist blackList = blacklistDao.get(id);
		int fansId = blackList.getFansId();
		Fans fans = fansDao.get(fansId);
		String openid = fans.getOpenid();
		List<String> openids = new ArrayList<>(1);
		openids.add(openid);
		userWxUtil.cancelBlackList(openids);
		blacklistDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Blacklist get(Integer id) {
		return blacklistDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> page(Pager page) {
		return blacklistDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return blacklistDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return blacklistDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> listAll() {
		return blacklistDao.listAll();
	}

	@Override
	public void update(Blacklist blacklist) {
		blacklistDao.update(blacklist);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Blacklist getBy(String field, Object value) {
		return blacklistDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Blacklist getByAnd(String field1, Object value1, String field2, Object value2) {
		return blacklistDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Blacklist getByOr(String field1, Object value1, String field2, Object value2) {
		return blacklistDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> listBy(String field, Object value) {
		return blacklistDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> listByAnd(String field1, Object value1, String field2, Object value2) {
		return blacklistDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> listByOr(String field1, Object value1, String field2, Object value2) {
		return blacklistDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> pageBy(String field, Object value, Pager page) {
		return blacklistDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return blacklistDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return blacklistDao.pageByOr(field1, value1, field2, value2, page);
	}

}
