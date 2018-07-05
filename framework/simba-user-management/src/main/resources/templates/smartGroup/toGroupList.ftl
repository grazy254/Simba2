<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/smartGroup/smartGroup.js"></script>
		<script type="text/javascript" src="${base}/js/smartUser/smartUser.js"></script>
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
									<h3 class="box-title">分组管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<div class="form-group">
											<label for="id">用户id:${smartUser.id}</label>
											<label for="name">用户昵称:${smartUser.name}</label>
											<label for="account">用户账号:${smartUser.account}</label>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>分组名称</th>
												<th>分组描述</th>
												<th>操作</th>
											</tr>
											<#list list as smartGroup>
	<tr>
		<td>${smartGroup.name}</td>
		<td>${smartGroup.description}</td>
		<td>
		<button type="button" class="btn btn-default btn-sm" onclick="SmartUser.addUser2Group(${smartGroup.id},${smartUser.id});"><i class="fa fa-plus"></i>加入该分组</button>
		</td>
	</tr>
</#list>
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
		});
	</script>

</html>