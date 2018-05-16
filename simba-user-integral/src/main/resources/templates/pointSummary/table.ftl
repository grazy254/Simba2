<#list list as pointSummary>
	<tr>
		<td><input type="checkbox" name="pointSummary" value="${pointSummary.id}"></td>
		<td>${pointSummary.userID}</td>
		<td>${pointSummary.point}</td>
		<td>${pointSummary.updateTime}</td>
		<td>
		</td>
	</tr>
</#list>