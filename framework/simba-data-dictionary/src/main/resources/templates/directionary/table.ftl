<#list list as directionary>
	<tr>
		<td><input type="checkbox" name="directionary" value="${directionary.id}"></td>
		<td>${directionary.typeId}</td>
		<td>${directionary.name}</td>
		<td>${directionary.value}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Directionary.toUpdate(${directionary.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Directionary.deleteDirectionary(${directionary.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>