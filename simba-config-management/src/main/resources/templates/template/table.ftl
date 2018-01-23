<#list list as template>
	<tr>
		<td><input type="checkbox" name="template" value="${template.id}"></td>
		<td>${template.name}</td>
		<td>${template.description}</td>
		<td>${template.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Template.toUpdate(${template.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Template.deleteTemplate(${template.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Template.showTemplate(${template.id});"><i class="fa fa-eye"></i>查看模板</button>
		</td>
	</tr>
</#list>