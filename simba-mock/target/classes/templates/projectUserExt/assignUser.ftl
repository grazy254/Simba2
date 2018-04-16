<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
		<script type="text/javascript" src="${base}/js/project/project.js"></script>
		<script type="text/javascript" src="${base}/js/projectUser/projectUserExt.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<!--<input type="hidden" id="account" name="account" value="${account}" />-->
				<section class="content">
					<div class="row">
						<!-- /.col -->
						<div class="col-md-12">
							<div class="box box-primary">
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<div class="mailbox-controls">
											<!-- Check all button -->
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="ProjectUserExt.assignUser(${Session['projectId']});"><i class="fa fa-wrench"></i>
                分配</button>
											<button type="button" class="btn btn-default btn-sm" onclick="top.hideModal();"><i class="fa fa-remove"></i>取消</button>
											<div class="pull-right">

											</div>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>账号</th>
												<th>名字</th>
											</tr>
										</thead>
										<tbody>
											<#list userlistAll as user>
												<tr>
													<td><input type="checkbox" name="user" value="${user.account}" id="${user.account}"></td>
													<td>${user.account}</td>
													<td>${user.name}</td>
												</tr>
											</#list>
										</tbody>
									</table>
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

	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			CheckBox.init();
			setTimeout("CheckBox.bindCheckAll();", 1000);
			setTimeout("initChecked();", 1000);
		});

		function initChecked() { 
			<#list userlistByProject as assignUser >
				$('#${assignUser.account}').iCheck('check'); 
			</#list>
		}

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