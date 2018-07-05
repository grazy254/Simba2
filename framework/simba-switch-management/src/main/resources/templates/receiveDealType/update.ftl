<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/receiveDealType/receiveDealType.js"></script>
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
									<h3 class="box-title">修改处理接收消息类型</h3>
								</div>
								<form role="form" onsubmit="return ReceiveDealType.checkForm();" id="form" action="${base}/receiveDealType/update">
									<input type="hidden" id="id" name="id" value="${receiveDealType.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${receiveDealType.name}" placeholder="请输入名称">
										</div>
										<div class="form-group">
											<label for="beanId">Bean ID</label>
											<input type="text" class="form-control" id="beanId" name="beanId" value="${receiveDealType.beanId}" placeholder="请输入Bean ID">
										</div>
										<div class="form-group">
											<label for="sync">同步</label>
											<select id="sync" name="sync" class="form-control">
												<option value="0">否</option>
												<option value="1">是</option>
											</select>
										</div>
										<div class="form-group">
											<label for="description">描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${receiveDealType.description}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="ext">扩展属性</label>
											<input type="text" class="form-control" id="ext" name="ext" value="${receiveDealType.ext}" placeholder="请输入扩展属性">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ReceiveDealType.toList();">取消</button>
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
			$("#sync").val("${receiveDealType.sync}");
		});
	</script>

</html>