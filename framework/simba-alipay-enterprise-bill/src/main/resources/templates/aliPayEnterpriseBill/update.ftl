<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/aliPayEnterpriseBill/aliPayEnterpriseBill.js"></script>
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
									<h3 class="box-title">修改支付宝企业支付账单</h3>
								</div>
								<form role="form" onsubmit="return AliPayEnterpriseBill.checkForm();" id="form" action="${base}/aliPayEnterpriseBill/update">
									<input type="hidden" id="id" name="id" value="${aliPayEnterpriseBill.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="outBizNo">商户订单号</label>
											<input type="text" class="form-control" id="outBizNo" name="outBizNo" value="${aliPayEnterpriseBill.outBizNo}" placeholder="请输入商户订单号">
										</div>
										<div class="form-group">
											<label for="payType">账户类型</label>
											<input type="text" class="form-control" id="payType" name="payType" value="${aliPayEnterpriseBill.payType}" placeholder="请输入账户类型">
										</div>
										<div class="form-group">
											<label for="account">收款方账户</label>
											<input type="text" class="form-control" id="account" name="account" value="${aliPayEnterpriseBill.account}" placeholder="请输入收款方账户">
										</div>
										<div class="form-group">
											<label for="amount">转账金额</label>
											<input type="text" class="form-control" id="amount" name="amount" value="${aliPayEnterpriseBill.amount}" placeholder="请输入转账金额">
										</div>
										<div class="form-group">
											<label for="payerName">付款方姓名</label>
											<input type="text" class="form-control" id="payerName" name="payerName" value="${aliPayEnterpriseBill.payerName}" placeholder="请输入付款方姓名">
										</div>
										<div class="form-group">
											<label for="peyeeName">收款方真实姓名</label>
											<input type="text" class="form-control" id="peyeeName" name="peyeeName" value="${aliPayEnterpriseBill.peyeeName}" placeholder="请输入收款方真实姓名">
										</div>
										<div class="form-group">
											<label for="remark">备注</label>
											<input type="text" class="form-control" id="remark" name="remark" value="${aliPayEnterpriseBill.remark}" placeholder="请输入备注">
										</div>
										<div class="form-group">
											<label for="orderId">支付宝转账单据号</label>
											<input type="text" class="form-control" id="orderId" name="orderId" value="${aliPayEnterpriseBill.orderId}" placeholder="请输入支付宝转账单据号">
										</div>
										<div class="form-group">
											<label for="payDate">支付时间</label>
											<input type="text" class="form-control" id="payDate" name="payDate" value="${aliPayEnterpriseBill.payDate}" placeholder="请输入支付时间">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${aliPayEnterpriseBill.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="createUser">创建者</label>
											<input type="text" class="form-control" id="createUser" name="createUser" value="${aliPayEnterpriseBill.createUser}" placeholder="请输入创建者">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" value="${aliPayEnterpriseBill.status}" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="reason">理由</label>
											<input type="text" class="form-control" id="reason" name="reason" value="${aliPayEnterpriseBill.reason}" placeholder="请输入理由">
										</div>
										<div class="form-group">
											<label for="orderFee">预计收费金额</label>
											<input type="text" class="form-control" id="orderFee" name="orderFee" value="${aliPayEnterpriseBill.orderFee}" placeholder="请输入预计收费金额">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="AliPayEnterpriseBill.toList();">取消</button>
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