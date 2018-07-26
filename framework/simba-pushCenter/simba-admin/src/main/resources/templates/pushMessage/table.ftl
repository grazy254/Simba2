<#list list as pushMessage>
	<tr>
		<td><input type="checkbox" name="pushMessage" value="${pushMessage.id}"></td>
		<td>${pushMessage.toUserId}</td>
		<td>${pushMessage.fromUserId}</td>
		<td>${pushMessage.pushType}</td>
		<td>${pushMessage.content}</td>
		<td>${pushMessage.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="PushMessage.toUpdate(${pushMessage.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="PushMessage.deletePushMessage(${pushMessage.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>