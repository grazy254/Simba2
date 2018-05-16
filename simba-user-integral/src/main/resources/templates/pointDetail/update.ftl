<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/pointDetail/pointDetail.js"></script>
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
									<h3 class="box-title">修改null</h3>
								</div>
								<form role="form" onsubmit="return PointDetail.checkForm();" id="form" action="${base}/pointDetail/update">
									<input type="hidden" id="id" name="id" value="${pointDetail.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="userID">userID</label>
											<input type="text" class="form-control" id="userID" name="userID" value="${pointDetail.userID}" placeholder="请输入userID">
										</div>
										<div class="form-group">
											<label for="activityID">活动id</label>
											<input type="text" class="form-control" id="activityID" name="activityID" value="${pointDetail.activityID}" placeholder="请输入活动id">
										</div>
										<div class="form-group">
											<label for="point">积分</label>
											<input type="text" class="form-control" id="point" name="point" value="${pointDetail.point}" placeholder="请输入积分">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${pointDetail.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="expireTime">expireTime</label>
											<input type="text" class="form-control" id="expireTime" name="expireTime" value="${pointDetail.expireTime}" placeholder="请输入expireTime">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="PointDetail.toList();">取消</button>
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