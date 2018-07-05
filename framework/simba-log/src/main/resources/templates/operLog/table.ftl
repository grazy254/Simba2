<#list list as operLog>
	<tr>
		<td>${operLog.account}</td>
		<td>${operLog.ip}</td>
		<td>${operLog.address}</td>
		<td>${operLog.content}</td>
		<td>${operLog.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>