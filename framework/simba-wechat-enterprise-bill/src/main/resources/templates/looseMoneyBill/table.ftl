<#list list as looseMoneyBill>
	<tr>
		<td>${looseMoneyBill.partnerTradeNo}</td>
		<td>${looseMoneyBill.openid}</td>
		<td>${looseMoneyBill.reUserName!}</td>
		<td>${looseMoneyBill.amount}</td>
		<td>${looseMoneyBill.description!}</td>
		<td>${looseMoneyBill.status}</td>
		<td>${looseMoneyBill.errMsg!}</td>
		<td>${looseMoneyBill.paymentNo!}</td>
		<td>${looseMoneyBill.paymentTime!}</td>
		<td>${looseMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${looseMoneyBill.createUser!}</td>
	</tr>
</#list>