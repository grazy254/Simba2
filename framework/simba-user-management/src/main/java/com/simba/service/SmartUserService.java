package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
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

    Long addAndGet(SmartUser smartUser);

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
	
	/**
	 * 密码登录
	 * @param code
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 */
	JsonResult toLogin(String code, String account, String password) throws Exception;
	
	/**
	 * 短信验证码登录
	 * @param code
	 * @param mobile
	 * @param verif
	 * @return
	 * @throws Exception
	 */
	JsonResult toLoginVerif(String mobile) throws Exception;
	
	/**
	 * 用户登录，如没有注册，引导注册
	 * @param mobile
	 * @return
	 */
	JsonResult toLoginVerifAndRegister(String mobile);
	
	/**
	 * 完善用户信息
	 * @param id
	 * @param name
	 * @param password
	 * @return
	 */
	JsonResult finishInfo(long id,String name ,String password,String code) throws Exception;
	
	/**注册
	 * 
	 * @param code
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 */
	JsonResult toRegisterApp(String code, String account, String password) throws Exception;
	
	/**
	 * 重置密码（使用旧密码重置）
	 * @param code
	 * @param account
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	JsonResult toResetPasswordApp(String code, String account, String oldPassword, String newPassword) throws Exception;
	
	/**
	 * 重置密码
	 * @param code
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	JsonResult toResetPasswordWithUserIdApp(String code, long userId, String oldPassword, String newPassword) throws Exception;

	/**
	 * 找回密码
	 * @param code
	 * @param account
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	JsonResult toFindPasswordApp(String code, String account, String newPassword) throws Exception;
	
	/**
	 * 通过userId找手机号
	 * @param userId
	 * @return
	 */
	JsonResult getMobileByUserId(long userId);
	
	/**
	 * 通过手机号判断用户是否注册
	 * @param mobile
	 * @return
	 */
	JsonResult isRegByMobile(String mobile);
	
	/**
	 * 根据UserId更新昵称
	 * @param name
	 * @param userId
	 * @return
	 */
	JsonResult updateName(String name,long userId);
	
	/**
	 * 根据UserId更新昵称
	 * @param name
	 * @param userId
	 * @return
	 */
	JsonResult updateHeadPic(String headPic,long userId);

	/**
	 * 改变用户的状态
	 * @param id
	 * @param changeStatus
	 * @return
	 */
	JsonResult changeStatus(Long id, Integer changeStatus);
	
	void updateBaseInfo(SmartUser smartUser);
	
}
