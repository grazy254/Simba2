<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/uploadVideo/uploadVideo.js"></script>
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
									<h3 class="box-title">修改上传视频</h3>
								</div>
								<form role="form" onsubmit="return UploadVideo.checkForm();" id="form" action="${base}/uploadVideo/update">
									<input type="hidden" id="id" name="id" value="${uploadVideo.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${uploadVideo.title}" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="description">描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${uploadVideo.description}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="mediaId">素材ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${uploadVideo.mediaId}" placeholder="请输入素材ID">
										</div>
										<div class="form-group">
											<label for="targetMediaId">目标素材ID</label>
											<input type="text" class="form-control" id="targetMediaId" name="targetMediaId" value="${uploadVideo.targetMediaId}" placeholder="请输入目标素材ID">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${uploadVideo.createTime}" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="UploadVideo.toList();">取消</button>
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