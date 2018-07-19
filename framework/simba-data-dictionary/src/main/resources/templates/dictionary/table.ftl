<#list list as dictionary>
	<tr>
		<td><input type="checkbox" name="dictionary" value="${dictionary.id}"></td>
		<td>${dictionary.name}</td>
		<td>${dictionary.value}</td>
		<td>${dictionary.orderNo}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Dictionary.toUpdate(${dictionary.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Dictionary.deleteDictionary(${dictionary.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>