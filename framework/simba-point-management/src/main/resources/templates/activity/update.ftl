<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
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
									<h3 class="box-title">修改活动</h3>
								</div>
								<form role="form" onsubmit="return Activity.checkForm();" id="form" action="${base}/activity/update">
									<input type="hidden" id="id" name="id" value="${activity.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="activityID">活动id</label>
											<input type="text" class="form-control" id="activityID" name="activityID" value="${activity.activityID}" placeholder="请输入活动id">
										</div>
										<div class="form-group">
											<label for="name">活动名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${activity.name}" placeholder="请输入活动名称">
										</div>
										<div class="form-group">
											<label for="description">活动描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${activity.description}" placeholder="请输入活动描述">
										</div>
										<div class="form-group">
											<label for="ownerID">活动发起人id</label>
											<input type="text" class="form-control" id="ownerID" name="ownerID" value="${activity.ownerID}" placeholder="请输入活动发起人id">
										</div>
										<div class="form-group">
											<label for="point">积分</label>
											<input type="text" class="form-control" id="point" name="point" value="${activity.point}" placeholder="请输入积分">
										</div>
										<div class="form-group">
											<label for="startTime">开始时间</label>
											<input type="text" class="form-control" id="startTime" name="startTime" value="${activity.startTime}" placeholder="请输入开始时间">
										</div>
										<div class="form-group">
											<label for="endTime">结束时间</label>
											<input type="text" class="form-control" id="endTime" name="endTime" value="${activity.endTime}" placeholder="请输入结束时间">
										</div>
										<div class="form-group">
											<label for="createTime">活动创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${activity.createTime}" placeholder="请输入活动创建时间">
										</div>
										<div class="form-group">
											<label for="updateTime">updateTime</label>
											<input type="text" class="form-control" id="updateTime" name="updateTime" value="${activity.updateTime}" placeholder="请输入updateTime">
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