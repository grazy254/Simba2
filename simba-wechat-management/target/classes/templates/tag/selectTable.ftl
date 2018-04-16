<#list list as tag>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Tag.selectedTag(${tag.wxTagId});"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${tag.name}</td>
		<td>${tag.wxTagId}</td>
	</tr>
</#list>