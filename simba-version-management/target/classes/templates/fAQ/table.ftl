<#list list as fAQ>
	<tr>
		<td><input type="checkbox" name="fAQ" value="${fAQ['id']}"></td>
		<td>${fAQ["title"]}</td>
		<td>${fAQ["text"]}</td>
		<td>${fAQ["type"]}</td>
		<td>${fAQ["createTime"]}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="FAQ.toUpdate(${fAQ['id']});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="FAQ.deleteFAQ(${fAQ['id']});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>