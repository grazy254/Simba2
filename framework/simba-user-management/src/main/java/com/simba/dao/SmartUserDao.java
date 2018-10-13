package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SmartUser;
import com.simba.model.form.SmartUserSearchForm;

/**
 * 用户 Dao
 * 
 * @author caozj
 * 
 */
public interface SmartUserDao {

	long add(SmartUser smartUser);

	void update(SmartUser smartUser);
	
	void updateNoPwdTime(SmartUser smartUser);
	
	boolean updatePassword(String account,String password);
	
	boolean updatePasswordWithUserId(long UserId,String password);

	void delete(Long id);
	
	void resetPwd(String defaultPwd,Long id);

	List<SmartUser> listAll();

	Long count();

	Long countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<SmartUser> page(Pager page);

	SmartUser get(Long id);

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

	void updateBaseInfo(SmartUser smartUser);
	
	/**
	 * 标志删除用户，同时修改账号避免唯一限制
	 * @param status
	 * @param account
	 * @param id
	 */
	void updateUserDel(int status,String account,Long id);
}
