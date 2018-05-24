package com.simba.wallet.util;

import com.simba.exception.BussException;

public class ErrConfig {
	public final static BussException USER_EXIST_ERR = new BussException("用户已存在");
	public final static BussException ACCOUNT_EXIST_ERR = new BussException("账户已存在");

	public final static BussException USER_NOT_EXIST_ERR = new BussException("用户不存在");

	public final static BussException ACCOUNT_NOT_EXIST_ERR = new BussException("账号不存在");
	public final static BussException DEPARTMENT_NOT_EXIST_ERR = new BussException("交易部门不存在");
	public final static BussException CHANNEL_NOT_EXIST_ERR = new BussException("交易渠道不存在");

}
