<#list list as directionaryType>
	<tr>
		<td><input type="checkbox" name="directionaryType" value="${directionaryType.id}"></td>
		<td>${directionaryType.code}</td>
		<td>${directionaryType.description}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="DirectionaryType.toUpdate(${directionaryType.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DirectionaryType.deleteDirectionaryType(${directionaryType.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>