<#list list as aliPayEnterpriseBill>
	<tr>
		<td><input type="checkbox" name="aliPayEnterpriseBill" value="${aliPayEnterpriseBill.id}"></td>
		<td>${aliPayEnterpriseBill.outBizNo}</td>
		<td>${aliPayEnterpriseBill.payType}</td>
		<td>${aliPayEnterpriseBill.account}</td>
		<td>${aliPayEnterpriseBill.amount}</td>
		<td>${aliPayEnterpriseBill.payerName}</td>
		<td>${aliPayEnterpriseBill.peyeeName}</td>
		<td>${aliPayEnterpriseBill.remark}</td>
		<td>${aliPayEnterpriseBill.orderId}</td>
		<td>${aliPayEnterpriseBill.payDate}</td>
		<td>${aliPayEnterpriseBill.createTime}</td>
		<td>${aliPayEnterpriseBill.createUser}</td>
		<td>${aliPayEnterpriseBill.status}</td>
		<td>${aliPayEnterpriseBill.reason}</td>
		<td>${aliPayEnterpriseBill.orderFee}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="AliPayEnterpriseBill.toUpdate(${aliPayEnterpriseBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="AliPayEnterpriseBill.deleteAliPayEnterpriseBill(${aliPayEnterpriseBill.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>