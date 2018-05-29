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
		<script type="text/javascript" src="${base}/js/tradeDetail/tradeDetail.js"></script>
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
									<h3 class="box-title">交易详情信息管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="TradeDetail.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										<button type="button" class="btn btn-default btn-sm" onclick="TradeDetail.batchDelete();"><i class="fa fa-remove"></i>删除</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
									<div class="mailbox-controls">
										<label for="startTime">开始日期:</label>
										<input type="text" id="startTime" class="datetimepicker" name="startTime" placeholder="请输入开始日期">
										&nbsp;&nbsp;
										<label for="endTime">结束日期:</label>
										<input type="text" id="endTime" class="datetimepicker" name="endTime" placeholder="请输入结束日期">
										&nbsp;&nbsp;
										<label for="tradeNO">订单号:</label>
										<input type="text" id="tradeNO"  name="tradeNO" placeholder="请输入订单号">
										&nbsp;&nbsp;
										<label for="tradeType">交易类型:</label>
										<input type="text" id="tradeType"  name="tradeType" placeholder="请输入交易类型">
										&nbsp;&nbsp;
										<label for="tradeStatus">交易状态:</label>
										<input type="text" id="tradeStatus"  name="tradeStatus" placeholder="请输入交易状态">
										&nbsp;&nbsp;
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="TradeDetail.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">
										
									</div>
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>交易流水号</th>
												<th>记录交易类型：充值/消费</th>
												<th>记录支付状态 SUCCESS/FAILED/FROZON</th>
												<th>订单号</th>
												<th>订单名称</th>
												<th>订单描述</th>
												<th>订单地址</th>
												<th>货币类型</th>
												<th>原始费用</th>
												<th>实际费用</th>
												<th>主交易方</th>
												<th>对手交易方</th>
												<th>交易渠道</th>
												<th>请求支付时间</th>
												<th>支付创建时间</th>
												<th>创建时间</th>
												<th>最后更新时间</th>
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
			TradeDetail.initTradeDetailList(0, Page.size);
		});
	</script>

</html>