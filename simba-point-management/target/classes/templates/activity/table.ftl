<#list list as activity>
	<tr>
		<td><input type="checkbox" name="activity" value="${activity.id}"></td>
		<td>${activity.activityID}</td>
		<td>${activity.name}</td>
		<td>${activity.description}</td>
		<td>${activity.ownerID}</td>
		<td>${activity.point}</td>
		<td>${activity.startTime}</td>
		<td>${activity.endTime}</td>
		<td>${activity.createTime}</td>
		<td>${activity.updateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Activity.toUpdate(${activity.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Activity.deleteActivity(${activity.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>