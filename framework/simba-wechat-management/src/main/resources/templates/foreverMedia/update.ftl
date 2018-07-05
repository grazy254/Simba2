<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
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
									<h3 class="box-title">修改永久素材</h3>
								</div>
								<form role="form" onsubmit="return ForeverMedia.checkForm();" id="form" action="${base}/foreverMedia/update">
									<input type="hidden" id="id" name="id" value="${foreverMedia.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="mediaId">素材ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${foreverMedia.mediaId}" placeholder="请输入素材ID">
										</div>
										<div class="form-group">
											<label for="articles">图文内容</label>
											<input type="text" class="form-control" id="articles" name="articles" value="${foreverMedia.articles}" placeholder="请输入图文内容">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${foreverMedia.type}" placeholder="请输入类型">
										</div>
										<div class="form-group">
											<label for="fileUrl">文件地址</label>
											<input type="text" class="form-control" id="fileUrl" name="fileUrl" value="${foreverMedia.fileUrl}" placeholder="请输入文件地址">
										</div>
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${foreverMedia.title}" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="introduction">描述</label>
											<input type="text" class="form-control" id="introduction" name="introduction" value="${foreverMedia.introduction}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="imageUrl">图片URL</label>
											<input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${foreverMedia.imageUrl}" placeholder="请输入图片URL">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${foreverMedia.createTime}" placeholder="请输入时间">
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
		});
	</script>

</html>