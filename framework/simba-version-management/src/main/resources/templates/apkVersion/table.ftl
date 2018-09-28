<#list list as apkVersion>
	<tr>
		<td><input type="checkbox" name="apkVersion" value="${apkVersion.id}"></td>
		<td>${apkVersion.version}</td>
		<td>${apkVersion.versionName}</td>
		<td>${apkVersion.fileSize}MB</td>
		<td>${apkVersion.description}</td>
        <td>${apkVersion.typeId}</td>
        <td>${apkVersion.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ApkVersion.toUpdate(${apkVersion.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ApkVersion.deleteApkVersion(${apkVersion.id});"><i class="fa fa-remove"></i>删除</button>
            <a href=${apkVersion.fileUrl} title="${apkVersion.fileUrl}" target="_blank"><button type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>下载</button></a>

		</td>
	</tr>
</#list>