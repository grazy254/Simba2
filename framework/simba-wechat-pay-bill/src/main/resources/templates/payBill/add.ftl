<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/payBill/payBill.js"></script>
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
									<h3 class="box-title">新增支付账单</h3>
								</div>
								<form role="form" onsubmit="return PayBill.checkForm();" id="form" action="${base}/payBill/add">
									<div class="box-body">
										<div class="form-group">
											<label for="appid">AppID</label>
											<input type="text" class="form-control" id="appid" name="appid" placeholder="请输入AppID">
										</div>
										<div class="form-group">
											<label for="mchId">商户号</label>
											<input type="text" class="form-control" id="mchId" name="mchId" placeholder="请输入商户号">
										</div>
										<div class="form-group">
											<label for="deviceInfo">设备号</label>
											<input type="text" class="form-control" id="deviceInfo" name="deviceInfo" placeholder="请输入设备号">
										</div>
										<div class="form-group">
											<label for="productDesc">商品描述</label>
											<input type="text" class="form-control" id="productDesc" name="productDesc" placeholder="请输入商品描述">
										</div>
										<div class="form-group">
											<label for="detail">商品详情</label>
											<input type="text" class="form-control" id="detail" name="detail" placeholder="请输入商品详情">
										</div>
										<div class="form-group">
											<label for="attach">附加数据</label>
											<input type="text" class="form-control" id="attach" name="attach" placeholder="请输入附加数据">
										</div>
										<div class="form-group">
											<label for="outTradeNo">商户订单号</label>
											<input type="text" class="form-control" id="outTradeNo" name="outTradeNo" placeholder="请输入商户订单号">
										</div>
										<div class="form-group">
											<label for="fee">标价金额</label>
											<input type="text" class="form-control" id="fee" name="fee" placeholder="请输入标价金额">
										</div>
										<div class="form-group">
											<label for="clientIp">终端IP</label>
											<input type="text" class="form-control" id="clientIp" name="clientIp" placeholder="请输入终端IP">
										</div>
										<div class="form-group">
											<label for="startTime">交易起始时间</label>
											<input type="text" class="form-control" id="startTime" name="startTime" placeholder="请输入交易起始时间">
										</div>
										<div class="form-group">
											<label for="endTime">交易结束时间</label>
											<input type="text" class="form-control" id="endTime" name="endTime" placeholder="请输入交易结束时间">
										</div>
										<div class="form-group">
											<label for="goodsTag">订单优惠标记</label>
											<input type="text" class="form-control" id="goodsTag" name="goodsTag" placeholder="请输入订单优惠标记">
										</div>
										<div class="form-group">
											<label for="notifyUrl">通知地址</label>
											<input type="text" class="form-control" id="notifyUrl" name="notifyUrl" placeholder="请输入通知地址">
										</div>
										<div class="form-group">
											<label for="tradeType">交易类型</label>
											<input type="text" class="form-control" id="tradeType" name="tradeType" placeholder="请输入交易类型">
										</div>
										<div class="form-group">
											<label for="productId">商品ID</label>
											<input type="text" class="form-control" id="productId" name="productId" placeholder="请输入商品ID">
										</div>
										<div class="form-group">
											<label for="openid">用户标识</label>
											<input type="text" class="form-control" id="openid" name="openid" placeholder="请输入用户标识">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="errMsg">错误信息</label>
											<input type="text" class="form-control" id="errMsg" name="errMsg" placeholder="请输入错误信息">
										</div>
										<div class="form-group">
											<label for="prepayId">预支付交易会话标识</label>
											<input type="text" class="form-control" id="prepayId" name="prepayId" placeholder="请输入预支付交易会话标识">
										</div>
										<div class="form-group">
											<label for="codeUrl">二维码链接</label>
											<input type="text" class="form-control" id="codeUrl" name="codeUrl" placeholder="请输入二维码链接">
										</div>
										<div class="form-group">
											<label for="mwebUrl">H5支付链接</label>
											<input type="text" class="form-control" id="mwebUrl" name="mwebUrl" placeholder="请输入H5支付链接">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="PayBill.toList();">取消</button>
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