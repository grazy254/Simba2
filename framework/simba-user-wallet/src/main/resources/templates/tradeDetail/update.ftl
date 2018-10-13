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
									<h3 class="box-title">修改交易详情信息</h3>
								</div>
								<form role="form" onsubmit="return TradeDetail.checkForm();" id="form" action="${base}/tradeDetail/update">
									<input type="hidden" id="id" name="id" value="${tradeDetail.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="tradeNO">交易流水号</label>
											<input type="text" class="form-control" id="tradeNO" name="tradeNO" value="${tradeDetail.tradeNO}" placeholder="请输入交易流水号">
										</div>
										<div class="form-group">
											<label for="tradeType">记录交易类型：充值/消费</label>
											<input type="text" class="form-control" id="tradeType" name="tradeType" value="${tradeDetail.tradeType}" placeholder="请输入记录交易类型：充值/消费">
										</div>
										<div class="form-group">
											<label for="tradeStatus">记录支付状态 SUCCESS/FAILED/FROZON</label>
											<input type="text" class="form-control" id="tradeStatus" name="tradeStatus" value="${tradeDetail.tradeStatus}" placeholder="请输入记录支付状态 SUCCESS/FAILED/FROZON">
										</div>
										<div class="form-group">
											<label for="useVirtualBalance">useVirtualBalance</label>
											<input type="text" class="form-control" id="useVirtualBalance" name="useVirtualBalance" value="${tradeDetail.useVirtualBalance}" placeholder="请输入useVirtualBalance">
										</div>
										<div class="form-group">
											<label for="orderNO">订单号</label>
											<input type="text" class="form-control" id="orderNO" name="orderNO" value="${tradeDetail.orderNO}" placeholder="请输入订单号">
										</div>
										<div class="form-group">
											<label for="orderName">订单名称</label>
											<input type="text" class="form-control" id="orderName" name="orderName" value="${tradeDetail.orderName}" placeholder="请输入订单名称">
										</div>
										<div class="form-group">
											<label for="orderDesc">订单描述</label>
											<input type="text" class="form-control" id="orderDesc" name="orderDesc" value="${tradeDetail.orderDesc}" placeholder="请输入订单描述">
										</div>
										<div class="form-group">
											<label for="orderAddress">订单地址</label>
											<input type="text" class="form-control" id="orderAddress" name="orderAddress" value="${tradeDetail.orderAddress}" placeholder="请输入订单地址">
										</div>
										<div class="form-group">
											<label for="feeType">货币类型</label>
											<input type="text" class="form-control" id="feeType" name="feeType" value="${tradeDetail.feeType}" placeholder="请输入货币类型">
										</div>
										<div class="form-group">
											<label for="originalAmount">原始费用</label>
											<input type="text" class="form-control" id="originalAmount" name="originalAmount" value="${tradeDetail.originalAmount}" placeholder="请输入原始费用">
										</div>
										<div class="form-group">
											<label for="paymentAmount">实际费用</label>
											<input type="text" class="form-control" id="paymentAmount" name="paymentAmount" value="${tradeDetail.paymentAmount}" placeholder="请输入实际费用">
										</div>
										<div class="form-group">
											<label for="partyTradeUserID">主交易方TradeUserID</label>
											<input type="text" class="form-control" id="partyTradeUserID" name="partyTradeUserID" value="${tradeDetail.partyTradeUserID}" placeholder="请输入主交易方TradeUserID">
										</div>
										<div class="form-group">
											<label for="counterpartyTradeUserID">对手主交易方TradeUserID</label>
											<input type="text" class="form-control" id="counterpartyTradeUserID" name="counterpartyTradeUserID" value="${tradeDetail.counterpartyTradeUserID}" placeholder="请输入对手主交易方TradeUserID">
										</div>
										<div class="form-group">
											<label for="channelTradeUserID">渠道方TradeUserID</label>
											<input type="text" class="form-control" id="channelTradeUserID" name="channelTradeUserID" value="${tradeDetail.channelTradeUserID}" placeholder="请输入渠道方TradeUserID">
										</div>
										<div class="form-group">
											<label for="tradePartyID">主交易方</label>
											<input type="text" class="form-control" id="tradePartyID" name="tradePartyID" value="${tradeDetail.tradePartyID}" placeholder="请输入主交易方">
										</div>
										<div class="form-group">
											<label for="tradeCounterpartyID">对手交易方</label>
											<input type="text" class="form-control" id="tradeCounterpartyID" name="tradeCounterpartyID" value="${tradeDetail.tradeCounterpartyID}" placeholder="请输入对手交易方">
										</div>
										<div class="form-group">
											<label for="tradeChannelID">交易渠道</label>
											<input type="text" class="form-control" id="tradeChannelID" name="tradeChannelID" value="${tradeDetail.tradeChannelID}" placeholder="请输入交易渠道">
										</div>
										<div class="form-group">
											<label for="tradeCreateTime">请求支付时间</label>
											<input type="text" class="form-control" id="tradeCreateTime" name="tradeCreateTime" value="${tradeDetail.tradeCreateTime}" placeholder="请输入请求支付时间">
										</div>
										<div class="form-group">
											<label for="tradePaymentTime">支付创建时间</label>
											<input type="text" class="form-control" id="tradePaymentTime" name="tradePaymentTime" value="${tradeDetail.tradePaymentTime}" placeholder="请输入支付创建时间">
										</div>
										<div class="form-group">
											<label for="tradePaymentDate">支付创建时间</label>
											<input type="text" class="form-control" id="tradePaymentDate" name="tradePaymentDate" value="${tradeDetail.tradePaymentDate}" placeholder="请输入支付创建时间">
										</div>
										<div class="form-group">
											<label for="createTime">创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${tradeDetail.createTime}" placeholder="请输入创建时间">
										</div>
										<div class="form-group">
											<label for="lastUpdateTime">最后更新时间</label>
											<input type="text" class="form-control" id="lastUpdateTime" name="lastUpdateTime" value="${tradeDetail.lastUpdateTime}" placeholder="请输入最后更新时间">
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