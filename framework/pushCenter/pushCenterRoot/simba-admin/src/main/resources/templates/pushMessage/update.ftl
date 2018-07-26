<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/pushMessage/pushMessage.js"></script>
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
									<h3 class="box-title">修改消息记录</h3>
								</div>
								<form role="form" onsubmit="return PushMessage.checkForm();" id="form" action="${base}/pushMessage/update">
									<input type="hidden" id="id" name="id" value="${pushMessage.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="toUserId">接收方Id</label>
											<input type="text" class="form-control" id="toUserId" name="toUserId" value="${pushMessage.toUserId}" placeholder="请输入接收方Id">
										</div>
										<div class="form-group">
											<label for="fromUserId">发送方Id</label>
											<input type="text" class="form-control" id="fromUserId" name="fromUserId" value="${pushMessage.fromUserId}" placeholder="请输入发送方Id">
										</div>
										<div class="form-group">
											<label for="pushType">推送类型</label>
											<input type="text" class="form-control" id="pushType" name="pushType" value="${pushMessage.pushType}" placeholder="请输入推送类型">
										</div>
										<div class="form-group">
											<label for="content">内容</label>
											<input type="text" class="form-control" id="content" name="content" value="${pushMessage.content}" placeholder="请输入内容">
										</div>
										<div class="form-group">
											<label for="createTime">创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${pushMessage.createTime}" placeholder="请输入创建时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="PushMessage.toList();">取消</button>
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