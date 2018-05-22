<#list list as smartUser>
	<tr>
		<td><input type="checkbox" name="smartUser" value="${smartUser.id}"></td>
		<td>${smartUser.account}</td>
		<td>${smartUser.name}</td>
		<td>${smartUser.email}</td>
		<td>${smartUser.telNo}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="SmartUser.sendNotify(${smartUser.id});"><i class="fa fa-send"></i>发送通知</button>
		</td>
	</tr>
</#list>