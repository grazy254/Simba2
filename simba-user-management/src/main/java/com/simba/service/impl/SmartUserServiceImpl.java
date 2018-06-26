package com.simba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.cache.RedisUtil;
import com.simba.controller.UserLoginController;
import com.simba.dao.SmartUserDao;
import com.simba.dao.ThirdSystemUserDao;
import com.simba.dao.UserProjectDao;
import com.simba.exception.BussException;
import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
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

	@Autowired
	private UserProjectDao userProjectDao;
	
	private static final Log logger = LogFactory.getLog(SmartUserServiceImpl.class);

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

	///////////////////////////////////////////////////// 原userLoginController里的方法/////////////////////////////////////////////////

	/**
	 * 密码登录
	 */
	@Override
	public JsonResult toLogin(String code, String account, String password) throws Exception {

		if(password==null || password.length()==0){
			throw new BussException("登录密码不能为空");
		}
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置[" + code + "]");
		}
		List<SmartUser> ulist = smartUserDao.listBy("account", account);
		if (ulist.size() == 0) {
			throw new BussException("账户不存在[" + account + "]");
		} else {
			// 对密码des解密 再md5
			String p = "";
			p = DesUtil.decrypt(password, sk);
			p = EncryptUtil.md5(p);
			if (!ulist.get(0).getPassword().equals(p)) {
				throw new BussException("用户名或密码错误");
			}
		}
		return new JsonResult(ulist.get(0).getId(), "登录成功", 200);
	}
	
	/**
	 * 短信验证码登录
	 */
	@Override
	public JsonResult toLoginVerif(String mobile) throws Exception {

		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(mobile);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		
		List<SmartUser> ulist = smartUserDao.listBy("account", mobile);
		if (ulist.size() == 0) {
			return new JsonResult(-1, "账号"+mobile+"不存在", 400);
		} else {
			return new JsonResult(ulist.get(0).getId(), "登录成功", 200);
		}
	}
	
	/**
	 * 短信验证码登录,没有登录则注册
	 */
	@Override
	public JsonResult toLoginVerifAndRegister(String mobile){

		String regex = "^1[34578][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(mobile);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		
		List<SmartUser> ulist = smartUserDao.listBy("account", mobile);
		if (ulist.size() < 1) {
			//把手机号写入数据表中
			SmartUser user = new SmartUser();
			user.setAccount(mobile);
			user.setEmail("");
			user.setName(mobile);
			user.setPassword("");
			user.setTelNo(mobile);
			user.setSex(-1);
			user.setGroupId(0);
			user.setHeadPic("");;
			user.setThirdSystem("");
			user.setCreateTime(new Date());
			user.setStatus(0);
			smartUserDao.add(user);
			//返回用户ID
			return new JsonResult("-1",mobile+"不存在,", 400);
		} else {
			if(ulist.get(0).getPassword()==null ||ulist.get(0).getPassword().length()==0){
				return new JsonResult("-2","用户还未完善信息", 400);
			}else{
				return new JsonResult(ulist.get(0).getId(), "登录成功", 200);
			}
		}
	}
	
	/**
	 * 完善信息
	 * @throws Exception 
	 */
	@Override
	public JsonResult finishInfo(long id,String name ,String password,String code) throws Exception{
		if(name==null||name.length()==0||password==null||password.length()==0){
			throw new BussException("密码或者昵称不能为空");
		}
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		SmartUser user=smartUserDao.get(id);
		user.setName(name);
		String p = "";
		p = DesUtil.decrypt(password, sk);
		p = EncryptUtil.md5(p);
		user.setPassword(p);
		smartUserDao.update(user);
		return new JsonResult("信息完善成功",200);
	}

	/**
	 * 注册
	 */
	@Override
	public JsonResult toRegisterApp(String code, String account, String password) throws Exception {
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		SmartUser user = new SmartUser();

		// 判断此账号是否已经注册过
		if (smartUserDao.listBy("account", account).size() > 0) {
			throw new BussException("此账号已经注册，请更换账号");
		}
		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(account);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		user.setAccount(account);
		user.setName(account);
		user.setTelNo(account);
		user.setEmail("");
		user.setSex(-1);
		user.setGroupId(0);
		// 给密码解密之后再md5。
		String p = "";
		p = DesUtil.decrypt(password, sk);
		p = EncryptUtil.md5(p);
		user.setPassword(p);
		long re = addRegister(user);
		return new JsonResult(re, "注册成功", 200);
	}

	/**
	 * 使用旧密码重置密码
	 */
	@Override
	public JsonResult toResetPasswordApp(String code, String account, String oldPassword, String newPassword) throws Exception {
		// 重置密码，使用原来的密码重置
		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(account);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		// 验证密码是否正确
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		List<SmartUser> ulist = smartUserDao.listBy("account", account);
		// 给密码解密之后再md5。
		String op = "";
		String np = "";
		op = DesUtil.decrypt(oldPassword, sk);
		np = DesUtil.decrypt(newPassword, sk);
		op = EncryptUtil.md5(op);
		np = EncryptUtil.md5(np);
		if (ulist.get(0).getPassword().equals(op)) {
			if (!smartUserDao.updatePassword(account, np)) {
				throw new BussException("修改失败");
			}
		} else {
			throw new BussException("密码错误");
		}

		return new JsonResult("重置成功",200);
	}

	/**
	 * 使用userId重置密码
	 */
	@Override
	public JsonResult toResetPasswordWithUserIdApp(String code, long userId, String oldPassword, String newPassword) throws Exception {

		// 重置密码，使用原来的密码重置
		// 验证密码是否正确
		SmartUser smartUser = new SmartUser();
		smartUser = smartUserDao.get(userId);
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		// 给密码解密之后再md5。
		String op = "";
		String np = "";
		op = DesUtil.decrypt(oldPassword, sk);
		np = DesUtil.decrypt(newPassword, sk);
		op = EncryptUtil.md5(op);
		np = EncryptUtil.md5(np);
		if (smartUser.getPassword().equals(op)) {
			if (!smartUserDao.updatePasswordWithUserId(userId, np)) {
				throw new BussException("修改失败");
			}
		} else {
			throw new BussException("密码错误");
		}

		return new JsonResult("重置成功",200);
	}
	
	/**
	 * 使用短信验证码找回密码
	 */
	@Override
	public JsonResult toFindPasswordApp(String code, String account, String newPassword) throws Exception {
		// 找回密码，使用短信验证码重置
		String regex = "^1[34578][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(account);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		// 给密码解密之后再md5。
		String sk = "";
		if (userProjectDao.listBy("code", code).size() > 0) {
			sk = userProjectDao.listBy("code", code).get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		String p = "";
		p = DesUtil.decrypt(newPassword, sk);
		p = EncryptUtil.md5(p);
		if (!smartUserDao.updatePassword(account, p)) {
			throw new BussException("修改失败");
		}
		return new JsonResult("找回成功",200);
	}
	
	/**
	 * 通过手机号获取userId
	 */
	@Override
	public JsonResult getMobileByUserId(long userId) {
		List<SmartUser> smartUserList = new ArrayList<SmartUser>();
		smartUserList = smartUserDao.listBy("id", userId);
		String mobile = "";
		if (smartUserList.size() > 0) {
			mobile = smartUserList.get(0).getTelNo();
		} else {
			throw new BussException("用户没有配置手机号");
		}
		return new JsonResult(mobile, "获取手机号成功", 200);
	}
	
	/**
	 * 判断手机号是否已经注册
	 */
	@Override
	public JsonResult isRegByMobile(String mobile){
		List<SmartUser> list =smartUserDao.listBy("account", mobile);
		if(list.size()>0){
			if(list.get(0).getPassword()==null ||list.get(0).getPassword().equals("")){
				return new JsonResult("已经注册,没有完善信息",400);
			}else{
				return new JsonResult("已经注册",200);
			}
			
		}else{
			return new JsonResult("没有注册",400);
		}
	}
	
	/**
	 * 根据UserId更新昵称
	 * @param name
	 * @param userId
	 * @return
	 */
	@Override
	public JsonResult updateName(String name,long userId){
		SmartUser smartUser=new SmartUser();
		smartUser=smartUserDao.get(userId);
		smartUser.setName(name);
		smartUserDao.update(smartUser);
		return new JsonResult("更新成功",200);
	}
	
	/**
	 * 根据UserId更新头像
	 * @param name
	 * @param userId
	 * @return
	 */
	@Override
	public JsonResult updateHeadPic(String headPic,long userId){
		SmartUser smartUser=new SmartUser();
		smartUser=smartUserDao.get(userId);
		smartUser.setHeadPic(headPic);;
		smartUserDao.update(smartUser);
		return new JsonResult("更新成功",200);
	}

}
