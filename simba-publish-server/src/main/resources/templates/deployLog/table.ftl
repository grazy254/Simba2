<#list list as deployLog>
	<tr>
		<td>${deployLog.name}</td>
		<td>${deployLog.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>