<#list list as tradeDepartmentVO>
	<tr>
		<td><input type="checkbox" name="tradeDepartment" value="${tradeDepartmentVO.id}"></td>
		<td>${tradeDepartmentVO.deptNO}</td>
		<td>${tradeDepartmentVO.deptName}</td>
		<td>${tradeDepartmentVO.accountStatus}</td>
		<td>${tradeDepartmentVO.createTime}</td>
		<td>${tradeDepartmentVO.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.toUpdate(${tradeDepartmentVO.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.deleteTradeDepartment('${tradeDepartmentVO.deptNO}');"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.openDepartmentAccount('${tradeDepartmentVO.deptNO}', '${tradeDepartmentVO.deptName}', '18676459182');"><i class="fa fa-user"></i>开通账户</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.frozeDepartmentAccount('${tradeDepartmentVO.deptNO}');"><i class="fa fa-user"></i>冻结账户</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDepartment.activateDepartmentAccount('${tradeDepartmentVO.deptNO}');"><i class="fa fa-user"></i>激活账户</button>
			
		</td>
	</tr>
</#list>