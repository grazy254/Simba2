<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/iOSVersion/iOSVersion.js"></script>
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
									<h3 class="box-title">修改${typeName}</h3>
								</div>
								<form role="form" onsubmit="return IOSVersion.checkForm();" id="form" action="${base}/iOSVersion/update" method="post" enctype="multipart/form-data">
									<input type="hidden" id="id" name="id" value="${iOSVersion.id}" />
									<input type="hidden" id="typeId" name="typeId" value="${iOSVersion.typeId}" />
									<input type="hidden" id="fileSize" name="fileSize" value="${iOSVersion.fileSize}" />
									<input type="hidden" id="ipaFileUrl" name="ipaFileUrl" value="${iOSVersion.ipaFileUrl}" />
									<input type="hidden" id="fullImageFileUrl" name="fullImageFileUrl" value="${iOSVersion.fullImageFileUrl}" />
									<input type="hidden" id="logFileUrl" name="logFileUrl" value="${iOSVersion.logFileUrl}" />
									<div class="box-body">
										<div class="form-group">
											<label for="version">版本号</label>
											<input type="text" class="form-control" id="version" name="version" value="${iOSVersion.version}" placeholder="请输入版本号">
										</div>
										<div class="form-group">
											<label for="description">文件描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${iOSVersion.description}" placeholder="请输入文件描述">
										</div>
										<div class="form-group">
											<label for="identifer">ISO版本Identifer属性</label>
											<input type="text" class="form-control" id="identifer" name="identifer" value="${iOSVersion.identifer}" placeholder="请输入ISO版本Identifer属性">
										</div>
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${iOSVersion.title}" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="ipaFile">上传IPA文件</label>
											<input type="file" id="ipaFile" name="ipaFile">
										</div>
										<div class="form-group">
											<label for="fullImageFile">上传大图片文件</label>
											<input type="file" id="fullImageFile" name="fullImageFile">
										</div>

										<div class="form-group">
											<label for="logFile">上传logo文件</label>
											<input type="file" id="logFile" name="logFile">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="IOSVersion.toList();">取消</button>
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