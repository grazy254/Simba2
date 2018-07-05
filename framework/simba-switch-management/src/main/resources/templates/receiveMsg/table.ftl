<#list list as receiveMsg>
	<tr>
		<td>${receiveMsg.type!}</td>
		<td>${receiveMsg.source!}</td>
		<td>${receiveMsg.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ReceiveMsg.showContent(${receiveMsg.id});"><i class="fa fa-eye"></i>查看内容</button>
		</td>
	</tr>
</#list>