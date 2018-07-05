<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/exceptionInfo/exceptionInfo.js"></script>
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
									<h3 class="box-title">新增异常信息</h3>
								</div>
								<form role="form" onsubmit="return ExceptionInfo.checkForm();" id="form" action="${base}/exceptionInfo/add">
									<div class="box-body">
										<div class="form-group">
											<label for="ip">IP</label>
											<input type="text" class="form-control" id="ip" name="ip" placeholder="请输入IP">
										</div>
										<div class="form-group">
											<label for="ipInfo">地址</label>
											<input type="text" class="form-control" id="ipInfo" name="ipInfo" placeholder="请输入地址">
										</div>
										<div class="form-group">
											<label for="exceptionInfo">内容</label>
											<input type="text" class="form-control" id="exceptionInfo" name="exceptionInfo" placeholder="请输入内容">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ExceptionInfo.toList();">取消</button>
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