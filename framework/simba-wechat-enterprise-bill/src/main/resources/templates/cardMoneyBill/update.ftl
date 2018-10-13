<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/cardMoneyBill/cardMoneyBill.js"></script>
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
									<h3 class="box-title">修改银行卡账单</h3>
								</div>
								<form role="form" onsubmit="return CardMoneyBill.checkForm();" id="form" action="${base}/cardMoneyBill/update">
									<input type="hidden" id="id" name="id" value="${cardMoneyBill.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="mchId">商户号</label>
											<input type="text" class="form-control" id="mchId" name="mchId" value="${cardMoneyBill.mchId}" placeholder="请输入商户号">
										</div>
										<div class="form-group">
											<label for="partnerTradeNo">商户企业付款单号</label>
											<input type="text" class="form-control" id="partnerTradeNo" name="partnerTradeNo" value="${cardMoneyBill.partnerTradeNo}" placeholder="请输入商户企业付款单号">
										</div>
										<div class="form-group">
											<label for="bankNo">收款方银行卡号</label>
											<input type="text" class="form-control" id="bankNo" name="bankNo" value="${cardMoneyBill.bankNo}" placeholder="请输入收款方银行卡号">
										</div>
										<div class="form-group">
											<label for="trueName">收款方用户名</label>
											<input type="text" class="form-control" id="trueName" name="trueName" value="${cardMoneyBill.trueName}" placeholder="请输入收款方用户名">
										</div>
										<div class="form-group">
											<label for="bankCode">收款方开户行</label>
											<input type="text" class="form-control" id="bankCode" name="bankCode" value="${cardMoneyBill.bankCode}" placeholder="请输入收款方开户行">
										</div>
										<div class="form-group">
											<label for="amount">付款金额</label>
											<input type="text" class="form-control" id="amount" name="amount" value="${cardMoneyBill.amount}" placeholder="请输入付款金额">
										</div>
										<div class="form-group">
											<label for="description">付款说明</label>
											<input type="text" class="form-control" id="description" name="description" value="${cardMoneyBill.description}" placeholder="请输入付款说明">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" value="${cardMoneyBill.status}" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="errMsg">错误信息</label>
											<input type="text" class="form-control" id="errMsg" name="errMsg" value="${cardMoneyBill.errMsg}" placeholder="请输入错误信息">
										</div>
										<div class="form-group">
											<label for="paymentNo">微信企业付款单号</label>
											<input type="text" class="form-control" id="paymentNo" name="paymentNo" value="${cardMoneyBill.paymentNo}" placeholder="请输入微信企业付款单号">
										</div>
										<div class="form-group">
											<label for="cmmsAmt">手续费金额</label>
											<input type="text" class="form-control" id="cmmsAmt" name="cmmsAmt" value="${cardMoneyBill.cmmsAmt}" placeholder="请输入手续费金额">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${cardMoneyBill.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="createUser">付款者</label>
											<input type="text" class="form-control" id="createUser" name="createUser" value="${cardMoneyBill.createUser}" placeholder="请输入付款者">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="CardMoneyBill.toList();">取消</button>
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