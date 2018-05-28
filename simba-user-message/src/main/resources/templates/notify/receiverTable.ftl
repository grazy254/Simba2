<#list list as smartUser>
	<tr>
		<td><input type="checkbox" name="smartUser" value="${smartUser.id}"></td>
		<td>${smartUser.account}</td>
		<td>${smartUser.name}</td>
		<td>${smartUser.email}</td>
		<td>${smartUser.telNo}</td>
	</tr>
</#list>