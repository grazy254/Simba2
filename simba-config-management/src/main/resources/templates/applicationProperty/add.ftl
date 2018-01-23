<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/applicationProperty/applicationProperty.js"></script>
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
									<h3 class="box-title">新增应用配置表</h3>
								</div>
								<form role="form" onsubmit="return ApplicationProperty.checkForm();" id="form" action="${base}/applicationProperty/add">
									<div class="box-body">
										<div class="form-group">
											<label for="name">应用名</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入应用名">
										</div>
										<div class="form-group">
											<label for="templateId">模板</label>
											<select id="templateId" name="templateId" onchange="ApplicationProperty.setTemplate(this)">
												<#list templateList as templateLists>
													<option  value="${templateLists.id}"> ${templateLists.name}</option>
												</#list>
											</select>
										</div>
										
										<div class="form-group">
											<label for="dev">开发版配置</label>
											<textarea  class="form-control" id="dev" name="dev"  placeholder="请输入开发版配置" rows="20">
											
											</textarea>
										</div>
										<div class="form-group">
											<label for="prod">生产环境配置</label>
											<textarea class="form-control" id="prod" name="prod"  placeholder="请输入生产环境配置" rows="20">
											
											</textarea>
										</div>
										<div class="form-group">
											<label for="test">测试版配置</label>
											<textarea class="form-control" id="test" name="test"  placeholder="请输入测试版配置" rows="20">
											
											</textarea>
										</div>
										
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ApplicationProperty.toList();">取消</button>
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