<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/foreverMedia/foreverMedia.js"></script>
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
									<h3 class="box-title">新增永久素材</h3>
								</div>
								<form role="form" onsubmit="return ForeverMedia.checkForm();" id="form" action="${base}/foreverMedia/add" method="post" enctype="multipart/form-data">
									<div class="box-body">
										<div class="form-group">
											<label for="type">类型</label>
											<select class="form-control" id="type" name="type" onchange="ForeverMedia.changeType();">
												<#list types as type>
													<option value="${type.getName()}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
										</div>
										<div class="form-group" id="fileDiv">
											<label for="file">文件</label>
											<input type="file" id="file" name="file">
										</div>
										<div class="form-group" id="titleDiv">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
										</div>
										<div class="form-group" id="introductionDiv">
											<label for="introduction">描述</label>
											<input type="text" class="form-control" id="introduction" name="introduction" placeholder="请输入描述">
										</div>
										<div class="form-group" id="newsDiv">
											<label>图文内容</label>
											<input type="hidden" id="articles" name="articles" />
											<div id="articleContent"></div>
											<button type="button" class="btn" onclick="ForeverMedia.selectArticle();"><i class="fa fa-search"></i>选择图文内容</button>
										</div>
										<div class="form-group">
											<div style="color: red;">
												图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式<br /> 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
												<br /> 视频（video）：10MB，支持MP4格式
												<br /> 缩略图（thumb）：64KB，支持JPG格式
												<br /> 公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000。
												<br /> 永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）
												<br />
											</div>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ForeverMedia.toList();">取消</button>
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
			ForeverMedia.changeType();
		});
	</script>

</html>