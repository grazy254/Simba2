<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/commonFile/commonFile.js"></script>
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
								<form role="form" onsubmit="return CommonFile.checkForm();" id="form" action="${base}/commonFile/update" method="post" enctype="multipart/form-data">
									<input type="hidden" id="id" name="id" value="${commonFile.id}" />
									<input type="hidden" id="typeId" name="typeId" value="${commonFile.typeId}" />
									<input type="hidden" id="fileSize" name="fileSize" value="${commonFile.fileSize}" />
									<input type="hidden" id="fileUrl" name="fileUrl" value="${commonFile.fileUrl}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${commonFile.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="description">描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${commonFile.description}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="extProps">扩展属性</label>
											<input type="text" class="form-control" id="extProps" name="extProps" value="${commonFile.extProps}" placeholder="请输入扩展属性">
										</div>
										<div class="form-group">
											<label for="fileUrl">文件上传</label>
											<input type="file" id="file" name="file">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="CommonFile.toList();">取消</button>
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