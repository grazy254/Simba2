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
									<h3 class="box-title">转账用户支付宝</h3>
								</div>
								<form role="form" onsubmit="return AliPayEnterpriseBill.checkForm();" id="form" action="${base}/aliPayEnterpriseBill/add">
									<div class="box-body">
										<div class="form-group">
											<label for="payType">账户类型</label>
											<select id="payType" name="payType" class="form-control">
												<option value="ALIPAY_LOGONID">支付宝登录号</option>
												<option value="ALIPAY_USERID">支付宝唯一用户号</option>
											</select>
										</div>
										<div class="form-group">
											<label for="account">收款方账户</label>
											<input type="text" class="form-control" id="account" name="account" placeholder="请输入收款方账户">
										</div>
										<div class="form-group">
											<label for="amount">转账金额(单位分)</label>
											<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入转账金额">
										</div>
										<div class="form-group">
											<label for="payerName">付款方姓名</label>
											<input type="text" class="form-control" id="payerName" name="payerName" placeholder="请输入付款方姓名">
										</div>
										<div class="form-group">
											<label for="peyeeName">收款方真实姓名</label>
											<input type="text" class="form-control" id="peyeeName" name="peyeeName" placeholder="请输入收款方真实姓名">
										</div>
										<div class="form-group">
											<label for="remark">备注</label>
											<input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注">
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
		$(document).ready(function() {});
	</script>

</html>