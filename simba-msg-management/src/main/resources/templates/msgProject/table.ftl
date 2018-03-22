<#list list as project>
	<tr>
		<td><input type="checkbox" name="project" value="${project.id}"></td>
        <td>${project.id}</td>
        <td>${project.name}</td>
		<td>${project.projectKey}</td>
		<td>${project.ip}</td>
		<td>${project.threshold}</td>
		<td>${project.limitNum}</td>
		<td>${project.email}</td>
		<td>${project.mobile}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Project.toUpdate(${project.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Project.deleteProject(${project.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>