<#list list as opinionFeedback>
	<tr>
		<td><input type="checkbox" name="opinionFeedback" value="${opinionFeedback.id}"></td>
		<td>${opinionFeedback.userId}</td>
		<td>${opinionFeedback.title}</td>
		<td>${opinionFeedback.text}</td>
		<td>${opinionFeedback.createTime}</td>
		<td>
		</td>
	</tr>
</#list>