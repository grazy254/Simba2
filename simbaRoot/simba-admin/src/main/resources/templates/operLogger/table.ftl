<#list list as operLogger>
	<tr>
		<td><input type="checkbox" name="operLogger" value="${operLogger.id}"></td>
		<td>${operLogger.account}</td>
		<td>${operLogger.ip}</td>
		<td>${operLogger.address}</td>
		<td>${operLogger.content}</td>
		<td>${operLogger.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="OperLogger.toUpdate(${operLogger.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="OperLogger.deleteOperLogger(${operLogger.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>