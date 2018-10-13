package com.simba.enterprise.pay.model.publickey;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 获取RSA加密公钥的响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class PublicKeyRes {

	/**
	 * 返回状态码 (SUCCESS/FAIL
	 * 
	 * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断 )
	 */
	private String return_code;

	/**
	 * 返回信息，如非空，为错误原因
	 * 
	 * 签名失败
	 * 
	 * 参数格式校验错误
	 * 
	 */
	private String return_msg;

	/**
	 * 业务结果(SUCCESS/FAIL)
	 */
	private String result_code;

	/**
	 * 错误代码 (错误码信息 )
	 */
	private String err_code;

	/**
	 * 错误代码描述 (结果信息描述 )
	 */
	private String err_code_des;

	/**
	 * 商户号
	 */
	private String mch_id;

	/**
	 * RSA 公钥
	 */
	private String pub_key;

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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getPub_key() {
		return pub_key;
	}

	public void setPub_key(String pub_key) {
		this.pub_key = pub_key;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicKeyRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_code_des=");
		builder.append(err_code_des);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", pub_key=");
		builder.append(pub_key);
		builder.append("]");
		return builder.toString();
	}

}
