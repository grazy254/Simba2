<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/pointSummary/pointSummary.js"></script>
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
								<form role="form" onsubmit="return PointSummary.checkForm();" id="form" action="${base}/pointSummary/update">
									<input type="hidden" id="id" name="id" value="${pointSummary.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="userID">用户id</label>
											<input type="text" class="form-control" id="userID" name="userID" value="${pointSummary.userID}" placeholder="请输入用户id">
										</div>
										<div class="form-group">
											<label for="point">用户积分</label>
											<input type="text" class="form-control" id="point" name="point" value="${pointSummary.point}" placeholder="请输入用户积分">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${pointSummary.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="updateTime">updateTime</label>
											<input type="text" class="form-control" id="updateTime" name="updateTime" value="${pointSummary.updateTime}" placeholder="请输入updateTime">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="PointSummary.toList();">取消</button>
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