<#list list as pointSummary>
	<tr>
		<td><input type="checkbox" name="pointSummary" value="${pointSummary.id}"></td>
		<td>${pointSummary.userID}</td>
		<td>${pointSummary.point}</td>
		<td>${pointSummary.createTime}</td>
		<td>${pointSummary.updateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="PointSummary.toUpdate(${pointSummary.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="PointSummary.deletePointSummary(${pointSummary.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>