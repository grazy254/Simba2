<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/device/device.js"></script>
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
									<h3 class="box-title">修改设备</h3>
								</div>
								<form role="form" onsubmit="return Device.checkForm();" id="form" action="${base}/device/update">
									<input type="hidden" id="id" name="id" value="${device.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="wxDeviceId">微信设备ID</label>
											<input type="text" class="form-control" id="wxDeviceId" name="wxDeviceId" value="${device.wxDeviceId}" placeholder="请输入微信设备ID">
										</div>
										<div class="form-group">
											<label for="qrcode">二维码</label>
											<input type="text" class="form-control" id="qrcode" name="qrcode" value="${device.qrcode}" placeholder="请输入二维码">
										</div>
										<div class="form-group">
											<label for="wxProductId">微信产品ID</label>
											<input type="text" class="form-control" id="wxProductId" name="wxProductId" value="${device.wxProductId}" placeholder="请输入微信产品ID">
										</div>
										<input type="hidden" id="status" name="status" value="${device.status}" />
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Device.toList();">取消</button>
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