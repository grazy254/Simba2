<#list list as projectPackage>
	<tr>
		<td><input type="checkbox" name="projectPackage" value="${projectPackage.id}"></td>
		<td>${projectPackage.projectId}</td>
		<td>${projectPackage.filePath}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectPackage.toUpdate(${projectPackage.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectPackage.deleteProjectPackage(${projectPackage.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>