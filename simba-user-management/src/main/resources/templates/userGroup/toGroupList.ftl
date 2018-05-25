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
		<script type="text/javascript" src="${base}/js/userGroup/userGroup.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="table-responsive">
									<div>
										<p>用户:${smartUser.account}</p>
									</div>
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>分组名称</th>
												<th>分组描述</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<#list list as userGroup>
												<tr>
													<td>${userGroup.name}</td>
													<td>${userGroup.description}</td>
													<td>
														<button type="button" class="btn btn-default btn-sm" onclick="UserGroup.group(${userGroup.id},${smartUser.id});"><i class="fa fa-pencil-square-o"></i>添加进分组</button>
													</td>
												</tr>
											</#list>
										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
								</div>
								<div>

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
		$(document).ready(function() {});
	</script>

</html>