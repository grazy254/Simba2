<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/aliPayBill/aliPayBill.js"></script>
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
									<h3 class="box-title">阿里支付账单管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
									<div class="mailbox-controls">
										<label for="productCode">产品码:</label>
										<input type="text" id="productCode"  name="productCode" placeholder="请输入产品码">
										&nbsp;&nbsp;
										<label for="ourTradeNo">商户订单号:</label>
										<input type="text" id="ourTradeNo"  name="ourTradeNo" placeholder="请输入商户订单号">
										&nbsp;&nbsp;
										<label for="tradeNo">支付宝交易流水号:</label>
										<input type="text" id="tradeNo"  name="tradeNo" placeholder="请输入支付宝交易流水号">
										&nbsp;&nbsp;
										<label for="status">状态:</label>
										<select id="status"  name="status" >
												<option value="">所有</option>	
											<#list statuses as status>
												<option value="${status.getName()}">${status.description}</option>	
											</#list>
										</select>
										&nbsp;&nbsp;
										<label for="startCreateTime">开始时间:</label>
										<input type="text" id="startCreateTime"  name="startCreateTime"  class="datetimepicker"  placeholder="请输入开始时间">
										&nbsp;&nbsp;
										<label for="endCreateTime">结束时间:</label>
										<input type="text" id="endCreateTime"  name="endCreateTime"  class="datetimepicker" placeholder="请输入结束时间">
										&nbsp;&nbsp;
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="AliPayBill.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">
										
									</div>
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<!-- 
												<th>应用ID</th>
												-->
												<th>买家支付宝账号</th>
												<th>买家付款时间</th>
												<th>退款时间</th>
												<th>用户在交易中支付的金额</th>
												<th>描述</th>
												<th>订单总金额(单位:分)</th>
												<th>标题</th>
												<th>状态</th>
												<th>商户订单号</th>
												<th>支付宝交易流水号</th>
												<th>产品码</th>
												<!--
												<th>商品主类型</th>
												<th>商户门店编号</th>
												-->
												<th>收款支付宝账号ID</th>
												<th>最晚付款时间</th>
												<th>订单时间</th>
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
			AliPayBill.initAliPayBillList(0, Page.size);
		});
	</script>

</html>