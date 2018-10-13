<#list list as applicationUser>
	<tr>
		<td><input type="checkbox" name="applicationUser" value="${applicationUser.id}"></td>
		<td>${applicationUser.applicationId}</td>
		<td>${applicationUser.userId}</td>
		<td>${applicationUser.userType}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationUser.toUpdate(${applicationUser.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationUser.deleteApplicationUser(${applicationUser.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>