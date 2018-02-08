<#list list as deployLog>
	<tr>
		<td><input type="checkbox" name="deployLog" value="${deployLog.id}"></td>
		<td>${deployLog.name}</td>
		<td>${deployLog.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>