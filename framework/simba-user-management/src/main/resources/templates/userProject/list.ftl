<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/userProject/project.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">项目管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="code">编码:</label>
										<input type="text" id="code" name="code" placeholder="请输入编码">
										<label for="name">名称:</label>
										<input type="text" id="name" name="name" placeholder="请输入名称">
										<label for="account">账号:</label>
										<input type="text" id="account" name="account" placeholder="请输入账号">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Project.search();"><i class="fa fa-search"></i>
                						查询</button>
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Project.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
											<button type="button" class="btn btn-default btn-sm" onclick="Project.batchDelete();"><i class="fa fa-remove"></i>删除</button>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>编码</th>
												<th>名称</th>
												<th>加密密钥</th>
												<th>登录成功后的回调地址</th>
												<th>忘记密码后的回调url地址</th>
												<th>时间</th>
												<th>创建者账号</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
								</div>
								<!-- /.mail-box-messages -->
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
			Project.initProjectList(0, Page.size);
		});
	</script>

</html>