<#list list as looseMoneyBill>
	<tr>
		<td><input type="checkbox" name="looseMoneyBill" value="${looseMoneyBill.id}"></td>
		<td>${looseMoneyBill.partnerTradeNo}</td>
		<td>${looseMoneyBill.openid}</td>
		<td>${looseMoneyBill.reUserName}</td>
		<td>${looseMoneyBill.amount}</td>
		<td>${looseMoneyBill.description}</td>
		<td>${looseMoneyBill.status}</td>
		<td>${looseMoneyBill.errMsg}</td>
		<td>${looseMoneyBill.paymentNo}</td>
		<td>${looseMoneyBill.paymentTime}</td>
		<td>${looseMoneyBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${looseMoneyBill.createUser}</td>
		<td>
			<!--
			<button type="button" class="btn btn-default btn-sm" onclick="LooseMoneyBill.toUpdate(${looseMoneyBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="LooseMoneyBill.deleteLooseMoneyBill(${looseMoneyBill.id});"><i class="fa fa-remove"></i>删除</button>
			-->
		</td>
	</tr>
</#list>