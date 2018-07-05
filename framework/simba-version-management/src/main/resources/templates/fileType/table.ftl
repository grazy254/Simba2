<#list list as fileType>
	<tr>
		<td><input type="checkbox" name="fileType" value="${fileType.id}"></td>
		<td>${fileType.id}</td>
		<td>${fileType.name}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="FileType.toUpdate(${fileType.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="FileType.deleteFileType(${fileType.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>