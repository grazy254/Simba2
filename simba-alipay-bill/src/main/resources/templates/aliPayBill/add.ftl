<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/aliPayBill/aliPayBill.js"></script>
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
									<h3 class="box-title">新增阿里支付账单</h3>
								</div>
								<form role="form" onsubmit="return AliPayBill.checkForm();" id="form" action="${base}/aliPayBill/add">
									<div class="box-body">
										<div class="form-group">
											<label for="appid">应用ID</label>
											<input type="text" class="form-control" id="appid" name="appid" placeholder="请输入应用ID">
										</div>
										<div class="form-group">
											<label for="body">描述</label>
											<input type="text" class="form-control" id="body" name="body" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="totalAmount">订单总金额</label>
											<input type="text" class="form-control" id="totalAmount" name="totalAmount" placeholder="请输入订单总金额">
										</div>
										<div class="form-group">
											<label for="subject">标题</label>
											<input type="text" class="form-control" id="subject" name="subject" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="outTradeNo">商户订单号</label>
											<input type="text" class="form-control" id="outTradeNo" name="outTradeNo" placeholder="请输入商户订单号">
										</div>
										<div class="form-group">
											<label for="tradeNo">支付宝交易流水号</label>
											<input type="text" class="form-control" id="tradeNo" name="tradeNo" placeholder="请输入支付宝交易流水号">
										</div>
										<div class="form-group">
											<label for="productCode">产品码</label>
											<input type="text" class="form-control" id="productCode" name="productCode" placeholder="请输入产品码">
										</div>
										<div class="form-group">
											<label for="goodType">商品主类型</label>
											<input type="text" class="form-control" id="goodType" name="goodType" placeholder="请输入商品主类型">
										</div>
										<div class="form-group">
											<label for="storeId">商户门店编号</label>
											<input type="text" class="form-control" id="storeId" name="storeId" placeholder="请输入商户门店编号">
										</div>
										<div class="form-group">
											<label for="sellId">收款支付宝账号ID</label>
											<input type="text" class="form-control" id="sellId" name="sellId" placeholder="请输入收款支付宝账号ID">
										</div>
										<div class="form-group">
											<label for="timeoutExpress">最晚付款时间</label>
											<input type="text" class="form-control" id="timeoutExpress" name="timeoutExpress" placeholder="请输入最晚付款时间">
										</div>
										<div class="form-group">
											<label for="createTime">订单时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入订单时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="AliPayBill.toList();">取消</button>
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