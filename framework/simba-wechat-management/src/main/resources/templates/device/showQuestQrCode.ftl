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
								</div>
								<div class="box-body">
									<div class="form-group">
										<label for="wxProductId">微信产品ID</label>
										<input type="text" class="form-control" id="wxProductId" name="wxProductId" placeholder="请输入微信产品ID">
									</div>
									<div class="form-group">
										<label for="num">个数</label>
										<input type="number" class="form-control" id="num" name="num" placeholder="请输入个数">
									</div>
									<div class="form-group">
										<div style="color: red;" id="errMsg"></div>
									</div>
								</div>
								<!-- /.box-body -->

								<div class="box-footer">
									<button type="button" class="btn btn-success" onclick="Device.exeQrCode();">提交</button>
									<button type="button" class="btn" onclick="Device.cancelQrCode();">取消</button>
								</div>

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