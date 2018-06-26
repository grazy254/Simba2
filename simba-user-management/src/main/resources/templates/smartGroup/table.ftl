<#list list as smartGroup>
	<tr>
		<td><input type="checkbox" name="smartGroup" value="${smartGroup.id}"></td>
		<td>${smartGroup.name}</td>
		<td>${smartGroup.description}</td>
		<td>${smartGroup.status}</td>
		<td>${smartGroup.type}</td>
		<td>${smartGroup.creater}</td>
		<td>${smartGroup.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="SmartGroup.toUpdate(${smartGroup.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="SmartGroup.deleteSmartGroup(${smartGroup.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>