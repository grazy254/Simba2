<#list list as fileVersion>
	<tr>
		<td><input type="checkbox" name="fileVersion" value="${fileVersion.id}"></td>
		<td>${fileVersion.version}</td>
		<td>${fileVersion.type}</td>
		<td>${fileVersion.fileSize} MB</td>
		<td>${fileVersion.description!}</td>
		<td>${fileVersion.extProps}</td>
		<td>${fileVersion.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="FileVersion.toUpdate(${fileVersion.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="FileVersion.deleteFileVersion(${fileVersion.id});"><i class="fa fa-remove"></i>删除</button>
			<a href=${fileVersion.fileUrl} title="${fileVersion.fileUrl}" target="_blank"><button type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>下载</button></a>
		</td>
	</tr>
</#list>