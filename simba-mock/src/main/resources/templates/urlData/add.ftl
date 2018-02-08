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
		<script type="text/javascript" src="${base}/js/urlData/urlData.js"></script>
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
									<h3 class="box-title">添加项目数据</h3>
								</div>
								<form role="form" onsubmit="return UrlData.checkForm();" id="form" action="${base}/urlData/add">
									<div class="box-body">
										<div class="form-group">
											<label for="projectId">项目编号</label>
											<input type="text" class="form-control" id="projectId" name="projectId" placeholder="请输入项目编号>
										</div>
										<div class="form-group">
											<label for="url">路径</label>
											<input type="text" class="form-control" id="url" name="url" placeholder="请输入路径">
										</div>
										<div class="form-group">
											<label for="data">数据</label>
											<textarea class="form-control" id="data" name="data" rows="22"></textarea>
										</div>
										<div class="form-group">
											<label for="description">描述</label>
											<input type="text" class="form-control" id="description" name="description" placeholder="请输入描述">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="UrlData.toBackList();">取消</button>
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
			UrlData.initAddUrlForm(${Session['projectId']});
		});
	</script>

</html>