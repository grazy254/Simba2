<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/devProject/devProject.js"></script>
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
									<h3 class="box-title">新增项目</h3>
								</div>
								<form role="form" onsubmit="return DevProject.checkForm();" id="form" action="${base}/devProject/add">
									<div class="box-body">
										<div class="form-group">
											<label for="code">编号</label>
											<input type="text" class="form-control" id="code" name="code" placeholder="请输入编号">
										</div>
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="versionType">版本管理类型(svn/git)</label>
											<select class="form-control" id="versionType" name="versionType">
												<#list types as type>
													<option value="${type.getName()}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="account">账号</label>
											<input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
										</div>
										<div class="form-group">
											<label for="pwd">密码</label>
											<input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码">
										</div>
										<div class="form-group">
											<label for="versionUrl">版本管理地址</label>
											<input type="text" class="form-control" id="versionUrl" name="versionUrl" placeholder="请输入版本管理地址">
										</div>
										<div class="form-group">
											<label for="packageCommandFile">打包命令文件路径</label>
											<input type="text" class="form-control" id="packageCommandFile" name="packageCommandFile" placeholder="请输入打包命令文件路径">
										</div>
										<div class="form-group">
											<label for="startParams">服务启动参数</label>
											<input type="text" class="form-control" id="startParams" name="startParams" placeholder="请输入服务启动参数">
										</div>
										<div class="form-group">
											<label for="notifyEmails">通知邮件地址列表</label>
											<input type="text" class="form-control" id="notifyEmails" name="notifyEmails" placeholder="请输入通知邮件地址列表">
										</div>
										<div id="targetFiles">
											<div class="form-group">
												<label>打包结果文件路径:</label>
												<input type="text" class="form-control" name="targetFile" placeholder="请输入打包结果文件路径">
												<button type="button" class="btn btn-default btn-sm" onclick="DevProject.deleteRow(this);"><i class="fa fa-remove"></i>删除</button>
											</div>
										</div>
										<button type="button" id="addRowButton" class="btn btn-default btn-sm checkbox-toggle" onclick="DevProject.addRow();"><i class="fa fa-plus"></i>
               					 新增</button>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="DevProject.toList();">取消</button>
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