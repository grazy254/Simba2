<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/opinionFeedback/opinionFeedback.js"></script>
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
									<h3 class="box-title">修改意见反馈管理</h3>
								</div>
								<form role="form" onsubmit="return OpinionFeedback.checkForm();" id="form" action="${base}/opinionFeedback/update">
									<input type="hidden" id="id" name="id" value="${opinionFeedback.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="userId">反馈意见的用户id</label>
											<input type="text" class="form-control" id="userId" name="userId" value="${opinionFeedback.userId}" placeholder="请输入反馈意见的用户id">
										</div>
										<div class="form-group">
											<label for="title">意见名称</label>
											<input type="text" class="form-control" id="title" name="title" value="${opinionFeedback.title}" placeholder="请输入意见名称">
										</div>
										<div class="form-group">
											<label for="text">意见内容</label>
											<input type="text" class="form-control" id="text" name="text" value="${opinionFeedback.text}" placeholder="请输入意见内容">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${opinionFeedback.createTime}" placeholder="请输入时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="OpinionFeedback.toList();">取消</button>
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