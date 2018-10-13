<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/notifyUser/notifyUser.js"></script>
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
									<h3 class="box-title">修改通知表和用户表的关联</h3>
								</div>
								<form role="form" onsubmit="return NotifyUser.checkForm();" id="form" action="${base}/notifyUser/update">
									<input type="hidden" id="id" name="id" value="${notifyUser.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="notifyId">通知Id</label>
											<input type="text" class="form-control" id="notifyId" name="notifyId" value="${notifyUser.notifyId}" placeholder="请输入通知Id">
										</div>
										<div class="form-group">
											<label for="smartUserId">用户Id</label>
											<input type="text" class="form-control" id="smartUserId" name="smartUserId" value="${notifyUser.smartUserId}" placeholder="请输入用户Id">
										</div>
										<div class="form-group">
											<label for="status">0: 未读 1:已读</label>
											<input type="text" class="form-control" id="status" name="status" value="${notifyUser.status}" placeholder="请输入0: 未读 1:已读">
										</div>
										<div class="form-group">
											<label for="readTime">阅读时间</label>
											<input type="text" class="form-control" id="readTime" name="readTime" value="${notifyUser.readTime}" placeholder="请输入阅读时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="NotifyUser.toList();">取消</button>
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