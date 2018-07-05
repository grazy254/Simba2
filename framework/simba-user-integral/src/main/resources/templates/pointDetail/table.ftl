<#list list as pointDetail>
	<tr>
		<td><input type="checkbox" name="pointDetail" value="${pointDetail.id}"></td>
		<td>${pointDetail.userID}</td>
		<td>${pointDetail.activityName}</td>
		<td>${pointDetail.point}</td>
		<td>${pointDetail.createTime}</td>
		<td>${pointDetail.expireTime}</td>
		<td>
		</td>
	</tr>
</#list>