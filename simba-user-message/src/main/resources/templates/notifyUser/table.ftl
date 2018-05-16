<#list list as notifyUser>
	<tr>
		<td><input type="checkbox" name="notifyUser" value="${notifyUser.id}"></td>
		<td>${notifyUser.notifyId}</td>
		<td>${notifyUser.smartUserId}</td>
		<td>${notifyUser.status}</td>
		<td>${notifyUser.readTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="NotifyUser.toUpdate(${notifyUser.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="NotifyUser.deleteNotifyUser(${notifyUser.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>