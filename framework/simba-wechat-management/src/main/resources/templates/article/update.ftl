<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/article/article.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">

						<!-- /.col -->
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">修改图文内容</h3>
								</div>
								<form role="form" onsubmit="return Article.checkForm();" id="form" action="${base}/article/update" method="post" enctype="multipart/form-data">
									<input type="hidden" id="id" name="id" value="${article.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${article.title}" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="author">作者</label>
											<input type="text" class="form-control" id="author" name="author" value="${article.author}" placeholder="请输入作者">
										</div>
										<div class="form-group">
											<label for="digest">描述</label>
											<input type="text" class="form-control" id="digest" name="digest" value="${article.digest}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="showCoverPic">显示封面</label>
											<select id="showCoverPic" name="showCoverPic" class="form-control">
												<option value="0">否</option>
												<option value="1">是</option>
											</select>
										</div>
										<div class="form-group">
											<label for="content">内容</label>
											<textarea class="form-control" rows="20" placeholder="请输入内容" id="content" name="content">${article.content}</textarea>
										</div>
										<div class="form-group">
											<div style="color: red;">
												插入小程序卡片，可以在内容中插入如下文本:<br /> &lt;mp-miniprogram data-miniprogram-appid="小程序的AppID" data-miniprogram-path="点击小程序卡片时要打开的路径" data-miniprogram-title="小程序卡片的标题，不超过35个字" data-progarm-imageurl="小程序卡片的封面图链接，图片必须为1080*864像素"&gt;&lt;/mp-miniprogram&gt;
											</div>
										</div>
										<div class="form-group">
											<label for="contentSourceUrl">原文地址</label>
											<input type="text" class="form-control" id="contentSourceUrl" name="contentSourceUrl" value="${article.contentSourceUrl}" placeholder="请输入原文地址">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<select id="type" name="type" class="form-control">
												<#list types as type>
													<option value="${type.id}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="file">图片</label>
											<input type="file" id="file" name="file">
										</div>
										<div class="form-group">
											<label for="thumbMediaId">图片</label>
											<div id="imageDiv" style="display: block;">
												<img id="selectedImage" src="${article.imageUrl}" style="width: 50px;height: 50px;" />
											</div>
											<input type="hidden" id="thumbMediaId" name="thumbMediaId" value="${article.thumbMediaId}" />
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Article.showImages();"><i class="fa fa-search"></i>
                选择图片</button>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Article.toList();">取消</button>
									</div>
								</form>

							</div>
						</div>
						<!-- /. box -->
					</div>
					<!-- /.col -->
			</div>
			<!-- /.row -->
			</section>
			<!-- /.content -->

		</div>
		<!-- /.content-wrapper -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		</div>
		<!-- ./wrapper -->

	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#showCoverPic").val("${article.showCoverPic}");
			$("#type").val("${article.type}");
		});
	</script>

</html>