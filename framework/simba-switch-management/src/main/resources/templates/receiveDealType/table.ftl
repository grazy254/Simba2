<#list list as receiveDealType>
	<tr>
		<td><input type="checkbox" name="receiveDealType" value="${receiveDealType.id}"></td>
		<td>${receiveDealType.name}</td>
		<td>${receiveDealType.beanId}</td>
		<td>
			<#if receiveDealType.sync==0>否</#if>
			<#if receiveDealType.sync==1>是</#if>
		</td>
		<td>${receiveDealType.description!}</td>
		<td>${receiveDealType.ext!}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ReceiveDealType.toUpdate(${receiveDealType.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ReceiveDealType.deleteReceiveDealType(${receiveDealType.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>