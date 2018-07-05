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
									<h3 class="box-title">新增上传视频</h3>
								</div>
								<form role="form" onsubmit="return UploadVideo.checkForm();" id="form" action="${base}/uploadVideo/add">
									<div class="box-body">
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="description">描述</label>
											<input type="text" class="form-control" id="description" name="description" placeholder="请输入描述">
										</div>
										<div class="form-group" id="videoDiv">
											<label for="videoSelect">视频</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="UploadVideo.selectTempVideo();"><i class="fa fa-search"></i>临时视频</button>
										</div>
										<input type="hidden" id="mediaId" name="mediaId">
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
		$(document).ready(function() {});
	</script>

</html>