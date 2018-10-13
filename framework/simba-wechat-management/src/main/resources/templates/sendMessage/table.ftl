<#list list as sendMessage>
	<tr>
		<td>${sendMessage.openid}</td>
		<td>
			<#if sendMessage.type=="text">文本</#if>
			<#if sendMessage.type=="image">图片</#if>
			<#if sendMessage.type=="voice">语音</#if>
			<#if sendMessage.type=="video">视频</#if>
			<#if sendMessage.type=="music">音乐</#if>
			<#if sendMessage.type=="news">图文（点击跳转到外链）</#if>
			<#if sendMessage.type=="mpnews">图文（点击跳转到图文消息页面）</#if>
		</td>
		<td>${sendMessage.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${sendMessage.account!}</td>
		<td>${sendMessage.content}</td>
		<td>${sendMessage.mediaId}</td>
		<td>${sendMessage.thumbMediaId}</td>
		<td>${sendMessage.title}</td>
		<td>${sendMessage.descritption}</td>
		<td>${sendMessage.musicUrl}</td>
		<td>${sendMessage.hqMusicUrl}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="SendMessage.showJson(${sendMessage.id});"><i class="fa fa-eye"></i>查看完整Json内容</button>
			<#if sendMessage.type=="news">
				<button type="button" class="btn btn-default btn-sm" onclick="SendMessage.showNews(${sendMessage.id});"><i class="fa fa-eye"></i>查看图文内容</button>
			</#if>
		</td>
	</tr>
</#list>