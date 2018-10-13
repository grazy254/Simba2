<#list list as projectServerRel>
	<tr>
		<td><input type="checkbox" name="projectServerRel" value="${projectServerRel.id}"></td>
		<td>${projectServerRel.projectId}</td>
		<td>${projectServerRel.serverId}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectServerRel.toUpdate(${projectServerRel.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectServerRel.deleteProjectServerRel(${projectServerRel.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>