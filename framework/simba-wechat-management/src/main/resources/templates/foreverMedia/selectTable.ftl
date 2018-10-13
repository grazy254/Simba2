<#list list as foreverMedia>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ForeverMedia.executeSelect('${foreverMedia.mediaId}');"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${foreverMedia.name}</td>
		<td>${foreverMedia.mediaId}</td>
		<td>
			<#if foreverMedia.type=="image">图片
			</#if>
			<#if foreverMedia.type=="voice">语音
			</#if>
			<#if foreverMedia.type=="video">视频
			</#if>
			<#if foreverMedia.type=="thumb">缩略图
			</#if>
			<#if foreverMedia.type=="news">图文
			</#if>
		</td>
		<td>
			<#if foreverMedia.fileUrl??>
				<#if foreverMedia.type=="image">
					<a href="${foreverMedia.fileUrl}" target="_blank" title="${foreverMedia.fileUrl}"><img src="${foreverMedia.fileUrl}" style="width: 30px;height: 30px;" /></a>
				</#if>
				<#if foreverMedia.type=="voice">
					<a href="${foreverMedia.fileUrl}" target="_blank" title="${foreverMedia.fileUrl}">下载</a>
				</#if>
				<#if foreverMedia.type=="video">
					<a href="${foreverMedia.fileUrl}" target="_blank" title="${foreverMedia.fileUrl}">下载</a>
				</#if>
				<#if foreverMedia.type=="thumb">
					<a href="${foreverMedia.fileUrl}" target="_blank" title="${foreverMedia.fileUrl}"><img src="${foreverMedia.fileUrl}" style="width: 30px;height: 30px;" /></a>
				</#if>
			</#if>
		</td>
		<td>${foreverMedia.title!}</td>
		<td>${foreverMedia.introduction!}</td>
		<td>
			<#if foreverMedia.imageUrl??>
				<#if foreverMedia.imageUrl !="">
					<a href="${foreverMedia.imageUrl}" target="_blank" title="${foreverMedia.imageUrl}">
						<img src="${foreverMedia.imageUrl}" style="width: 30px;height: 30px;" />
					</a>
				</#if>
			</#if>
		</td>
		<td>${foreverMedia.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>