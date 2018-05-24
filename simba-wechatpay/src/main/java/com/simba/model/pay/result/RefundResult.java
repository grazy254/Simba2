package com.simba.model.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 退款结果通知对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class RefundResult {

	/**
	 * SUCCESS/FAIL
	 * 
	 * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 * 
	 */
	private String return_code;

	/**
	 * 返回信息，如非空，为错误原因 签名失败 参数格式校验错误
	 */
	private String return_msg;

	/**
	 * 微信支付分配的公众账号ID（企业号corpid即为此appId）
	 */
	private String appid;

	/**
	 * 微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 随机字符串，长度要求在32位以内。
	 */
	private String nonce_str;

	/**
	 * 加密信息请用商户秘钥进行解密
	 */
	private String req_info;

	public String getReq_info() {
		return req_info;
	}

	public void setReq_info(String req_info) {
		this.req_info = req_info;
	}

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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundResult [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", appid=");
		builder.append(appid);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", nonce_str=");
		builder.append(nonce_str);
		builder.append(", req_info=");
		builder.append(req_info);
		builder.append("]");
		return builder.toString();
	}

}
