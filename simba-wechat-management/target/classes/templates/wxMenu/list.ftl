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
		<script type="text/javascript" src="${base}/js/wxMenu/wxMenu.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-3">
							<div id="tree"></div>
							<!-- /.box -->
						</div>
						<!-- /.col -->
						<div class="col-md-9">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">微信菜单管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">

									<div class="mailbox-controls">
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="WxMenu.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										<button type="button" class="btn btn-default btn-sm" onclick="WxMenu.batchDelete();"><i class="fa fa-remove"></i>删除</button>
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="WxMenu.publishMenuToWx();"><i class="fa fa-level-up"></i>
                发布到微信服务器</button>
										</div>
									</div>
									<!-- /.pull-right -->

								</div>
								<input type="hidden" id="parentID" name="parentID" value="${parentID}" />
								<input type="hidden" id="parentName" name="parentName" value="${parentName}" />
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>菜单名</th>
												<th>排序号</th>
												<th>菜单KEY值</th>
												<th>菜单URL地址</th>
												<th>类型</th>
												<th>素材ID</th>
												<th>小程序的appid</th>
												<th>小程序的页面路径</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
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
			WxMenu.initWxMenuList();
			WxMenu.initWxMenuTree($("#parentID").val(), $("#parentName").val());
		});
	</script>

</html>