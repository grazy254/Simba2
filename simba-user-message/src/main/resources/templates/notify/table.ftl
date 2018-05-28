<#list list as notify>
	<tr>
		<td><input type="checkbox" name="notify" value="${notify.id}"></td>
		<td>${notify.title}</td>
		<td>${notify.content}</td>
		<#if notify.type == 0 >
        	<td>紧急通知</td>
		<#elseif notify.type == 1 >
        	<td>普通通知</td>
		</#if>
		<td>${notify.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Notify.deleteNotify(${notify.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
        <td>
            <button type="button" class="btn btn-default btn-sm" onclick="Notify.listReceiver(${notify.id});"><i class="fa fa-remove"></i>查看接收用户</button>
        </td>
	</tr>
</#list>