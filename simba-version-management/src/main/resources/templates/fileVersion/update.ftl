<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/fileVersion/fileVersion.js"></script>
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
								<form role="form" onsubmit="return FileVersion.checkForm();" id="form" action="${base}/fileVersion/update" method="post" enctype="multipart/form-data">
									<input type="hidden" id="id" name="id" value="${fileVersion.id}" />
									<input type="hidden" id="typeId" name="typeId" value="${fileVersion.typeId}" />
									<input type="hidden" id="fileSize" name="fileSize" value="${fileVersion.fileSize}" />
									<input type="hidden" id="fileUrl" name="fileUrl" value="${fileVersion.fileUrl}" />
									<div class="box-body">
										<div class="form-group">
											<label for="version">版本号</label>
											<input type="text" class="form-control" id="version" name="version" value="${fileVersion.version}" placeholder="请输入版本号">
										</div>
										<div class="form-group">
											<label for="description">文件描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${fileVersion.description}" placeholder="请输入文件描述">
										</div>
										<div class="form-group">
											<label for="extProps">扩展属性</label>
											<input type="text" class="form-control" id="extProps" name="extProps" value="${fileVersion.extProps}" placeholder="请输入扩展属性">
										</div>
										<div class="form-group">
											<label for="fileUrl">文件上传</label>
											<input type="file" id="file" name="file">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="FileVersion.toList();">取消</button>
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