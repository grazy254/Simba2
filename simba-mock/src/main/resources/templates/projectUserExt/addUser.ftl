<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
		<script type="text/javascript" src="${base}/js/project/project.js"></script>
		<script type="text/javascript" src="${base}/js/projectUser/projectUserExt.js"></script>
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
									<h3 class="box-title">新增人员</h3><br/>
								</div>
								<form role="form" onsubmit="return ProjectUserExt.checkForm();" id="form" action="${base}/projectUser/addUser">
									<div class="box-body">
										<div class="form-group">
											<label for="account">账号</label>
											<input type="text" class="form-control" id="account" name="account" placeholder="请输入用户账号">
										</div>
										<div class="form-group">
											<label for="name">项目编号</label>
											<input type="text" class="form-control" id="projectId" name="projectId" placeholder="请输入项目编号">
										</div>
										<div class="form-group">
											<label for="type">权限类型</label>
											<select class="form-control" id="type" name="type">
												<option value="1">创建者</option>
												<option value="2">开发者</option>
											</select>
										</div>
									</div>
									<!-- /.box-body -->
									<input type="hidden" id="currentProjectId" name="currentProjectId" value="${Session['projectId']}" />
									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ProjectUserExt.toListUser('${projectId}');">取消</button>
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
			ProjectUserExt.initAddForm("${Session['projectId']}", "${Session['sessUser'].account}");
		});
	</script>

</html>