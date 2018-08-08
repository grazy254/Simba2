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
									<h3 class="box-title">修改apk管理</h3>
								</div>
								<form role="form" onsubmit="return ApkVersion.checkForm();" id="form" action="${base}/apkVersion/update">
									<input type="hidden" id="id" name="id" value="${apkVersion.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="version">版本号</label>
											<input type="text" class="form-control" id="version" name="version" value="${apkVersion.version}" placeholder="请输入版本号">
										</div>
										<div class="form-group">
											<label for="versionName">版本名</label>
											<input type="text" class="form-control" id="versionName" name="versionName" value="${apkVersion.versionName}" placeholder="请输入版本名">
										</div>
										<div class="form-group">
											<label for="typeId">类型ID</label>
											<input type="text" class="form-control" id="typeId" name="typeId" value="${apkVersion.typeId}" placeholder="请输入类型ID">
										</div>
										<div class="form-group">
											<label for="fileSize">文件大小</label>
											<input type="text" class="form-control" id="fileSize" name="fileSize" value="${apkVersion.fileSize}" placeholder="请输入文件大小">
										</div>
										<div class="form-group">
											<label for="fileUrl">文件路径</label>
											<input type="text" class="form-control" id="fileUrl" name="fileUrl" value="${apkVersion.fileUrl}" placeholder="请输入文件路径">
										</div>
										<div class="form-group">
											<label for="description">文件描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${apkVersion.description}" placeholder="请输入文件描述">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${apkVersion.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="type">type</label>
											<input type="text" class="form-control" id="type" name="type" value="${apkVersion.type}" placeholder="请输入type">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
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