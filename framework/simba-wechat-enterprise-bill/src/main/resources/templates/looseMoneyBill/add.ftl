<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/looseMoneyBill/looseMoneyBill.js"></script>
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
									<h3 class="box-title">微信转账到用户零钱</h3>
								</div>
									<div class="box-body">
										<div class="form-group" class="form-group">
											<label for="check_name">强制检查实名</label>
											<select id="check_name" name="check_name">
												<option value="FORCE_CHECK">强校验真实姓名</option>
												<option value="NO_CHECK">不校验真实姓名</option>
											</select>
										</div>
										<div class="form-group">
											<label for="openid">用户openid</label>
											<input type="text" class="form-control" id="openid" name="openid" placeholder="请输入用户openid">
										</div>
										<div class="form-group">
											<label for="re_user_name">收款用户姓名</label>
											<input type="text" class="form-control" id="re_user_name" name="re_user_name" placeholder="请输入收款用户姓名">
										</div>
										<div class="form-group">
											<label for="amount">金额(分)</label>
											<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入金额">
										</div>
										<div class="form-group">
											<label for="desc">企业付款描述信息</label>
											<input type="text" class="form-control" id="desc" name="desc" placeholder="请输入企业付款描述信息">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="button" class="btn btn-success" onclick="LooseMoneyBill.add();">提交</button>
										<button type="button" class="btn" onclick="LooseMoneyBill.toList();">取消</button>
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