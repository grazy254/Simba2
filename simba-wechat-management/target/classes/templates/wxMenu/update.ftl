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
		<script type="text/javascript" src="${base}/js/wxMenu/wxMenu.js"></script>
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
									<h3 class="box-title">修改微信菜单</h3>
								</div>
								<form role="form" onsubmit="return WxMenu.checkForm();" id="form" action="${base}/wxMenu/update">
									<input type="hidden" id="id" name="id" value="${wxMenu.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="text">菜单名</label>
											<input type="text" class="form-control" id="text" name="text" value="${wxMenu.text}" placeholder="请输入菜单名">
										</div>
										<div class="form-group">
											<label for="orderNo">排序号</label>
											<input type="text" class="form-control" id="orderNo" name="orderNo" value="${wxMenu.orderNo}" placeholder="请输入排序号">
										</div>
										<div class="form-group">
											<label for="menuKey">菜单KEY值</label>
											<input type="text" class="form-control" id="menuKey" name="menuKey" value="${wxMenu.menuKey}" placeholder="请输入菜单KEY值">
										</div>
										<div class="form-group">
											<label for="url">菜单URL地址</label>
											<input type="text" class="form-control" id="url" name="url" value="${wxMenu.url}" placeholder="请输入菜单URL地址">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<select class="form-control" id="type" name="type">
												<#list types as type>
													<option value="${type.type}">[${type.type}]${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="mediaId">素材ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${wxMenu.mediaId}" placeholder="请输入素材ID">
										</div>
										<div class="form-group">
											<label for="appid">小程序的appid</label>
											<input type="text" class="form-control" id="appid" name="appid" value="${wxMenu.appid}" placeholder="请输入小程序的appid">
										</div>
										<div class="form-group">
											<label for="pagepath">小程序的页面路径</label>
											<input type="text" class="form-control" id="pagepath" name="pagepath" value="${wxMenu.pagepath}" placeholder="请输入小程序的页面路径">
										</div>
										<div class="form-group">
											<label for="parentName">父微信菜单</label>
											<input type="hidden" id="parentID" name="parentID" value="${wxMenu.parentID}" />
											<input type="text" onclick="$('#tree').fadeToggle();" class="form-control" id="parentName" name="parentName" value="${parentName}" placeholder="请选择父微信菜单">
											<div id="tree" style="display: none;"></div>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="WxMenu.toList();">取消</button>
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
			WxMenu.initSelectWxMenuTree($("#parentID").val(), $("#parentName").val());
			$("#type").val("${wxMenu.type}");
		});
	</script>

</html>