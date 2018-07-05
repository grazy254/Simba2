<#list list as uploadImage>
	<tr>
		<td><input type="checkbox" name="uploadImage" value="${uploadImage.id}"></td>
		<td>${uploadImage.name}</td>
		<td>
			<a href="${uploadImage.sourceUrl}" title="${uploadImage.sourceUrl}" target="_blank"><img src="${uploadImage.sourceUrl}" style="width: 30px;height: 30px;" /></a>
		</td>
		<td>
			${uploadImage.wxUrl}
		</td>
		<td>${uploadImage.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="UploadImage.deleteUploadImage(${uploadImage.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>