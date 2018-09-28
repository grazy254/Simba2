<#list list as email>
	<tr>
		<td><input type="checkbox" name="email" value="${email.id}"></td>
		<td>${email.appid}</td>
		<td>${email.toEmail}</td>
		<td>${email.title}</td>
		<td>${email.content}</td>
		<td>${email.type}</td>
		<td>${email.createTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Email.toUpdate(${email.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Email.deleteEmail(${email.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>