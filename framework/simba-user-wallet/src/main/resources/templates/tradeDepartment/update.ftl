<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tradeDepartment/tradeDepartment.js"></script>
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
									<h3 class="box-title">修改收款部门</h3>
								</div>
								<form role="form" onsubmit="return TradeDepartment.checkForm();" id="form" action="${base}/tradeDepartment/update">
									<input type="hidden" id="id" name="id" value="${tradeDepartment.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="deptNO">部门编号</label>
											<input type="text" class="form-control" id="deptNO" name="deptNO" value="${tradeDepartment.deptNO}" placeholder="请输入部门编号">
										</div>
										<div class="form-group">
											<label for="deptName">部门名称</label>
											<input type="text" class="form-control" id="deptName" name="deptName" value="${tradeDepartment.deptName}" placeholder="请输入部门名称">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TradeDepartment.toList();">取消</button>
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