<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
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
									<h3 class="box-title">已选粉丝列表</h3>
									<br />
									<input type="hidden" id="openids" name="openids" value="" />
									<div id="selectedFansList"></div>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="openid">微信用户ID:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入微信用户ID">
										<label for="remark">备注:</label>
										<input type="text" id="remark" name="remark" placeholder="请输入备注">
										<label for="nickname">昵称:</label>
										<input type="text" id="nickname" name="nickname" placeholder="请输入昵称">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.searchSelectFanses();"><i class="fa fa-search"></i>
                查询</button>
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectedFansesBack();"><i class="fa fa-check"></i>
                确定</button>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>操作</th>
												<th>微信用户ID</th>
												<th>备注</th>
												<th>昵称</th>
												<th>性别</th>
												<th>城市</th>
												<th>省份</th>
												<th>国家</th>
												<th>头像</th>
												<th>标签名</th>
												<th>关注时间</th>
												<th>黑名单</th>
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
			Fans.initSelectFansesList(0, Page.size);
			Fans.initSelectedFanses();
		});
	</script>

</html>