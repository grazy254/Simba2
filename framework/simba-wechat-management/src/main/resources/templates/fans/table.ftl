<#list list as fans>
	<tr>
		<td><input type="checkbox" name="fans" value="${fans.id}"></td>
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
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Fans.toUpdateRemark(${fans.id});"><i class="fa fa-pencil-square-o"></i>设置备注</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Fans.setTag(${fans.id});"><i class="fa fa-star-o"></i>设置标签</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Fans.clearTag(${fans.id});"><i class="fa fa-refresh"></i>清空标签</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Fans.blackFans(${fans.id});"><i class="fa fa-warning"></i>拉黑</button>
		</td>
	</tr>
</#list>