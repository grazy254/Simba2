<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/applicationUser/applicationUser.js"></script>
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
									<h3 class="box-title">新增用户应用表</h3>
								</div>
								<form role="form" onsubmit="return ApplicationUser.checkForm();" id="form" action="${base}/applicationUser/add">
									<div class="box-body">
										<div class="form-group">
											<label for="applicationId">应用id</label>
											<input type="text" class="form-control" id="applicationId" name="applicationId" placeholder="请输入应用id">
										</div>
										<div class="form-group">
											<label for="userId">用户id</label>
											<input type="text" class="form-control" id="userId" name="userId" placeholder="请输入用户id">
										</div>
										<div class="form-group">
											<label for="userType">用户类型</label>
											<input type="text" class="form-control" id="userType" name="userType" placeholder="请输入用户类型">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ApplicationUser.toList();">取消</button>
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