<#list list as aliPayBill>
	<tr>
		<td><input type="checkbox" name="aliPayBill" value="${aliPayBill.id}"></td>
		<td>${aliPayBill.appid}</td>
		<td>${aliPayBill.body}</td>
		<td>${aliPayBill.totalAmount}</td>
		<td>${aliPayBill.subject}</td>
		<td>${aliPayBill.status}</td>
		<td>${aliPayBill.outTradeNo}</td>
		<td>${aliPayBill.tradeNo}</td>
		<td>${aliPayBill.productCode}</td>
		<td>${aliPayBill.goodType}</td>
		<td>${aliPayBill.storeId}</td>
		<td>${aliPayBill.sellId}</td>
		<td>${aliPayBill.timeoutExpress}</td>
		<td>${aliPayBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
		<!--
			<button type="button" class="btn btn-default btn-sm" onclick="AliPayBill.toUpdate(${aliPayBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="AliPayBill.deleteAliPayBill(${aliPayBill.id});"><i class="fa fa-remove"></i>删除</button>
		-->
		</td>
	</tr>
</#list>