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
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<input type="hidden" id="fansId" name="fansId" value="${fansId}" />
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-body no-padding">
									<div class="mailbox-controls">

										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.executeSetTag();"><i class="fa fa-wrench"></i>
                分配</button>
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.cancelSetTag();"><i class="fa fa-remove"></i>
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
												<th>标签名称</th>
											</tr>
										</thead>
										<tbody>
											<#list allTagList as tag>
												<tr>
													<td><input type="checkbox" name="tagId" id="${tag.id}" value="${tag.id}"></td>
													<td>${tag.name}</td>
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
			<!-- /.row -->
			<div id="errInfo" style="color: red;"></div>
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
			CheckBox.init();
			setTimeout("CheckBox.bindCheckAll();", 1000);
			setTimeout("initChecked();", 1000);
		});

		function initChecked() {
			<#list tagFansList as tagFans>
			$('#${tagFans.tagId}').iCheck('check');
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