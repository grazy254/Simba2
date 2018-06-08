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
									<h3 class="box-title">交易详情信息查询</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<!-- /.pull-right -->
									<div class="mailbox-controls">
										<input type="text" id="startTime" class="datetimepicker" name="startTime" placeholder="请输入开始日期">
										&nbsp;&nbsp;
										<input type="text" id="endTime" class="datetimepicker" name="endTime" placeholder="请输入结束日期">
										&nbsp;&nbsp;
										<input type="text" id="tradeNO"  name="tradeNO" placeholder="请输入订单号">
										&nbsp;&nbsp;
										<input type="text" id="userID"  name="userID" placeholder="请输入用户ID">
										&nbsp;&nbsp;
										<label for="tradeUserType">选择用户类型</label>
										<select name="tradeUserType" id="tradeUserType">
											<option value ="">请选择</option>
										<#if tradeUserTypeList??>
											<#list tradeUserTypeList as tradeUserType>
												<option value ="${tradeUserType.getName()}">${tradeUserType.getValue()}</option>
											</#list>
										</#if>
										</select>
										&nbsp;&nbsp;
										<label for="tradeType">选择交易类型</label>
										<select name="tradeType" id="tradeType">
											<option value ="">请选择</option>
											<#if tradeTypeList??>
												<#list tradeTypeList as tradeType>
													<option value ="${tradeType.getName()}">${tradeType.getValue()}</option>
												</#list>
											</#if>
										</select>
										&nbsp;&nbsp;
										<label for="tradeType">选择交易状态</label>
										<select name="tradeStatus" id="tradeStatus">
											<option value ="">请选择</option>
											<#if tradeStatusList??>
												<#list tradeStatusList as tradeStatus>
													<option value ="${tradeStatus.getName()}">${tradeStatus.getValue()}</option>
												</#list>
											</#if>
										</select>										&nbsp;&nbsp;
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="TradeDetail.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">
										
									</div>
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>交易流水号</th>
												<th>交易类型</th>
												<th>交易状态 </th>
												<th>订单号</th>
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