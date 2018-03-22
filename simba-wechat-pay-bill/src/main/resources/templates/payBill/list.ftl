<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/payBill/payBill.js"></script>
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
									<h3 class="box-title">支付账单管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<label for="outTradeNo">商户订单号:</label>
										<input type="text" id="outTradeNo" name="outTradeNo" placeholder="请输入商户订单号">
										<label for="goodsTag">订单优惠标记:</label>
										<input type="text" id="goodsTag" name="goodsTag" placeholder="请输入订单优惠标记">
										<label for="tradeType">交易类型:</label>
										<input type="text" id="tradeType" name="tradeType" placeholder="请输入交易类型">
										<label for="productId">商品ID:</label>
										<input type="text" id="productId" name="productId" placeholder="请输入商品ID">
										<label for="openid">openid:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入openid">
										<label for="status">状态:</label>
										<select id ="status" name="status">
											<#list payBill?keys as key>
												<option value="${key}">${payBill["${key}"]}</option>
											</#list>
										</select>
										<label for="prepayId">预支付交易会话标识:</label>
										<input type="text" id="prepayId" name="prepayId" placeholder="请输入预支付交易会话标识">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="PayBill.search();"><i class="fa fa-search"></i>
                						查询</button>
										<!-- Check all button -->
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>商品描述</th>
												<th>商品详情</th>
												<th>商户订单号</th>
												<th>标价金额</th>
												<th>交易起始时间</th>
												<th>交易结束时间</th>
												<th>订单优惠标记</th>
												<th>交易类型</th>
												<th>商品ID</th>
												<th>用户标识</th>
												<th>状态</th>
												<th>错误信息</th>
												<th>时间</th>
												<th>操作</th>
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
			PayBill.initPayBillList(0, Page.size);
		});
	</script>

</html>