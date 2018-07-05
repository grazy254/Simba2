<#list list as article>
	<tr>
		<td><input type="checkbox" name="article" value="${article.id}"></td>
		<td>${article.title}</td>
		<td>${article.thumbMediaId!}
			<#if article.imageUrl??>
				<a href="${article.imageUrl}" title="${article.imageUrl}" target="_blank"><img src="${article.imageUrl}" style="width: 30px;height: 30px;" /></a>
			</#if>
		</td>
		<td>${article.author!}</td>
		<td>${article.digest!}</td>
		<td>
			<#if article.showCoverPic==0>否</#if>
			<#if article.showCoverPic==1>是</#if>
		</td>
		<td>${article.contentSourceUrl!}</td>
		<td>
			<#if article.type==1>临时</#if>
			<#if article.type==2>永久</#if>
		</td>
		<td>${article.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Article.toUpdate(${article.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Article.deleteArticle(${article.id});"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="Article.showContent(${article.id});"><i class="fa fa-eye"></i>查看内容</button>
		</td>
	</tr>
</#list>