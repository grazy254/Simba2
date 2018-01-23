<#list list as projectVersion>
	<tr>
		<td><input type="checkbox" name="projectVersion" value="${projectVersion.id}"></td>
		<td>${projectVersion.versionNo}</td>
		<td>${projectVersion.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectVersion.download(${projectVersion.id});"><i class="fa fa-download"></i>下载</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectVersion.toUpdate(${projectVersion.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ProjectVersion.deleteProjectVersion(${projectVersion.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>