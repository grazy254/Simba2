<#list list as realTimeMessage>
	<tr>
		<td><input type="checkbox" name="realTimeMessage" value="${realTimeMessage.id}"></td>
		<td>${realTimeMessage.userId}</td>
		<td>${realTimeMessage.message}</td>
		<td>${realTimeMessage.createTime}</td>
		<td>
		</td>
	</tr>
</#list>