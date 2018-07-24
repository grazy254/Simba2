<#list list as aliPayEnterpriseBill>
	<tr>
		<td>${aliPayEnterpriseBill.outBizNo}</td>
		<td>
			<#if aliPayEnterpriseBill.payType=='ALIPAY_USERID'>
				支付宝唯一用户号
			<#elseif aliPayEnterpriseBill.payType=='ALIPAY_LOGONID'>
				支付宝登录号
			</#if>
		</td>
		<td>${aliPayEnterpriseBill.account!}</td>
		<td>${aliPayEnterpriseBill.amount!}</td>
		<td>${aliPayEnterpriseBill.payerName!}</td>
		<td>${aliPayEnterpriseBill.peyeeName!}</td>
		<td>${aliPayEnterpriseBill.remark!}</td>
		<td>${aliPayEnterpriseBill.orderId!}</td>
		<td>${aliPayEnterpriseBill.payDate!}</td>
		<td>${aliPayEnterpriseBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${aliPayEnterpriseBill.createUser!}</td>
		<td>
			<#if aliPayEnterpriseBill.status=='SUCCESS'>
				成功
			<#elseif aliPayEnterpriseBill.status=='FAIL'>
				失败
			<#elseif aliPayEnterpriseBill.status=='INIT'>
				等待处理
			<#elseif aliPayEnterpriseBill.status=='DEALING'>
				处理中
			<#elseif aliPayEnterpriseBill.status=='REFUND'>
				退票
			<#elseif aliPayEnterpriseBill.status=='UNKNOWN'>
				状态未知
			</#if>
		</td>
		<td>${aliPayEnterpriseBill.reason!}</td>
	</tr>
</#list>