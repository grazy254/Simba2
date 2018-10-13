<#list list as foreverMedia>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ForeverMedia.selectImages(${foreverMedia.id});"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${foreverMedia.name}</td>
		<td>
			<#if foreverMedia.fileUrl??>
				<a href="${foreverMedia.fileUrl}" target="_blank" title="${foreverMedia.fileUrl}"><img src="${foreverMedia.fileUrl}" style="width: 30px;height: 30px;" /></a>
			</#if>
		</td>
		<td>${foreverMedia.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>