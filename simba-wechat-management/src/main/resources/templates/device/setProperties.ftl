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
								<form role="form" onsubmit="return false;" id="form" action="${base}/device/setWxProperties">
									<input type="hidden" id="selectedDevice" name="selectedDevice" value="${selectedDevice}" />
									<div class="box-body">
										<div class="form-group">
											<label for="connect_protocol">连接协议</label>
											<select id="connect_protocol" class="form-control" name="connect_protocol">
												<option value="1">android classic bluetooth</option>
												<option value="2">ios classic bluetooth</option>
												<option value="3">ble</option>
												<option value="4">wifi</option>
											</select>
										</div>
										<div class="form-group">
											<label for="auth_key">auth及通信的加密key:</label>
											<input type="text" class="form-control" id="auth_key" name="auth_key" placeholder="请输入auth及通信的加密key"><br />
											<span style="color: red;">(第三方需要将key烧制在设备上（128bit），格式采用16进制串的方式（长度为32字节），不需要0X前缀，如1234567890ABCDEF1234567890ABCDEF)</span>
										</div>
										<div class="form-group">
											<label for="close_strategy">断开策略</label>
											<select id="close_strategy" name="close_strategy" class="form-control">
												<option value="1">退出公众号页面时即断开连接</option>
												<option value="2">退出公众号之后保持连接不断开</option>
											</select>
										</div>
										<div class="form-group">
											<label for="conn_strategy">连接策略</label>
											<select id="conn_strategy" name="conn_strategy" class="form-control">
												<option value="1">在公众号对话页面，不停的尝试连接设备</option>
												<option value="4">处于非公众号页面（如主界面等），微信自动连接</option>
											</select>
										</div>
										<div class="form-group">
											<label for="crypt_method">auth加密方法</label>
											<select id="crypt_method" name="crypt_method" class="form-control">
												<option value="0">不加密</option>
												<option value="1">加密</option>
											</select>
										</div>
										<div class="form-group">
											<label for="auth_ver">auth版本</label>
											<select id="auth_ver" name="auth_ver" class="form-control">
												<option value="0">不加密版本</option>
												<option value="1">加密版本</option>
											</select>
										</div>
										<div class="form-group">
											<label for="manu_mac_pos">mac地址在厂商广播manufature data里含有mac地址的偏移</label>
											<select id="manu_mac_pos" name="manu_mac_pos" class="form-control">
												<option value="-1">在尾部</option>
												<option value="-2">不包含mac地址</option>
											</select>
										</div>
										<div class="form-group">
											<label for="ser_mac_pos">mac地址在厂商serial number里含有mac地址的偏移</label>
											<select id="ser_mac_pos" name="ser_mac_pos" class="form-control">
												<option value="-1">在尾部</option>
												<option value="-2">不包含mac地址</option>
											</select>
										</div>
										<div class="form-group">
											<label for="ble_simple_protocol">精简协议类型</label>
											<select id="ble_simple_protocol" name="ble_simple_protocol" class="form-control">
												<option value="0">无</option>
												<option value="1">计步设备精简协议</option>
											</select>
										</div>
										<div class="form-group">
											<div style="color: red;" id="errMsg"></div>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="button" class="btn btn-success" onclick="Device.submitSetProperties()">提交</button>
										<button type="button" class="btn" onclick="Device.cancelSetProperties();">取消</button>
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