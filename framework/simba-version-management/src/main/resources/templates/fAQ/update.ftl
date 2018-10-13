<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/fAQ/fAQ.js"></script>
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
									<h3 class="box-title">修改常见问题管理</h3>
								</div>
								<form role="form" onsubmit="return FAQ.checkForm();" id="form" action="${base}/fAQ/update">
									<input type="hidden" id="id" name="id" value="${fAQ.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="title">问题名称</label>
											<input type="text" class="form-control" id="title" name="title" value="${fAQ.title}" placeholder="请输入问题名称">
										</div>
										<div class="form-group">
											<label for="text">问题内容</label>
											<input type="text" class="form-control" id="text" name="text" value="${fAQ.text}" placeholder="请输入问题内容">
										</div>
										<div class="form-group">
											<label for="type">问题类型</label>
											<select id="type" name="type">
												<#list typeList as typeLists>
													<option  value="${typeLists.id}"> ${typeLists.type}</option>
												</#list>
											</select>
										</div>
										
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="FAQ.toList();">取消</button>
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