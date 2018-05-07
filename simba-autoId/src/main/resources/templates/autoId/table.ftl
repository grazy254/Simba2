<#list list as autoId>
	<tr>
		<td><input type="checkbox" name="autoId" value="${autoId.id}"></td>
		<td>${autoId.id}</td>
		<td>${autoId.num}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="AutoId.toUpdate(${autoId.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="AutoId.deleteAutoId(${autoId.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>