<#list list as wxMenu>
	<tr>
		<td><input type="checkbox" name="wxMenu" value="${wxMenu.id}"></td>
		<td>${wxMenu.text}</td>
		<td>${wxMenu.orderNo}</td>
		<td>${wxMenu.menuKey}</td>
		<td>${wxMenu.url}</td>
		<td>${wxMenu.type}</td>
		<td>${wxMenu.mediaId}</td>
		<td>${wxMenu.appid}</td>
		<td>${wxMenu.pagepath}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="WxMenu.toUpdate(${wxMenu.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="WxMenu.deleteWxMenu(${wxMenu.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>