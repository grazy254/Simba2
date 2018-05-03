<#if list?exists>
<#list list as operLogger>
	<tr>
		<td>${operLogger.account}</td>
		<td>${operLogger.ip}</td>
		<td>${operLogger.address}</td>
		<td>${operLogger.content}</td>
		<td>${operLogger.createTime}</td>
	</tr>
</#list>
</#if>