<#list list as groupMessage>
	<tr>
		<td>${groupMessage.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<#if groupMessage.type=="text">文本</#if>
			<#if groupMessage.type=="image">图片</#if>
			<#if groupMessage.type=="voice">语音</#if>
			<#if groupMessage.type=="video">视频</#if>
			<#if groupMessage.type=="news">图文</#if>
		</td>
		<td>${groupMessage.account!}</td>
		<td>${groupMessage.content!}</td>
		<td>${groupMessage.mediaId!}</td>
		<td>
			<#if groupMessage.wxTagId!=0>${groupMessage.wxTagId!}</#if>
		</td>
		<td>
			<#if groupMessage.isAll==1>是</#if>
			<#if groupMessage.isAll==2>否</#if>
		</td>
		<td>${groupMessage.openids!}</td>
		<td>
			<#if groupMessage.status==1>已发送</#if>
			<#if groupMessage.status==2>发送成功</#if>
		</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="GroupMessage.showJson(${groupMessage.id});"><i class="fa fa-eye"></i>查看完整Json</button>
		</td>
	</tr>
</#list>