<#list list as notify>
	<tr>
		<td><input type="checkbox" name="notify" value="${notify.id}"></td>
		<td>${notify.title}</td>
		<td>${notify.content}</td>
		<td>${notify.type}</td>
		<td>${notify.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Notify.toUpdate(${notify.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Notify.deleteNotify(${notify.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>