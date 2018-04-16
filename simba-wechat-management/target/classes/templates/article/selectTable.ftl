<#list list as article>
	<tr>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="Article.selectedArticle(${article.id},'${article.title}');"><i class="fa fa-check"></i>选择</button>
		</td>
		<td>${article.title}</td>
		<td>${article.author!}</td>
		<td>${article.digest!}</td>
		<td>
			<#if article.showCoverPic==0>否</#if>
			<#if article.showCoverPic==1>是</#if>
		</td>
		<td>${article.contentSourceUrl!}</td>
		<td>${article.thumbMediaId!}
			<#if article.imageUrl??>
				<a href="${article.imageUrl}" title="${article.imageUrl}" target="_blank"><img src="${article.imageUrl}" style="width: 30px;height: 30px;" /></a>
			</#if>
		</td>
		<td>
			<#if article.type==1>临时</#if>
			<#if article.type==2>永久</#if>
		</td>
		<td>${article.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
	</tr>
</#list>