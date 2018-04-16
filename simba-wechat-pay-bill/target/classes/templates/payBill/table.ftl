<#list list as payBill>
	<tr>
		<td><input type="checkbox" name="payBill" value="${payBill.id}"></td>
		<td>${payBill.productDesc}</td>
		<td>${payBill.detail}</td>
		<td>${payBill.outTradeNo}</td>
		<td>${payBill.fee}</td>
		<td>${payBill.startTime}</td>
		<td>${payBill.endTime}</td>
		<td>${payBill.goodsTag}</td>
		<td>${payBill.tradeType}</td>
		<td>${payBill.productId}</td>
		<td>${payBill.openid}</td>
		<td>${payBill.status}</td>
		<td>${payBill.errMsg}</td>
		<td>${payBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<!--
			<button type="button" class="btn btn-default btn-sm" onclick="PayBill.toUpdate(${payBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="PayBill.deletePayBill(${payBill.id});"><i class="fa fa-remove"></i>删除</button>
			-->
		</td>
	</tr>
</#list>