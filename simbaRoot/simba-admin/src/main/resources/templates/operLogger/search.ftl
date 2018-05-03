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
		<script type="text/javascript" src="${base}/js/operLogger/operLogger.js"></script>
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
									<h3 class="box-title">操作日志搜索</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<label for="ip">Ip:</label>
										<input type="text" id="ip" name="ip" placeholder="请输入Ip">
										&nbsp;&nbsp;
										<label for="startTime">StartTime:</label>
										<input type="text" id="startTime" name="startTime" placeholder="请输入StartTime">
										&nbsp;&nbsp;
										<label for="endTime">EndTime:</label>
										<input type="text" id="endTime" name="endTime" placeholder="请输入EndTime">
										&nbsp;&nbsp;
										<label for="account">Account:</label>
										<input type="text" id="account" name="account" placeholder="请输入Account">
										&nbsp;&nbsp;
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="OperLogger.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
											<tr>
												<th>账号</th>
												<th>IP</th>
												<th>地址</th>
												<th>内容</th>
												<th>时间</th>
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
			OperLogger.initOperLoggerSearchList(0, Page.size);
		});
	</script>

</html>