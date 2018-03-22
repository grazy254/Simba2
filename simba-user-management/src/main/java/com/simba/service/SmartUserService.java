package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SmartUser;
import com.simba.model.enums.ThirdSystemType;
import com.simba.model.form.SmartUserSearchForm;

/**
 * 用户 Service
 * 
 * @author caozj
 * 
 */
public interface SmartUserService {

	void add(SmartUser smartUser);

	void update(SmartUser smartUser);

	void updateNoPwdTime(SmartUser smartUser);

	boolean updatePassword(String account, String password);
	
	boolean updatePasswordWithUserId(long UserId, String password);

	void delete(Long id);

	List<SmartUser> listAll();

	Long count();

	Long countBy(String field, Object value);

	void resetPwd(long id);

	void deleteBy(String field, Object value);

	List<SmartUser> page(Pager page);

	SmartUser get(Long id);

	void batchDelete(List<Long> idList);

	SmartUser getBy(String field, Object value);

	SmartUser getByAnd(String field1, Object value1, String field2, Object value2);

	SmartUser getByOr(String field1, Object value1, String field2, Object value2);

	List<SmartUser> listBy(String field, Object value);

	List<SmartUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<SmartUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<SmartUser> pageBy(String field, Object value, Pager page);

	List<SmartUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<SmartUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	Long count(SmartUserSearchForm searchForm);

	List<SmartUser> page(Pager pager, SmartUserSearchForm searchForm);

	Long addRegister(SmartUser smartUser);

	/**
	 * 增加一个微信用户
	 * 
	 * @param openid
	 *            微信用户openid
	 * @return
	 */
	Long addWxUser(String openid);

	/**
	 * 增加一个微信小程序用户
	 * 
	 * @param openid
	 *            微信 小程序用户openid
	 * @return
	 */
	Long addWxMiniUser(String openid);

	/**
	 * 新增一个第三方系统账号
	 * 
	 * @param thirdUserId
	 * @param type
	 * @return
	 */
	Long addThirdUser(String thirdUserId, ThirdSystemType type);

	/**
	 * 根据第三方系统用户id获取userId，如果不存在，则新增一个系统账号
	 * 
	 * @param thirdUserId
	 * @param thirdSystemType
	 * @return
	 */
	String getUserId(String thirdUserId, String thirdSystemType);

}
