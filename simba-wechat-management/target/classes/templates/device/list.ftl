<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/device/device.js"></script>
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
									<h3 class="box-title">设备管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<input type="hidden" id="selectedDevice" name="selectedDevice" value="" />
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="status">状态:</label>
										<select id="status" name="status">
											<option value="">无</option>
											<option value="0">空闲</option>
											<option value="1">已用</option>
										</select>
										<label for="wxDeviceId">微信设备ID:</label>
										<input type="text" id="wxDeviceId" name="wxDeviceId" placeholder="请输入微信设备ID">
										<label for="qrcode">二维码:</label>
										<input type="text" id="qrcode" name="qrcode" placeholder="请输入二维码">
										<label for="wxProductId">微信产品ID:</label>
										<input type="text" id="wxProductId" name="wxProductId" placeholder="请输入微信产品ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Device.search();"><i class="fa fa-search"></i>
                查询</button>
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm" onclick="Device.requestQrCode();"><i class="fa fa-location-arrow"></i>请求微信设备二维码</button>
											<button type="button" class="btn btn-default btn-sm" onclick="Device.setProperties();"><i class="fa fa-gear"></i>设置微信设备属性</button>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>微信设备ID</th>
												<th>二维码</th>
												<th>微信产品ID</th>
												<th>状态</th>
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
			Device.initDeviceList(0, Page.size);
		});
	</script>

</html>