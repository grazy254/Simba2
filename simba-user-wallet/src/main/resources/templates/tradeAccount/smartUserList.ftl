<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/tradeAccount/tradeAccount.js"></script>
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
									<h3 class="box-title">个人账单</h3>
								</div>
								<!-- /.box-header -->
								<div class="mailbox-controls">
									<label for="userID">用户账号:</label>
									<input type="text" id="userID"  name="userID" placeholder="请输入用户账号">
						
									<!-- Check all button -->
									<button type="button" class="btn btn-default btn-sm" onclick="TradeAccount.toSearch();"><i class="fa fa-search"></i>查询</button>
									<div class="pull-right">
									
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>用户账号</th>
												<th>账号ID</th>
												<th>账户状态</th>
												<th>账户余额</th>
												<th>可用余额</th>
												<th>冻结余额</th>
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
			TradeAccount.initTradeAccountList(0, Page.size, "getSmartUserList");
		});
	</script>

</html>