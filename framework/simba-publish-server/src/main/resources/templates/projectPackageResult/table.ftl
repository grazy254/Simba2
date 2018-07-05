<#list list as projectPackageResult>
	<tr>
		<td><input type="checkbox" name="projectPackageResult" value="${projectPackageResult.id}"></td>
		<td>${projectPackageResult.projectId}</td>
		<td>${projectPackageResult.filePath}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectPackageResult.toUpdate(${projectPackageResult.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectPackageResult.deleteProjectPackageResult(${projectPackageResult.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>