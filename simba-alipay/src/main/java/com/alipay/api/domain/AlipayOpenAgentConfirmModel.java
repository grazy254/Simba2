package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 提交代商户签约、创建应用事务
 *
 * @author auto create
 * @since 1.0, 2018-01-25 00:32:57
 */
public class AlipayOpenAgentConfirmModel extends AlipayObject {

	private static final long serialVersionUID = 2738743293499953371L;

	/**
	 * ISV 代商户操作事务编号，通过事务开启接口alipay.open.agent.create调用返回。
	 */
	@ApiField("batch_no")
	private String batchNo;

	public String getBatchNo() {
		return this.batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

}
