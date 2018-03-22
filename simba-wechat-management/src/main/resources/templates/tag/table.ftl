<#list list as tag>
	<tr>
		<td><input type="checkbox" name="tag" value="${tag.id}"></td>
		<td>${tag.name}</td>
		<td>${tag.wxTagId}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Tag.toUpdate(${tag.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Tag.deleteTag(${tag.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Tag.showFans(${tag.id});"><i class="fa fa-eye"></i>查看标签下粉丝列表</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Tag.clearFans(${tag.id});"><i class="fa fa-ban"></i>清空标签下粉丝</button>
		</td>
	</tr>
</#list>