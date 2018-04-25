<#list list as devProject>
	<tr>
		<td><input type="checkbox" name="devProject" value="${devProject.id}"></td>
		<td>${devProject.code}</td>
		<td>${devProject.name}</td>
		<td>${devProject.notifyEmails}</td>
		<td>${devProject.targetServers}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.toUpdate(${devProject.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.deleteDevProject(${devProject.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.showBindServers(${devProject.id});"><i class="fa fa-retweet"></i>绑定服务器</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.refreshCode(${devProject.id});"><i class="fa fa-refresh"></i>重新初始化库</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.showPublishSome(${devProject.id});"><i class="fa fa-send"></i>发布某台服务器</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.publishAll(${devProject.id});"><i class="fa fa-upload"></i>发布所有关联服务器</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DevProject.copy(${devProject.id});"><i class="fa fa-copy"></i>拷贝配置</button>
		</td>
	</tr>
</#list>