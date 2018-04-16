<#list list as redPackBill>
	<tr>
		<td><input type="checkbox" name="redPackBill" value="${redPackBill.id}"></td>
		<td>${redPackBill.type}</td>
		<td>${redPackBill.billNo}</td>
		<td>${redPackBill.sendName}</td>
		<td>${redPackBill.openid}</td>
		<td>${redPackBill.amount}</td>
		<td>${redPackBill.num}</td>
		<td>${redPackBill.wishing}</td>
		<td>${redPackBill.actName}</td>
		<td>${redPackBill.remark}</td>
		<td>${redPackBill.sceneId}</td>
		<td>${redPackBill.riskInfo}</td>
		<td>${redPackBill.consumeMchId}</td>
		<td>${redPackBill.status}</td>
		<td>${redPackBill.errMsg}</td>
		<td>${redPackBill.sendListId}</td>
		<td>${redPackBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${redPackBill.createUser}</td>
		<td>
			<!--
			<button type="button" class="btn btn-default btn-sm" onclick="RedPackBill.toUpdate(${redPackBill.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="RedPackBill.deleteRedPackBill(${redPackBill.id});"><i class="fa fa-remove"></i>删除</button>
			-->
		</td>
	</tr>
</#list>