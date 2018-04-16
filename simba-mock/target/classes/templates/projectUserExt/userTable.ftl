<#list userList as userOfProject>
	<tr>
		<td><input type="checkbox" name="userListProject" value="${userOfProject.account}"></td>
		<td>${userOfProject.account}</td>
		<td>${userOfProject.name}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectUserExt.deleteUser('${userOfProject.account}',${Session['projectId']});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>

</#list>