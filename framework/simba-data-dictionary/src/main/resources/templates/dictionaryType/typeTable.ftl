<#list list as dictionaryType>
	<tr>
		<td><input type="checkbox" name="dictionaryType" value="${dictionaryType.id}"></td>
		<td>${dictionaryType.code}</td>
		<td>${dictionaryType.description}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="DictionaryType.toUpdate(${dictionaryType.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DictionaryType.deleteDictionaryType(${dictionaryType.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DictionaryType.showDictionary(${dictionaryType.id});"><i class="fa fa-reorder"></i>配置列表项</button>
		</td>
	</tr>
</#list> 