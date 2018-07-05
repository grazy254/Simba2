<#list list as receiveMessage>
	<tr>
		<td><input type="checkbox" name="receiveMessage" value="${receiveMessage.id}"></td>
		<td>${receiveMessage.openid}</td>
		<td>${receiveMessage.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${receiveMessage.type}</td>
		<td>${receiveMessage.msgId}</td>
		<td>${receiveMessage.content}</td>
		<td>
			<#if receiveMessage.picUrl?? && receiveMessage.picUrl != "">
				<a href="${receiveMessage.picUrl}" target="_blank" title="${receiveMessage.picUrl}"><img src="${receiveMessage.picUrl}" /></a>
			</#if>
		</td>
		<td>${receiveMessage.mediaId}</td>
		<td>
			<#if receiveMessage.fileUrl?? && receiveMessage.fileUrl != "">
				<a href="${receiveMessage.fileUrl}" target="_blank">下载</a>
			</#if>
		</td>
		<td>${receiveMessage.format}</td>
		<td>${receiveMessage.recognition}</td>
		<td>${receiveMessage.thumbMediaId}</td>
		<td>
			<#if receiveMessage.thumbFileUrl?? && receiveMessage.thumbFileUrl != "" >
				<a href="${receiveMessage.thumbFileUrl}" target="_blank">下载</a>
			</#if>
		</td>
		<td>${receiveMessage.locationX}</td>
		<td>${receiveMessage.locationY}</td>
		<td>${receiveMessage.scale}</td>
		<td>${receiveMessage.messageLabel}</td>
		<td>${receiveMessage.title}</td>
		<td>${receiveMessage.description}</td>
		<td>
			<#if receiveMessage.url?? && receiveMessage.url != "">
				<a href="${receiveMessage.url}" target="_blank">打开</a>
			</#if>
		</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ReceiveMessage.showXML(${receiveMessage.id});"><i class="fa fa-eye"></i>查看完整XML</button>
		</td>
	</tr>
</#list>