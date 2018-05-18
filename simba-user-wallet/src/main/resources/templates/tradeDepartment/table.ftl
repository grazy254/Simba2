<#list list as tradeDepartment>
	<tr>
		<td><input type="checkbox" name="tradeDepartment" value="${tradeDepartment.id}"></td>
		<td>${tradeDepartment.deptNO}</td>
		<td>${tradeDepartment.deptName}</td>
		<td>${tradeDepartment.createTime}</td>
		<td>${tradeDepartment.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.toUpdate(${tradeDepartment.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.deleteTradeDepartment(${tradeDepartment.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>