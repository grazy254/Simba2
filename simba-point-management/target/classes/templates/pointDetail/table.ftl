<#list list as pointDetail>
	<tr>
		<td><input type="checkbox" name="pointDetail" value="${pointDetail.id}"></td>
		<td>${pointDetail.userID}</td>
		<td>${pointDetail.activityID}</td>
		<td>${pointDetail.point}</td>
		<td>${pointDetail.createTime}</td>
		<td>${pointDetail.expireTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="PointDetail.toUpdate(${pointDetail.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="PointDetail.deletePointDetail(${pointDetail.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>