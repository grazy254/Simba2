<#list list as userGroup>
	<tr>
		<td><input type="checkbox" name="userGroup" value="${userGroup.id}"></td>
		<td>${userGroup.userId}</td>
		<td>${userGroup.groupId}</td>
		<td>${userGroup.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="UserGroup.toUpdate(${userGroup.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="UserGroup.deleteUserGroup(${userGroup.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>