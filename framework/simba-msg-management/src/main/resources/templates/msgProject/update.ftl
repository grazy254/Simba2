<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/msgProject/project.js"></script>
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
									<h3 class="box-title">修改项目</h3>
								</div>
								<form role="form" onsubmit="return Project.checkForm();" id="form" action="${base}/msgProject/update">
									<input type="hidden" id="id" name="id" value="${project.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">项目名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${project.name}" placeholder="请输入项目名称">
										</div>
										<div class="form-group">
											<label for="projectKey">ProjectKey</label>
											<input type="text" class="form-control" id="projectKey" name="projectKey" value="${project.projectKey}" placeholder="请输入ProjectKey">
										</div>
										<div class="form-group">
											<label for="ip">IP地址</label>
											<input type="text" class="form-control" id="ip" name="ip" value="${project.ip}" placeholder="请输入IP地址">
										</div>
										<div class="form-group">
											<label for="threshold">报警阈值</label>
											<input type="text" class="form-control" id="threshold" name="threshold" value="${project.threshold}" placeholder="请输入报警阈值">
										</div>
										<div class="form-group">
											<label for="limitNum">短信上限</label>
											<input type="text" class="form-control" id="limitNum" name="limitNum" value="${project.limitNum}" placeholder="请输入短信上限">
										</div>
										<div class="form-group">
											<label for="email">邮箱</label>
											<input type="text" class="form-control" id="email" name="email" value="${project.email}" placeholder="请输入邮箱">
										</div>
										<div class="form-group">
											<label for="mobile">手机号</label>
											<input type="text" class="form-control" id="mobile" name="mobile" value="${project.mobile}" placeholder="请输入手机号">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Project.toList();">取消</button>
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