<#list list as bugFeedback>
	<tr>
		<td><input type="checkbox" name="bugFeedback" value="${bugFeedback['id']}"></td>
		<td>${bugFeedback["userId"]}</td>
		<td>${bugFeedback["title"]}</td>
		<td>${bugFeedback["text"]}</td>
		<td>
			<#list bugFeedback["img"] as listImg>
			<a href="${listImg}" target="_blank" title="${listImg}"><img src="${listImg}" style="width: 50px;height: 80px;" /></a>
			</#list>
		</td>
		<td>${bugFeedback.createTime}</td>
	</tr>
</#list>