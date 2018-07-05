<#list list as deviceBind>
	<tr>
		<td>${deviceBind.openid}</td>
		<td>${deviceBind.wxDeviceId}</td>
		<td>${deviceBind.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>