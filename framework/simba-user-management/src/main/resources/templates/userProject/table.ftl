<#list list as project>
	<tr>
		<td>
			<#if project.canOper>
				<input type="checkbox" name="project" value="${project.id}">
			</#if>
		</td>
		<td>${project.code}</td>
		<td>${project.name}</td>
		<td>${project.projectKey!}</td>
		<td>${project.loginSuccessUrl!}</td>
		<td>${project.forgetBackUrl!}</td>
		<td>${project.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${project.createUserAccount}</td>
		<td>
			<#if project.canOper>
				<button type="button" class="btn btn-default btn-sm" onclick="Project.toUpdate(${project.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
				<button type="button" class="btn btn-default btn-sm" onclick="Project.deleteProject(${project.id});"><i class="fa fa-remove"></i>删除</button>
			</#if>
		</td>
	</tr>
</#list>