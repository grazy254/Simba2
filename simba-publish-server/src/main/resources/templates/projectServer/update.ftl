<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/projectServer/projectServer.js"></script>
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
									<h3 class="box-title">修改服务器</h3>
								</div>
								<form role="form" onsubmit="return ProjectServer.checkForm();" id="form" action="${base}/projectServer/update">
									<input type="hidden" id="id" name="id" value="${projectServer.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${projectServer.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="ip">IP</label>
											<input type="text" class="form-control" id="ip" name="ip" value="${projectServer.ip}" placeholder="请输入IP">
										</div>
										<div class="form-group">
											<label for="port">端口号</label>
											<input type="text" class="form-control" id="port" name="port" value="${projectServer.port}" placeholder="请输入端口号">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ProjectServer.toList();">取消</button>
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