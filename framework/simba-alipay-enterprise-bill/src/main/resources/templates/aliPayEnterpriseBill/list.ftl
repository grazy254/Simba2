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
		<script type="text/javascript" src="${base}/js/aliPayEnterpriseBill/aliPayEnterpriseBill.js"></script>
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
									<h3 class="box-title">支付宝企业支付账单管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="AliPayEnterpriseBill.toAdd();"><i class="fa fa-plus"></i>
                转账用户支付宝</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
									<div class="mailbox-controls">
										<label for="status">状态:</label>
										<select id="status" name="status">
											<option value="">所有</option>
											<option value="SUCCESS">成功</option>
											<option value="INIT">等待处理</option>
											<option value="DEALING">处理中</option>
											<option value="REFUND">退票</option>
											<option value="UNKNOWN">状态未知</option>
										</select>
										&nbsp;&nbsp;
										<label for="outBizNo">商户订单号:</label>
										<input type="text" id="outBizNo"  name="outBizNo" placeholder="请输入商户订单号">
										&nbsp;&nbsp;
										<label for="payType">账户类型:</label>
										<select id="payType" name="payType">
											<option value="">所有</option>
											<option value="ALIPAY_LOGONID">支付宝登录号</option>
											<option value="ALIPAY_USERID">支付宝唯一用户号</option>
										</select>
										&nbsp;&nbsp;
										<label for="account">收款方账户:</label>
										<input type="text" id="account"  name="account" placeholder="请输入收款方账户">
										&nbsp;&nbsp;
										<label for="peyeeName">收款方真实姓名:</label>
										<input type="text" id="peyeeName"  name="peyeeName" placeholder="请输入收款方真实姓名">
										&nbsp;&nbsp;
										<label for="orderId">支付宝转账单据号:</label>
										<input type="text" id="orderId"  name="orderId" placeholder="请输入支付宝转账单据号">
										&nbsp;&nbsp;
										<label for="createUser">创建者:</label>
										<input type="text" id="createUser"  name="createUser" placeholder="请输入创建者">
										&nbsp;&nbsp;
										<label for="startCreateTime">开始时间:</label>
										<input type="text" id="startCreateTime"  name="startCreateTime" placeholder="请输入开始时间" class="datetimepicker">
										&nbsp;&nbsp;
										<label for="endCreateTime">结束时间:</label>
										<input type="text" id="endCreateTime"  name="endCreateTime" placeholder="请输入结束时间" class="datetimepicker">
										&nbsp;&nbsp;
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="AliPayEnterpriseBill.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">
										
									</div>
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>商户订单号</th>
												<th>账户类型</th>
												<th>收款方账户</th>
												<th>转账金额(分)</th>
												<th>付款方姓名</th>
												<th>收款方真实姓名</th>
												<th>备注</th>
												<th>支付宝转账单据号</th>
												<th>支付时间</th>
												<th>时间</th>
												<th>创建者</th>
												<th>状态</th>
												<th>理由</th>
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
			AliPayEnterpriseBill.initAliPayEnterpriseBillList(0, Page.size);
		});
	</script>

</html>