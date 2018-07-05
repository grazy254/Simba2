<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/looseMoneyBill/looseMoneyBill.js"></script>
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
									<h3 class="box-title">修改零钱账单</h3>
								</div>
								<form role="form" onsubmit="return LooseMoneyBill.checkForm();" id="form" action="${base}/looseMoneyBill/update">
									<input type="hidden" id="id" name="id" value="${looseMoneyBill.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="appid">商户账号appid</label>
											<input type="text" class="form-control" id="appid" name="appid" value="${looseMoneyBill.appid}" placeholder="请输入商户账号appid">
										</div>
										<div class="form-group">
											<label for="mchid">商户号</label>
											<input type="text" class="form-control" id="mchid" name="mchid" value="${looseMoneyBill.mchid}" placeholder="请输入商户号">
										</div>
										<div class="form-group">
											<label for="deviceInfo">设备号</label>
											<input type="text" class="form-control" id="deviceInfo" name="deviceInfo" value="${looseMoneyBill.deviceInfo}" placeholder="请输入设备号">
										</div>
										<div class="form-group">
											<label for="partnerTradeNo">商户订单号</label>
											<input type="text" class="form-control" id="partnerTradeNo" name="partnerTradeNo" value="${looseMoneyBill.partnerTradeNo}" placeholder="请输入商户订单号">
										</div>
										<div class="form-group">
											<label for="openid">用户openid</label>
											<input type="text" class="form-control" id="openid" name="openid" value="${looseMoneyBill.openid}" placeholder="请输入用户openid">
										</div>
										<div class="form-group">
											<label for="reUserName">收款用户姓名</label>
											<input type="text" class="form-control" id="reUserName" name="reUserName" value="${looseMoneyBill.reUserName}" placeholder="请输入收款用户姓名">
										</div>
										<div class="form-group">
											<label for="amount">金额</label>
											<input type="text" class="form-control" id="amount" name="amount" value="${looseMoneyBill.amount}" placeholder="请输入金额">
										</div>
										<div class="form-group">
											<label for="description">企业付款描述信息</label>
											<input type="text" class="form-control" id="description" name="description" value="${looseMoneyBill.description}" placeholder="请输入企业付款描述信息">
										</div>
										<div class="form-group">
											<label for="clientIp">Ip地址</label>
											<input type="text" class="form-control" id="clientIp" name="clientIp" value="${looseMoneyBill.clientIp}" placeholder="请输入Ip地址">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" value="${looseMoneyBill.status}" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="errMsg">错误信息</label>
											<input type="text" class="form-control" id="errMsg" name="errMsg" value="${looseMoneyBill.errMsg}" placeholder="请输入错误信息">
										</div>
										<div class="form-group">
											<label for="paymentNo">微信订单号</label>
											<input type="text" class="form-control" id="paymentNo" name="paymentNo" value="${looseMoneyBill.paymentNo}" placeholder="请输入微信订单号">
										</div>
										<div class="form-group">
											<label for="paymentTime">微信支付成功时间</label>
											<input type="text" class="form-control" id="paymentTime" name="paymentTime" value="${looseMoneyBill.paymentTime}" placeholder="请输入微信支付成功时间">
										</div>
										<div class="form-group">
											<label for="createTime">创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${looseMoneyBill.createTime}" placeholder="请输入创建时间">
										</div>
										<div class="form-group">
											<label for="createUser">付款者</label>
											<input type="text" class="form-control" id="createUser" name="createUser" value="${looseMoneyBill.createUser}" placeholder="请输入付款者">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="LooseMoneyBill.toList();">取消</button>
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