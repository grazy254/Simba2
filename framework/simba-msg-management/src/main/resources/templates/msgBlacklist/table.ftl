<#list list as blacklist>
	<tr>
		<td><input type="checkbox" name="blacklist" value="${blacklist.id}"></td>
		<td>${blacklist.mobile}</td>
		<td>${blacklist.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Blacklist.toUpdate(${blacklist.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Blacklist.deleteBlacklist(${blacklist.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>