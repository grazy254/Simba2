<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/userProject/project.js"></script>
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
								<form role="form" onsubmit="return Project.checkForm();" id="form" action="${base}/userProject/update">
									<input type="hidden" id="id" name="id" value="${project.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="code">编码</label>
											<input type="text" class="form-control" id="code" name="code" value="${project.code}" placeholder="请输入编码">
										</div>
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${project.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="projectKey">加密密钥</label>
											<input type="text" class="form-control" id="projectKey" name="projectKey" value="${project.projectKey}" placeholder="请输入加密密钥">
										</div>
										<div class="form-group">
											<label for="loginSuccessUrl">登录成功后的回调地址</label>
											<input type="text" class="form-control" id="loginSuccessUrl" name="loginSuccessUrl" value="${project.loginSuccessUrl}" placeholder="请输入登录成功后的回调地址">
										</div>
										<div class="form-group">
											<label for="forgetBackUrl">忘记密码后的回调url地址</label>
											<input type="text" class="form-control" id="forgetBackUrl" name="forgetBackUrl" value="${project.forgetBackUrl}" placeholder="请输入忘记密码后的回调url地址">
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