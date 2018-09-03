<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/apkVersion/apkVersion.js"></script>
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
									<h3 class="box-title">新增apk管理</h3>
								</div>
								<form role="form" onsubmit="return ApkVersion.checkForm();" id="form" action="${base}/apkVersion/add" method="post" enctype="multipart/form-data">
									<input id="token" name="token" value="${post_token}" type="hidden"/>
									<div class="box-body">
										<div class="form-group">
											<label for="versionName">版本名</label>
											<input type="text" class="form-control" id="versionName" name="versionName" placeholder="请输入版本名">
										</div>
										<div class="form-group">
											<label for="description">文件描述</label>
											<input type="text" class="form-control" id="description" name="description" placeholder="请输入文件描述">
										</div>
                                        <div class="form-group">
                                            <label for="file">文件上传</label>
                                            <input type="file" id="file" name="file">
                                        </div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button id="submitButt" type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ApkVersion.toList();">取消</button>
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