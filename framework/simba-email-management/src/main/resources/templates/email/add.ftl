<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/email/email.js"></script>
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
									<h3 class="box-title">新增邮件记录</h3>
								</div>
								<form role="form" onsubmit="return Email.checkForm();" id="form" action="${base}/email/add">
									<div class="box-body">
										<div class="form-group">
											<label for="appid">应用ID</label>
											<input type="text" class="form-control" id="appid" name="appid" placeholder="请输入应用ID">
										</div>
										<div class="form-group">
											<label for="toEmail">接收方邮箱</label>
											<input type="text" class="form-control" id="toEmail" name="toEmail" placeholder="请输入接收方邮箱">
										</div>
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="content">内容</label>
											<input type="text" class="form-control" id="content" name="content" placeholder="请输入内容">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<input type="text" class="form-control" id="type" name="type" placeholder="请输入类型">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Email.toList();">取消</button>
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