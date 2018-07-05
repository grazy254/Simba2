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
		<script type="text/javascript" src="${base}/js/devProject/devProject.js"></script>
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
									<h3 class="box-title">绑定服务器</h3>
								</div>
								<!-- /.box-header -->
								<input id="projectId" name="projectId" value="${id}" type="hidden" />
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="DevProject.bindServers();"><i class="fa fa-retweet"></i>
                绑定</button>
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="DevProject.cancelBindServers();"><i class="fa fa-remove"></i>
                取消</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>服务器名称</th>
												<th>IP</th>
												<th>端口号</th>
											</tr>
										</thead>
										<tbody>
											<#list servers as projectServer>
												<tr>
													<td><input type="checkbox" name="projectServer" value="${projectServer.id}" id="${projectServer.id}"></td>
													<td>${projectServer.name}</td>
													<td>${projectServer.ip}</td>
													<td>${projectServer.port}</td>
												</tr>
											</#list>
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
			<div id="errInfo" style="color: red;"></div>
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
			<#list bindServers as serverId>
				$("#${serverId}").attr("checked","checked");
			</#list>
			CheckBox.init();
			setTimeout("CheckBox.bindCheckAll();", 1000);
		});
		
		function showInfo(info) {
			$("#errInfo").html(info);
			$("#errInfo").fadeIn();
			setTimeout("hideInfo();", 1500);
		}

		function hideInfo() {
			$("#errInfo").fadeOut();
		}
	</script>

</html>