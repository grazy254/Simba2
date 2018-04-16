<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/receiveMsg/receiveMsg.js"></script>
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
									<h3 class="box-title">修改接收消息</h3>
								</div>
								<form role="form" onsubmit="return ReceiveMsg.checkForm();" id="form" action="${base}/receiveMsg/update">
									<input type="hidden" id="id" name="id" value="${receiveMsg.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="type">类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${receiveMsg.type}" placeholder="请输入类型">
										</div>
										<div class="form-group">
											<label for="source">源</label>
											<input type="text" class="form-control" id="source" name="source" value="${receiveMsg.source}" placeholder="请输入源">
										</div>
										<div class="form-group">
											<label for="message">内容</label>
											<input type="text" class="form-control" id="message" name="message" value="${receiveMsg.message}" placeholder="请输入内容">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${receiveMsg.createTime}" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ReceiveMsg.toList();">取消</button>
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