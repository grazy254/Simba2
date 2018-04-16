<#list list as uploadVideo>
	<tr>
		<td>${uploadVideo.title}</td>
		<td>${uploadVideo.description}</td>
		<td>${uploadVideo.mediaId}</td>
		<td>${uploadVideo.targetMediaId}</td>
		<td>${uploadVideo.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>