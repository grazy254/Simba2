<#list list as fans>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Fans.executeSelectFanses('${fans.openid}','${fans.nickname}');"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${fans.openid}</td>
		<td>${fans.remark}</td>
		<td>${fans.nickname}</td>
		<td>
			<#if fans.sex==1>男</#if>
			<#if fans.sex==2>女</#if>
		</td>
		<td>${fans.city}</td>
		<td>${fans.province}</td>
		<td>${fans.country}</td>
		<td>
			<a href="${fans.headimgurl}" target="_blank" title="${fans.headimgurl}"><img src="${fans.headimgurl}" style="width: 22px;height: 22px;" /></a>
		</td>
		<td>${fans.tagName}</td>
		<td>${fans.subscribeTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<#if fans.black>是
				<#else>否</#if>
		</td>
	</tr>
</#list>