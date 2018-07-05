<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/shortMessage/shortMessage.js"></script>
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
									<h3 class="box-title">新增短信</h3>
								</div>
								<form role="form" onsubmit="return ShortMessage.checkForm();" id="form" action="${base}/shortMessage/add">
									<div class="box-body">
										<div class="form-group">
											<label for="templateId">模板ID</label>
											<input type="text" class="form-control" id="templateId" name="templateId" placeholder="请输入模板ID">
										</div>
										<div class="form-group">
											<label for="value">插值</label>
											<input type="text" class="form-control" id="value" name="value" placeholder="请输入插值">
										</div>
										<div class="form-group">
											<label for="mobile">手机号</label>
											<input type="text" class="form-control" id="mobile" name="mobile" placeholder="请输入手机号">
										</div>
										<div class="form-group">
											<label for="sendDate">发送时间</label>
											<input type="text" class="form-control" id="sendDate" name="sendDate" placeholder="请输入发送时间">
										</div>
										<div class="form-group">
											<label for="projectId">来自项目</label>
											<input type="text" class="form-control" id="projectId" name="projectId" placeholder="请输入来自项目">
										</div>
										<div class="form-group">
											<label for="status">发送状态</label>
											<input type="text" class="form-control" id="status" name="status" placeholder="请输入发送状态">
										</div>
										<div class="form-group">
											<label for="platform">短信平台</label>
											<input type="text" class="form-control" id="platform" name="platform" placeholder="请输入短信平台">
										</div>
										<div class="form-group">
											<label for="messageId">SMS短信ID</label>
											<input type="text" class="form-control" id="messageId" name="messageId" placeholder="请输入SMS短信ID">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ShortMessage.toList();">取消</button>
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