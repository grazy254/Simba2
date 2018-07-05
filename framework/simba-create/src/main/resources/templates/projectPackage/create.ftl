<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/projectPackage/projectPackage.js"></script>
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
									<h3 class="box-title">项目打包</h3>
								</div>
								<form role="form" onsubmit="return ProjectPackage.checkForm();" id="form" action="${base}/projectPackage/projectPackage" method="post">
									<div class="box-body">
										<div class="form-group">
											<label for="versionNo">版本号</label>
											<select class="form-control" id="versionNo" name="versionNo">
												<#list versions as version>
													<option value="${version.versionNo}">${version.versionNo}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="projectCode">项目名称(英文)</label>
											<input type="text" class="form-control" id="projectCode" name="projectCode" placeholder="项目名称(英文)" value="simba">
										</div>
										<div class="form-group">
											<label for="packageName">包名(英文)</label>
											<input type="text" class="form-control" id="packageName" name="packageName" placeholder="包名(英文)" value="com.simba">
										</div>
										<div class="form-group">
											<label for="account">超级管理员账号(英文)</label>
											<input type="text" class="form-control" id="account" name="account" placeholder="超级管理员账号(英文)" value="admin">
										</div>
										<div class="form-group">
											<label for="pwd">超级管理员密码(英文)</label>
											<input type="text" class="form-control" id="pwd" name="pwd" placeholder="超级管理员密码(英文)" value="admin123">
										</div>
										<div class="form-group">
											<label for="defaultPwd">普通用户密码(英文)</label>
											<input type="text" class="form-control" id="defaultPwd" name="defaultPwd" placeholder="普通用户密码(英文)" value="123456">
										</div>
										<div class="form-group">
											<label for="encryptKey">加密秘钥(英文)</label>
											<input type="text" class="form-control" id="encryptKey" name="encryptKey" placeholder="加密秘钥(英文)" value="simba">
										</div>
										<div class="form-group">
											<label for="adminPort">管理系统端口号(数字)</label>
											<input type="text" class="form-control" id="adminPort" name="adminPort" placeholder="管理系统端口号(数字)" value="8888">
										</div>
										<div class="form-group">
											<label for="userPort">用户系统端口号(数字)</label>
											<input type="text" class="form-control" id="userPort" name="userPort" placeholder="用户系统端口号(数字)" value="8889">
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="submit" class="btn btn-success">打包</button>
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
		$(document).ready(function() {});
	</script>

</html>