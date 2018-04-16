<#list list as cardMoneyBill>
	<tr>
		<td><input type="checkbox" name="cardMoneyBill" value="${cardMoneyBill.id}"></td>
		<td>${cardMoneyBill.partnerTradeNo}</td>
		<td>${cardMoneyBill.bankNo}</td>
		<td>${cardMoneyBill.trueName}</td>
		<td>${cardMoneyBill.bankCode}</td>
		<td>${cardMoneyBill.amount}</td>
		<td>${cardMoneyBill.description}</td>
		<td>${cardMoneyBill.status}</td>
		<td>${cardMoneyBill.errMsg}</td>
		<td>${cardMoneyBill.paymentNo}</td>
		<td>${cardMoneyBill.cmmsAmt}</td>
		<td>${cardMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${cardMoneyBill.createUser}</td>
		<td>
			<!--
			<button type="button" class="btn btn-default btn-sm" onclick="CardMoneyBill.toUpdate(${cardMoneyBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="CardMoneyBill.deleteCardMoneyBill(${cardMoneyBill.id});"><i class="fa fa-remove"></i>删除</button>
			-->
		</td>
	</tr>
</#list>