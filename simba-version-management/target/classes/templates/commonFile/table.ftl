<#list list as commonFile>
	<tr>
		<td><input type="checkbox" name="commonFile" value="${commonFile.id}"></td>
		<td>${commonFile.name!}</td>
		<td>${commonFile.type}</td>
		<td>
			<#if commonFile.typeId==1000>
				<a href=${commonFile.fileUrl} title="${commonFile.fileUrl}" target="_blank">
					<img src="${commonFile.fileUrl}" style="width: 50px;height: 50px;" />
				</a>
			</#if>
			${commonFile.fileUrl}
		</td>
		<td>${commonFile.fileSize} MB</td>
		<td>${commonFile.description!}</td>
		<td>${commonFile.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${commonFile.extProps!}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="CommonFile.toUpdate(${commonFile.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="CommonFile.deleteCommonFile(${commonFile.id});"><i class="fa fa-remove"></i>删除</button>
			<a href=${commonFile.fileUrl} title="${commonFile.fileUrl}" target="_blank"><button type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>下载</button></a>
		</td>
	</tr>
</#list>