<#list list as cardMoneyBill>
	<tr>
		<td>${cardMoneyBill.partnerTradeNo}</td>
		<td>${cardMoneyBill.bankNo}</td>
		<td>${cardMoneyBill.trueName!}</td>
		<td>${cardMoneyBill.bankCode!}</td>
		<td>${cardMoneyBill.amount}</td>
		<td>${cardMoneyBill.description!}</td>
		<td>
			<#if cardMoneyBill.status == "SUCCESS">
				转账成功
			<#elseif cardMoneyBill.status == "FAILED">
				转账失败
			<#elseif cardMoneyBill.status == "PROCESSING">
				处理中
			<#elseif cardMoneyBill.status == "BANK_FAIL">
				银行退票
			</#if>
		</td>
		<td>${cardMoneyBill.errMsg!}</td>
		<td>${cardMoneyBill.paymentNo!}</td>
		<td>${cardMoneyBill.cmmsAmt!}</td>
		<td>${cardMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${cardMoneyBill.createUser!}</td>
	</tr>
</#list>