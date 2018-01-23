package com.simba.baidu.ai.model;

/**
 * ai的accesstoken对象
 * 
 * @author caozhejun
 *
 */
public class AiAccessToken {

	private String access_token;

	private String session_key;

	private String scope;

	private String session_secret;

	/**
	 * 单位为秒(30天)
	 */
	private int expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getSession_secret() {
		return session_secret;
	}

	public void setSession_secret(String session_secret) {
		this.session_secret = session_secret;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AiAccessToken [access_token=");
		builder.append(access_token);
		builder.append(", session_key=");
		builder.append(session_key);
		builder.append(", scope=");
		builder.append(scope);
		builder.append(", session_secret=");
		builder.append(session_secret);
		builder.append(", expires_in=");
		builder.append(expires_in);
		builder.append("]");
		return builder.toString();
	}

}
