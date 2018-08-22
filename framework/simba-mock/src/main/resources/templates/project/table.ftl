<#list list as project>
	<tr>
		<td id="tdProjectId" hidden="hidden"><input type="checkbox" name="project" value="${project.id}"></td>
		<td id="tdProjectCode">${project.code}</td>
		<td id="tdProjectName">${project.name}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" id="updateBtn" onclick="Project.toUpdate(${project.id});" style="width: 7em;"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" id="delBtn" onclick="Project.deleteProject(${project.id});" style="width: 7em;"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" id="distributeBtn" onclick="Project.toAssignUser(${project.id});"><i class="glyphicon glyphicon-user"></i>分配人员</button>
			<button type="button" class="btn btn-default btn-sm" id="urlDataBtn" onclick="Project.toShowProjectUrlData(${project.id});"><i class="glyphicon glyphicon-file"></i>项目详情</button>
		</td>
	</tr>
</#list>