<#list list as cardMoneyBill>
	<tr>
		<td>${cardMoneyBill.partnerTradeNo}</td>
		<td>${cardMoneyBill.bankNo}</td>
		<td>${cardMoneyBill.trueName!}</td>
		<td>${cardMoneyBill.bankCode!}</td>
		<td>${cardMoneyBill.amount}</td>
		<td>${cardMoneyBill.description!}</td>
		<td>
			<#if cardMoneyBill.status == "success">
				转账成功
			<#elseif cardMoneyBill.status == "failed">
				转账失败
			<#elseif cardMoneyBill.status == "processing">
				处理中
			</#if>
		</td>
		<td>${cardMoneyBill.errMsg!}</td>
		<td>${cardMoneyBill.paymentNo!}</td>
		<td>${cardMoneyBill.cmmsAmt!}</td>
		<td>${cardMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${cardMoneyBill.createUser!}</td>
	</tr>
</#list>