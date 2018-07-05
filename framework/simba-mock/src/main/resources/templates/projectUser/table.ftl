<#list list as projectUser>
	<tr>
		<td><input type="checkbox" name="projectUser" value="${projectUser.id}"></td>
		<td>${projectUser.account}</td>
		<td>${projectUser.projectId}</td>
		<td>${projectUser.type}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectUser.toUpdate(${projectUser.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectUserExt.deleteProjectUser(${projectUser.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>