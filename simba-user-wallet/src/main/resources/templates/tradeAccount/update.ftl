<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tradeAccount/tradeAccount.js"></script>
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
									<h3 class="box-title">修改支付账号</h3>
								</div>
								<form role="form" onsubmit="return TradeAccount.checkForm();" id="form" action="${base}/tradeAccount/update">
									<input type="hidden" id="id" name="id" value="${tradeAccount.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="tradeUserID">支付用户ID</label>
											<input type="text" class="form-control" id="tradeUserID" name="tradeUserID" value="${tradeAccount.tradeUserID}" placeholder="请输入支付用户ID">
										</div>
										<div class="form-group">
											<label for="accountID">账号ID</label>
											<input type="text" class="form-control" id="accountID" name="accountID" value="${tradeAccount.accountID}" placeholder="请输入账号ID">
										</div>
										<div class="form-group">
											<label for="accountType">账户类型：部门资产账户/个人账户/渠道账号</label>
											<input type="text" class="form-control" id="accountType" name="accountType" value="${tradeAccount.accountType}" placeholder="请输入账户类型：部门资产账户/个人账户/渠道账号">
										</div>
										<div class="form-group">
											<label for="feeType">feeType</label>
											<input type="text" class="form-control" id="feeType" name="feeType" value="${tradeAccount.feeType}" placeholder="请输入feeType">
										</div>
										<div class="form-group">
											<label for="isAllowRecharge">isAllowRecharge</label>
											<input type="text" class="form-control" id="isAllowRecharge" name="isAllowRecharge" value="${tradeAccount.isAllowRecharge}" placeholder="请输入isAllowRecharge">
										</div>
										<div class="form-group">
											<label for="isAllowPay">isAllowPay</label>
											<input type="text" class="form-control" id="isAllowPay" name="isAllowPay" value="${tradeAccount.isAllowPay}" placeholder="请输入isAllowPay">
										</div>
										<div class="form-group">
											<label for="isActive">isActive</label>
											<input type="text" class="form-control" id="isActive" name="isActive" value="${tradeAccount.isActive}" placeholder="请输入isActive">
										</div>
										<div class="form-group">
											<label for="isFrozen">isFrozen</label>
											<input type="text" class="form-control" id="isFrozen" name="isFrozen" value="${tradeAccount.isFrozen}" placeholder="请输入isFrozen">
										</div>
										<div class="form-group">
											<label for="accountBalance">accountBalance</label>
											<input type="text" class="form-control" id="accountBalance" name="accountBalance" value="${tradeAccount.accountBalance}" placeholder="请输入accountBalance">
										</div>
										<div class="form-group">
											<label for="availableBalance">availableBalance</label>
											<input type="text" class="form-control" id="availableBalance" name="availableBalance" value="${tradeAccount.availableBalance}" placeholder="请输入availableBalance">
										</div>
										<div class="form-group">
											<label for="frozenBalance">frozenBalance</label>
											<input type="text" class="form-control" id="frozenBalance" name="frozenBalance" value="${tradeAccount.frozenBalance}" placeholder="请输入frozenBalance">
										</div>
										<div class="form-group">
											<label for="createTime">货币类型：人民币为CNY</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${tradeAccount.createTime}" placeholder="请输入货币类型：人民币为CNY">
										</div>
										<div class="form-group">
											<label for="lastUpdateTime">是否允许充值：0不允许，1允许</label>
											<input type="text" class="form-control" id="lastUpdateTime" name="lastUpdateTime" value="${tradeAccount.lastUpdateTime}" placeholder="请输入是否允许充值：0不允许，1允许">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TradeAccount.toList();">取消</button>
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