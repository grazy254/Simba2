<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/deviceBind/deviceBind.js"></script>
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
									<h3 class="box-title">修改设备绑定</h3>
								</div>
								<form role="form" onsubmit="return DeviceBind.checkForm();" id="form" action="${base}/deviceBind/update">
									<input type="hidden" id="id" name="id" value="${deviceBind.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="openid">微信用户ID</label>
											<input type="text" class="form-control" id="openid" name="openid" value="${deviceBind.openid}" placeholder="请输入微信用户ID">
										</div>
										<div class="form-group">
											<label for="wxDeviceId">微信设备ID</label>
											<input type="text" class="form-control" id="wxDeviceId" name="wxDeviceId" value="${deviceBind.wxDeviceId}" placeholder="请输入微信设备ID">
										</div>
										<div class="form-group">
											<label for="createTime">createTime</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${deviceBind.createTime}" placeholder="请输入createTime">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="DeviceBind.toList();">取消</button>
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