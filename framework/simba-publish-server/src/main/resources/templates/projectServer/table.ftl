<#list list as projectServer>
	<tr>
		<td><input type="checkbox" name="projectServer" value="${projectServer.id}"></td>
		<td>${projectServer.name}</td>
		<td>${projectServer.ip}</td>
		<td>${projectServer.port}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectServer.toUpdate(${projectServer.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectServer.deleteProjectServer(${projectServer.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>