<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/smartGroup/smartGroup.js"></script>
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
									<h3 class="box-title">修改分组表</h3>
								</div>
								<form role="form" onsubmit="return SmartGroup.checkForm();" id="form" action="${base}/smartGroup/update">
									<input type="hidden" id="id" name="id" value="${smartGroup.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">分组名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${smartGroup.name}" placeholder="请输入分组名称">
										</div>
										<div class="form-group">
											<label for="description">分组描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${smartGroup.description}" placeholder="请输入分组描述">
										</div>
										<div class="form-group">
											<label for="status">分组状态</label>
											<input type="text" class="form-control" id="status" name="status" value="${smartGroup.status}" placeholder="请输入分组状态">
										</div>
										<div class="form-group">
											<label for="type">分组类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${smartGroup.type}" placeholder="请输入分组类型">
										</div>
										<div class="form-group">
											<label for="creater">分组创建者</label>
											<input type="text" class="form-control" id="creater" name="creater" value="${smartGroup.creater}" placeholder="请输入分组创建者">
										</div>
										<div class="form-group">
											<label for="createTime">createTime</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${smartGroup.createTime}" placeholder="请输入createTime">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="SmartGroup.toList();">取消</button>
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
		});
	</script>

</html>