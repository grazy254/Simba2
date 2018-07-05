<#list list as autoReply>
	<tr>
		<td><input type="checkbox" name="autoReply" value="${autoReply.id}"></td>
		<td><#if autoReply.type==1>关注</#if><#if autoReply.type==2>收到用户信息</#if></td>
		<td>${autoReply.content}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="AutoReply.toUpdate(${autoReply.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="AutoReply.deleteAutoReply(${autoReply.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>