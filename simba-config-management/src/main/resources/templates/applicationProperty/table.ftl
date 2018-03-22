<#list list as applicationProperty>
	<tr>
		<td><input type="checkbox" name="applicationProperty" value="${applicationProperty.id}"></td>
		<td>${applicationProperty.name}</td>
		<td>${applicationProperty.template}</td>
		<td>${applicationProperty.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.toUpdate(${applicationProperty.id});"><i class="fa fa-pencil-square-o"></i>修改全部配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.toUpdateDev(${applicationProperty.id});"><i class="fa fa-pencil-square-o"></i>修改开发版配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.toUpdateProd(${applicationProperty.id});"><i class="fa fa-pencil-square-o"></i>修改生产版配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.toUpdateTest(${applicationProperty.id});"><i class="fa fa-pencil-square-o"></i>修改测试版配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.deleteApplicationProperty(${applicationProperty.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.showDevProperty(${applicationProperty.id});"><i class="fa fa-eye"></i>查看开发版配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.showProdProperty(${applicationProperty.id});"><i class="fa fa-eye"></i>查看生产环境配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.showTestProperty(${applicationProperty.id});"><i class="fa fa-eye"></i>查看测试版配置</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApplicationProperty.auth(${applicationProperty.id});"><i class="fa fa-user"></i>权限设置</button>
		</td>
	</tr>
</#list>