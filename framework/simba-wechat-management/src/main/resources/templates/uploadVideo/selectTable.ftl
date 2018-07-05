<#list list as uploadVideo>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="UploadVideo.executeSelect('${uploadVideo.targetMediaId}');"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${uploadVideo.title}</td>
		<td>${uploadVideo.description}</td>
		<td>${uploadVideo.mediaId}</td>
		<td>${uploadVideo.targetMediaId}</td>
		<td>${uploadVideo.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>