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
									<h3 class="box-title">修改临时素材</h3>
								</div>
								<form role="form" onsubmit="return TempMedia.checkForm();" id="form" action="${base}/tempMedia/update">
									<input type="hidden" id="id" name="id" value="${tempMedia.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${tempMedia.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${tempMedia.type}" placeholder="请输入类型">
										</div>
										<div class="form-group">
											<label for="fileUrl">文件地址</label>
											<input type="text" class="form-control" id="fileUrl" name="fileUrl" value="${tempMedia.fileUrl}" placeholder="请输入文件地址">
										</div>
										<div class="form-group">
											<label for="mediaId">素材ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${tempMedia.mediaId}" placeholder="请输入素材ID">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${tempMedia.createTime}" placeholder="请输入时间">
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
		$(document).ready(function() {
		});
	</script>

</html>