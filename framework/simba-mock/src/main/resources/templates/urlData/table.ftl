<#list list as urlData>
	<tr>
		<td><input type="checkbox" name="urlData" value="${urlData.id}"></td>
		<td>${urlData.url}</td>
		<td>${urlData.data}</td>
		<td>${urlData.description}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="UrlData.toUpdate(${urlData.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="UrlData.deleteUrlData(${urlData.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>