<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/deviceBind/deviceBind.js"></script>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">设备绑定管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<label for="openid">微信用户ID:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入微信用户ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectFans('openid');"><i class="fa fa-search"></i></button>
										<label for="wxDeviceId">微信设备ID:</label>
										<input type="text" id="wxDeviceId" name="wxDeviceId" placeholder="请输入微信设备ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="DeviceBind.search();"><i class="fa fa-search"></i>
                查询</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>微信用户ID</th>
												<th>微信设备ID</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
								</div>
								<!-- /.mail-box-messages -->
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
			DeviceBind.initDeviceBindList(0, Page.size);
		});
	</script>

</html>