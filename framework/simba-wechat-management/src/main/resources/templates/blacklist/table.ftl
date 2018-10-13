<#list list as vo>
	<tr>
		<td><input type="checkbox" name="blacklist" value="${vo.blacklist.id}"></td>
		<td>${vo.fans.openid}</td>
		<td>${vo.fans.nickname}</td>
		<td>${vo.fans.remark}</td>
		<td>
			<a href="${vo.fans.headimgurl}" target="_blank" title="${vo.fans.headimgurl}"><img src="${vo.fans.headimgurl}" style="width: 22px;height: 22px;" /></a>
		</td>
		<td>
			<#if vo.fans.sex==1>男</#if>
			<#if vo.fans.sex==2>女</#if>
		</td>
		<td>${vo.fans.city}</td>
		<td>${vo.fans.province}</td>
		<td>${vo.fans.country}</td>
		<td>${vo.blacklist.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Blacklist.deleteBlacklist(${vo.blacklist.id});"><i class="fa fa-remove"></i>取消拉黑</button>
		</td>
	</tr>
</#list>