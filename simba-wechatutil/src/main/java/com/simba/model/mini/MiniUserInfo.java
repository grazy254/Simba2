package com.simba.model.mini;

/**
 * 小程序用户信息
 * 
 * @author caozhejun
 *
 */
public class MiniUserInfo {

	/**
	 * 用户唯一标识
	 */
	private String openid;

	/**
	 * 会话密钥
	 */
	private String session_key;

	/**
	 * 用户在开放平台的唯一标识符。本字段在满足一定条件的情况下才返回。
	 */
	private String unionid;

	private int errcode;

	private String errmsg;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MiniUserInfo [openid=");
		builder.append(openid);
		builder.append(", session_key=");
		builder.append(session_key);
		builder.append(", unionid=");
		builder.append(unionid);
		builder.append(", errcode=");
		builder.append(errcode);
		builder.append(", errmsg=");
		builder.append(errmsg);
		builder.append("]");
		return builder.toString();
	}

}
