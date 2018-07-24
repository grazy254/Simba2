<#list list as looseMoneyBill>
	<tr>
		<td>${looseMoneyBill.partnerTradeNo}</td>
		<td>${looseMoneyBill.openid}</td>
		<td>${looseMoneyBill.reUserName!}</td>
		<td>${looseMoneyBill.amount}</td>
		<td>${looseMoneyBill.description!}</td>
		<td>
			<#if looseMoneyBill.status == "success">
				转账成功
			<#elseif looseMoneyBill.status == "failed">
				转账失败
			<#elseif looseMoneyBill.status == "processing">
				处理中
			</#if>
		</td>
		<td>${looseMoneyBill.errMsg!}</td>
		<td>${looseMoneyBill.paymentNo!}</td>
		<td>${looseMoneyBill.paymentTime!}</td>
		<td>${looseMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${looseMoneyBill.createUser!}</td>
	</tr>
</#list>