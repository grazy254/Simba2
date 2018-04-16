<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
		<script type="text/javascript" src="${base}/js/projectUser/projectUser.js"></script>
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
									<h3 class="box-title">修改</h3>
								</div>
								<form role="form" onsubmit="return ProjectUser.checkForm();" id="form" action="${base}/projectUser/update">
									<input type="hidden" id="id" name="id" value="${projectUser.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="account">账号</label>
											<input type="text" class="form-control" id="account" name="account" value="${projectUser.account}" placeholder="请输入account">
										</div>
										<div class="form-group">
											<label for="projectId">项目编号</label>
											<input type="text" class="form-control" id="projectId" name="projectId" value="${projectUser.projectId}" placeholder="请输入projectId">
										</div>
										<div class="form-group">
											<label for="type">权限类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${projectUser.type}" placeholder="请输入type">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ProjectUser.toList();">取消</button>
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