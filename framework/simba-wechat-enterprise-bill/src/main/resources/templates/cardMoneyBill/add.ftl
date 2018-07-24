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
									<h3 class="box-title">微信转账到银行卡</h3>
								</div>
									<div class="box-body">
										<div class="form-group">
											<label for="enc_bank_no">收款方银行卡号</label>
											<input type="text" class="form-control" id="enc_bank_no" name="enc_bank_no" placeholder="请输入收款方银行卡号">
										</div>
										<div class="form-group">
											<label for="trueName">收款方用户名</label>
											<input type="text" class="form-control" id="trueName" name="trueName" placeholder="请输入收款方用户名">
										</div>
										<div class="form-group">
											<label for="bank_code">收款方开户行</label>
											<select id="bank_code" name="bank_code">
												<#list banks as bank>
													<option value="${bank.code}">${bank.getName()}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="amount">付款金额</label>
											<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入付款金额">
										</div>
										<div class="form-group">
											<label for="desc">付款说明</label>
											<input type="text" class="form-control" id="desc" name="desc" placeholder="请输入付款说明">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="button" class="btn btn-success" onclick="CardMoneyBill.add();">提交</button>
										<button type="button" class="btn" onclick="CardMoneyBill.toList();">取消</button>
									</div>

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