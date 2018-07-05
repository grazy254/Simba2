<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<script type="text/javascript" src="${base}/js/activity/activity.js"></script>
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
									<h3 class="box-title">新增活动</h3>
								</div>
								<form role="form" onsubmit="return Activity.checkForm();" id="form" action="${base}/activity/add">
									<div class="box-body">
										<div class="form-group">
											<label for="activityID">活动编号</label>
											<input type="text" class="form-control" id="activityID" name="activityID" placeholder="请输入活动编号（不能重复）">
										</div>
										
										<div class="form-group">
											<label for="name">活动名称</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入活动名称">
										</div>
										<div class="form-group">
											<label for="description">活动描述</label>
											<input type="text" class="form-control" id="description" name="description" placeholder="请输入活动描述">
										</div>
										<div class="form-group">
											<label for="point">积分</label>
											<input type="text" class="form-control" id="point" name="point" placeholder="请输入积分">
										</div>
										<div class="form-group">
											<label for="start">开始时间</label>
											<input type="text" class="datetimepicker" id="start" name="start" placeholder="请输入开始时间">
											----<label for="end">结束时间</label>
											<input type="text" class="datetimepicker" id="end" name="end" placeholder="请输入结束时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Activity.toList();">取消</button>
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