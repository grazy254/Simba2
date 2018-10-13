<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/receiveEvent/receiveEvent.js"></script>
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
									<h3 class="box-title">新增收到事件</h3>
								</div>
								<form role="form" onsubmit="return ReceiveEvent.checkForm();" id="form" action="${base}/receiveEvent/add">
									<div class="box-body">
										<div class="form-group">
											<label for="openid">微信用户ID</label>
											<input type="text" class="form-control" id="openid" name="openid" placeholder="请输入微信用户ID">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="type">消息类型</label>
											<input type="text" class="form-control" id="type" name="type" placeholder="请输入消息类型">
										</div>
										<div class="form-group">
											<label for="event">事件类型</label>
											<input type="text" class="form-control" id="event" name="event" placeholder="请输入事件类型">
										</div>
										<div class="form-group">
											<label for="eventKey">事件KEY值</label>
											<input type="text" class="form-control" id="eventKey" name="eventKey" placeholder="请输入事件KEY值">
										</div>
										<div class="form-group">
											<label for="menuId">菜单ID</label>
											<input type="text" class="form-control" id="menuId" name="menuId" placeholder="请输入菜单ID">
										</div>
										<div class="form-group">
											<label for="scanType">扫描类型</label>
											<input type="text" class="form-control" id="scanType" name="scanType" placeholder="请输入扫描类型">
										</div>
										<div class="form-group">
											<label for="scanResult">扫描结果</label>
											<input type="text" class="form-control" id="scanResult" name="scanResult" placeholder="请输入扫描结果">
										</div>
										<div class="form-group">
											<label for="ticket">ticket</label>
											<input type="text" class="form-control" id="ticket" name="ticket" placeholder="请输入ticket">
										</div>
										<div class="form-group">
											<label for="latitude">地理位置纬度</label>
											<input type="text" class="form-control" id="latitude" name="latitude" placeholder="请输入地理位置纬度">
										</div>
										<div class="form-group">
											<label for="longitude">地理位置经度</label>
											<input type="text" class="form-control" id="longitude" name="longitude" placeholder="请输入地理位置经度">
										</div>
										<div class="form-group">
											<label for="eventPrecision">地理位置精度</label>
											<input type="text" class="form-control" id="eventPrecision" name="eventPrecision" placeholder="请输入地理位置精度">
										</div>
										<div class="form-group">
											<label for="xml">完整事件XML内容</label>
											<input type="text" class="form-control" id="xml" name="xml" placeholder="请输入完整事件XML内容">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ReceiveEvent.toList();">取消</button>
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