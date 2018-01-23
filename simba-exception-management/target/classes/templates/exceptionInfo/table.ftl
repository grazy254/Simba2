<#list list as exceptionInfo>
	<tr>
		<td><input type="checkbox" name="exceptionInfo" value="${exceptionInfo.id}"></td>
		<td>${exceptionInfo.ip}</td>
		<td>${exceptionInfo.ipInfo}</td>
		<td>
			${exceptionInfo.exceptionInfo}
		</td>
		<td>${exceptionInfo.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ExceptionInfo.deleteExceptionInfo(${exceptionInfo.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="ExceptionInfo.show(${exceptionInfo.id});"><i class="fa fa-eye"></i>查看内容</button>
		</td>
	</tr>
</#list>