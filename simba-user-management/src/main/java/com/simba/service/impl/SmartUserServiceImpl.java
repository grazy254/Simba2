package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.cache.RedisUtil;
import com.simba.dao.SmartUserDao;
import com.simba.dao.ThirdSystemUserDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SmartUser;
import com.simba.model.ThirdSystemUser;
import com.simba.model.enums.ThirdSystemType;
import com.simba.model.enums.UserStatus;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.SmartUserService;

/**
 * 用户 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class SmartUserServiceImpl implements SmartUserService {

	@Value("${key}")
	private String key;

	@Value("${default.pwd}")
	private String defaultPwd;

	@Autowired
	private SmartUserDao smartUserDao;

	@Autowired
	private ThirdSystemUserDao thirdSystemUserDao;

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void add(SmartUser smartUser) {
		smartUser.setCreateTime(new Date());
		smartUser.setPassword(defaultPwd);
		smartUser.setStatus(UserStatus.ENABLED.getId());
		smartUserDao.add(smartUser);
	}

	@Override
	public Long addRegister(SmartUser smartUser) {
		smartUser.setCreateTime(new Date());
		smartUser.setStatus(UserStatus.ENABLED.getId());
		return smartUserDao.add(smartUser);
	}

	@Override
	public void delete(Long id) {
		smartUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartUser get(Long id) {
		return smartUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> page(Pager page) {
		return smartUserDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return smartUserDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return smartUserDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		smartUserDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> listAll() {
		return smartUserDao.listAll();
	}

	@Override
	public void update(SmartUser smartUser) {
		smartUser.setCreateTime(new Date());
		smartUser.setStatus(UserStatus.ENABLED.getId());
		smartUserDao.update(smartUser);
	}

	@Override
	public void updateNoPwdTime(SmartUser smartUser) {
		smartUserDao.updateNoPwdTime(smartUser);
	}

	public boolean updatePassword(String account, String password) {
		return smartUserDao.updatePassword(account, password);
	}
	
	public boolean updatePasswordWithUserId(long userId, String password) {
		return smartUserDao.updatePasswordWithUserId(userId, password);
	}

	@Override
	public void resetPwd(long id) {
		smartUserDao.resetPwd(defaultPwd, id);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public SmartUser getBy(String field, Object value) {
		return smartUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return smartUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public SmartUser getByOr(String field1, Object value1, String field2, Object value2) {
		return smartUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> listBy(String field, Object value) {
		return smartUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return smartUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return smartUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> pageBy(String field, Object value, Pager page) {
		return smartUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return smartUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SmartUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return smartUserDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public Long count(SmartUserSearchForm searchForm) {
		return smartUserDao.count(searchForm);
	}

	@Override
	public List<SmartUser> page(Pager pager, SmartUserSearchForm searchForm) {
		return smartUserDao.page(pager, searchForm);
	}

	@Override
	public Long addWxUser(String openid) {
		return addThirdUser(openid, ThirdSystemType.WX);
	}

	@Override
	public Long addWxMiniUser(String openid) {
		return addThirdUser(openid, ThirdSystemType.WXMINI);
	}

	/**
	 * 新增一个第三方用户账号
	 * 
	 * @param thirdUserId
	 * @param type
	 * @return
	 */
	public Long addThirdUser(String thirdUserId, ThirdSystemType type) {
		SmartUser smartUser = new SmartUser();
		smartUser.setAccount(type.getPrefix() + thirdUserId);
		smartUser.setCreateTime(new Date());
		smartUser.setEmail(StringUtils.EMPTY);
		smartUser.setName(StringUtils.EMPTY);
		smartUser.setPassword(StringUtils.EMPTY);
		smartUser.setStatus(UserStatus.ENABLED.getId());
		smartUser.setTelNo(StringUtils.EMPTY);
		long userId = smartUserDao.add(smartUser);
		ThirdSystemUser thirdSystemUser = new ThirdSystemUser();
		thirdSystemUser.setUserId(userId);
		thirdSystemUser.setThirdSystemUserId(thirdUserId);
		thirdSystemUser.setThirdSystem(type.getName());
		thirdSystemUserDao.add(thirdSystemUser);
		return userId;
	}

	@Override
	public String getUserId(String thirdUserId, String thirdSystemType) {
		String userId = null;
		String key = "userId_" + thirdSystemType + "_" + thirdUserId;
		userId = (String) redisUtil.get(key);
		if (StringUtils.isNotEmpty(userId)) {
			return userId;
		}
		ThirdSystemType type = ThirdSystemType.get(thirdSystemType);
		List<ThirdSystemUser> list = thirdSystemUserDao.listByAnd("thirdSystem", type.getName(), "thirdSystemUserId", thirdUserId);
		if (list.size() > 0) {
			ThirdSystemUser user = list.get(0);
			userId = user.getUserId() + StringUtils.EMPTY;
			redisUtil.set(key, userId);
			return userId;
		}
		userId = this.addThirdUser(thirdUserId, type) + StringUtils.EMPTY;
		redisUtil.set(key, userId);
		return userId;
	}
}
