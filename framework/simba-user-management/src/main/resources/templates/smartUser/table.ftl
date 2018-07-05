<#list list as smartUser>
	<tr>
		<td><input type="checkbox" name="smartUser" value="${smartUser.id}"></td>
		<td>${smartUser.account}</td>
		<td>${smartUser.name}</td>
		<td>${smartUser.email}</td>
		<td>${smartUser.telNo}</td>
		<td>
		<#list smartUser.thirdSystem?split(",") as ts>
		<#if ts="">
		<#break>
		</#if>
		<#if (ts_index)%2=0>
		${ts}:
		</#if>
		<#if (ts_index+1)%2=0>
		${ts}<br>
		</#if>
		</#list>
		</td>
		<td>${smartUser.group}</td>
		<td>${smartUser.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="SmartUser.toGroup(${smartUser.id});"><i class="fa fa-pencil-square-o"></i>设置分组</button>
			<!--<button type="button" class="btn btn-default btn-sm" onclick="SmartUser.toUpdate(${smartUser.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="SmartUser.resetPwd(${smartUser.id});"><i class="fa fa-refresh"></i>重置密码</button>-->
		</td>
	</tr>
</#list>