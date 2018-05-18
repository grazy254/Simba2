<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tradeDetail/tradeDetail.js"></script>
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
									<h3 class="box-title">新增交易详情信息</h3>
								</div>
								<form role="form" onsubmit="return TradeDetail.checkForm();" id="form" action="${base}/tradeDetail/add">
									<div class="box-body">
										<div class="form-group">
											<label for="tradeNO">交易流水号</label>
											<input type="text" class="form-control" id="tradeNO" name="tradeNO" placeholder="请输入交易流水号">
										</div>
										<div class="form-group">
											<label for="tradeType">记录交易类型：充值/消费</label>
											<input type="text" class="form-control" id="tradeType" name="tradeType" placeholder="请输入记录交易类型：充值/消费">
										</div>
										<div class="form-group">
											<label for="tradeStatus">记录支付状态 SUCCESS/FAILED/FROZON</label>
											<input type="text" class="form-control" id="tradeStatus" name="tradeStatus" placeholder="请输入记录支付状态 SUCCESS/FAILED/FROZON">
										</div>
										<div class="form-group">
											<label for="orderNO">订单号</label>
											<input type="text" class="form-control" id="orderNO" name="orderNO" placeholder="请输入订单号">
										</div>
										<div class="form-group">
											<label for="orderName">订单名称</label>
											<input type="text" class="form-control" id="orderName" name="orderName" placeholder="请输入订单名称">
										</div>
										<div class="form-group">
											<label for="orderDesc">订单描述</label>
											<input type="text" class="form-control" id="orderDesc" name="orderDesc" placeholder="请输入订单描述">
										</div>
										<div class="form-group">
											<label for="orderAddress">订单地址</label>
											<input type="text" class="form-control" id="orderAddress" name="orderAddress" placeholder="请输入订单地址">
										</div>
										<div class="form-group">
											<label for="feeType">货币类型</label>
											<input type="text" class="form-control" id="feeType" name="feeType" placeholder="请输入货币类型">
										</div>
										<div class="form-group">
											<label for="originalAmount">原始费用</label>
											<input type="text" class="form-control" id="originalAmount" name="originalAmount" placeholder="请输入原始费用">
										</div>
										<div class="form-group">
											<label for="paymentAmount">实际费用</label>
											<input type="text" class="form-control" id="paymentAmount" name="paymentAmount" placeholder="请输入实际费用">
										</div>
										<div class="form-group">
											<label for="tradePartyID">主交易方</label>
											<input type="text" class="form-control" id="tradePartyID" name="tradePartyID" placeholder="请输入主交易方">
										</div>
										<div class="form-group">
											<label for="tradeCounterpartyID">对手交易方</label>
											<input type="text" class="form-control" id="tradeCounterpartyID" name="tradeCounterpartyID" placeholder="请输入对手交易方">
										</div>
										<div class="form-group">
											<label for="tradeChannelID">交易渠道</label>
											<input type="text" class="form-control" id="tradeChannelID" name="tradeChannelID" placeholder="请输入交易渠道">
										</div>
										<div class="form-group">
											<label for="tradeCreateTime">请求支付时间</label>
											<input type="text" class="form-control" id="tradeCreateTime" name="tradeCreateTime" placeholder="请输入请求支付时间">
										</div>
										<div class="form-group">
											<label for="tradePaymentTime">支付创建时间</label>
											<input type="text" class="form-control" id="tradePaymentTime" name="tradePaymentTime" placeholder="请输入支付创建时间">
										</div>
										<div class="form-group">
											<label for="createTime">创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入创建时间">
										</div>
										<div class="form-group">
											<label for="lastUpdateTime">最后更新时间</label>
											<input type="text" class="form-control" id="lastUpdateTime" name="lastUpdateTime" placeholder="请输入最后更新时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TradeDetail.toList();">取消</button>
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