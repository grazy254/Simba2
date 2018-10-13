<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/projectServerRel/projectServerRel.js"></script>
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
									<h3 class="box-title">修改项目绑定部署的服务器</h3>
								</div>
								<form role="form" onsubmit="return ProjectServerRel.checkForm();" id="form" action="${base}/projectServerRel/update">
									<input type="hidden" id="id" name="id" value="${projectServerRel.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="projectId">项目id</label>
											<input type="text" class="form-control" id="projectId" name="projectId" value="${projectServerRel.projectId}" placeholder="请输入项目id">
										</div>
										<div class="form-group">
											<label for="serverId">服务器id</label>
											<input type="text" class="form-control" id="serverId" name="serverId" value="${projectServerRel.serverId}" placeholder="请输入服务器id">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ProjectServerRel.toList();">取消</button>
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