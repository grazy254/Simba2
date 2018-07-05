<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tempMedia/tempMedia.js"></script>
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
									<h3 class="box-title">新增临时素材</h3>
								</div>
								<form role="form" onsubmit="return TempMedia.checkForm();" id="form" action="${base}/tempMedia/add" method="post" enctype="multipart/form-data">
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<select class="form-control" id="type" name="type">
												<#list types as type>
													<option value="${type.getName()}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="fileUrl">文件上传</label>
											<input type="file" id="file" name="file">
										</div>
										<div class="form-group">
											<div style="color: red;">
												图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式<br /> 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
												<br /> 视频（video）：10MB，支持MP4格式
												<br /> 缩略图（thumb）：64KB，支持JPG格式
												<br />
											</div>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TempMedia.toList();">取消</button>
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