package com.simba.model.pay.sandbox;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 获取沙箱key响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SandBoxRes {

	/**
	 * SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 */
	private String return_code;

	/**
	 * 返回信息，如非空，为错误原因 签名失败 参数格式校验错误
	 */
	private String return_msg;

	/**
	 * 调用接口提交的商户号
	 */
	private String mch_id;

	/**
	 * 沙箱密钥
	 */
	private String sandbox_signkey;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSandbox_signkey() {
		return sandbox_signkey;
	}

	public void setSandbox_signkey(String sandbox_signkey) {
		this.sandbox_signkey = sandbox_signkey;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SandBoxRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", sandbox_signkey=");
		builder.append(sandbox_signkey);
		builder.append("]");
		return builder.toString();
	}

}
