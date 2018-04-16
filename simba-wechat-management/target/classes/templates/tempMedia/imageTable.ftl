<#list list as tempMedia>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TempMedia.selectImages(${tempMedia.id});"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${tempMedia.name}</td>
		<td>
			<#if tempMedia.type=="image">图片</#if>
			<#if tempMedia.type=="voice">语音</#if>
			<#if tempMedia.type=="video">视频</#if>
			<#if tempMedia.type=="thumb">缩略图</#if>
		</td>
		<td>
			<#if tempMedia.type=="image">
				<a href="${tempMedia.fileUrl}" target="_blank" title="${tempMedia.fileUrl}"><img src="${tempMedia.fileUrl}" style="width: 30px;height: 30px;" /></a>
			</#if>
			<#if tempMedia.type=="voice">
				<a href="${tempMedia.fileUrl}" target="_blank" title="${tempMedia.fileUrl}">下载</a>
			</#if>
			<#if tempMedia.type=="video">
				<a href="${tempMedia.fileUrl}" target="_blank" title="${tempMedia.fileUrl}">下载</a>
			</#if>
			<#if tempMedia.type=="thumb">
				<a href="${tempMedia.fileUrl}" target="_blank" title="${tempMedia.fileUrl}"><img src="${tempMedia.fileUrl}" style="width: 30px;height: 30px;" /></a>
			</#if>
		</td>
		<td>${tempMedia.mediaId}</td>
		<td>${tempMedia.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>