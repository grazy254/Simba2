<#list list as uploadNews>
	<tr>
		<td>${uploadNews.name}</td>
		<td>${uploadNews.mediaId}</td>
		<td>${uploadNews.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="UploadNews.showArticle(${uploadNews.id});"><i class="fa fa-eye"></i>查看图文内容</button>
		</td>
	</tr>
</#list>