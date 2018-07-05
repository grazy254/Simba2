<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/uploadImage/uploadImage.js"></script>
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
									<h3 class="box-title">修改上传图片</h3>
								</div>
								<form role="form" onsubmit="return UploadImage.checkForm();" id="form" action="${base}/uploadImage/update">
									<input type="hidden" id="id" name="id" value="${uploadImage.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${uploadImage.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="sourceUrl">原文件地址</label>
											<input type="text" class="form-control" id="sourceUrl" name="sourceUrl" value="${uploadImage.sourceUrl}" placeholder="请输入原文件地址">
										</div>
										<div class="form-group">
											<label for="wxUrl">微信端地址</label>
											<input type="text" class="form-control" id="wxUrl" name="wxUrl" value="${uploadImage.wxUrl}" placeholder="请输入微信端地址">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${uploadImage.createTime}" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="UploadImage.toList();">取消</button>
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