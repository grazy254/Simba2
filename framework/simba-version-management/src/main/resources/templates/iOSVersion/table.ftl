<#list list as iOSVersion>
	<tr>
		<td><input type="checkbox" name="iOSVersion" value="${iOSVersion.id}"></td>
		<td>${iOSVersion.version}</td>
		<td>${iOSVersion.type}</td>
		<td>${iOSVersion.fileSize} MB</td>
		<td>${iOSVersion.description!}</td>
		<td>${iOSVersion.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${iOSVersion.identifer}</td>
		<td>${iOSVersion.title}</td>
		<td>
			<a href=${iOSVersion.ipaFileUrl} target="_blank" title="${iOSVersion.ipaFileUrl}">下载</a>
		</td>
		<td>
			<a href="${iOSVersion.fullImageFileUrl}" target="_blank" title="${iOSVersion.fullImageFileUrl}"><img src="${iOSVersion.fullImageFileUrl}" style="width: 32px;height: 32px;" /></a>
		</td>
		<td>
			<a href="${iOSVersion.logFileUrl}" target="_blank" title="${iOSVersion.logFileUrl}"><img src="${iOSVersion.logFileUrl}" style="width: 32px;height: 32px;" /></a>
		</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="IOSVersion.toUpdate(${iOSVersion.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="IOSVersion.deleteIOSVersion(${iOSVersion.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="IOSVersion.publish(${iOSVersion.id});"><i class="fa fa-rocket"></i>发布</button>
		</td>
	</tr>
</#list>