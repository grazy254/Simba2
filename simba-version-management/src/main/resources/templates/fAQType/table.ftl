<#list list as fAQType>
	<tr>
		<td><input type="checkbox" name="fAQType" value="${fAQType.id}"></td>
		<td>${fAQType.type}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="FAQType.toUpdate(${fAQType.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="FAQType.deleteFAQType(${fAQType.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>